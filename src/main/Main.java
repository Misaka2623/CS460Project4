package main;

import bean.Address;
import bean.Category;
import bean.Member;
import bean.Person;
import bean.Product;
import dao.AddressDao;
import dao.AddressDaoImpl;
import dao.CategoryDao;
import dao.CategoryDaoImpl;
import dao.MemberDao;
import dao.MemberDaoImpl;
import dao.PersonDao;
import dao.PersonDaoImpl;
import dao.ProductDao;
import dao.ProductDaoImpl;
import dao.SaleDao;
import dao.SaleDaoImpl;
import dao.SubSaleDao;
import dao.SubSaleDaoImpl;
import dao.WarehouseDao;
import dao.WarehouseDaoImpl;
import util.Calculator;
import util.Encryption;
import view.TextView;
import view.View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final View view = new TextView();
    private static final AddressDao addressDao = new AddressDaoImpl();
    private static final CategoryDao categoryDao = new CategoryDaoImpl();
    private static final MemberDao memberDao = new MemberDaoImpl();
    private static final PersonDao personDao = new PersonDaoImpl();
    private static final ProductDao productDao = new ProductDaoImpl();
    private static final SaleDao saleDao = new SaleDaoImpl();
    private static final SubSaleDao subSaleDao = new SubSaleDaoImpl();
    private static final WarehouseDao warehouseDao = new WarehouseDaoImpl();
    private static long userId;

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        view.newPage();
        view.greet();
        recognizeIdentity();
    }

    private static void recognizeIdentity() {
        view.newPage();
        int option = view.showIdentityView();
        switch (option) {
            case 0:
                view.newPage();
                view.exit();
                return;
            case 1:
                // user
                signInOrUp();
                break;
            case 2:
                // manager
                manageDatabase();
                break;
            default:
                throw new IllegalStateException();
        }
        recognizeIdentity();
    }

    private static void signInOrUp() {
        view.newPage();
        int option = view.showSignView();
        switch (option) {
            case 0:
                return;
            case 1:
                // sign in
                signIn();
                break;
            case 2:
                // sign up
                signUp();
                break;
            default:
                throw new IllegalStateException();
        }
        signInOrUp();
    }

    private static void signIn() {
        view.newPage();
        String username = view.requireUsername();
        String password = view.requirePassword();
        boolean valid = memberDao.checkUsernameAndPassword(username, Encryption.encrypt(password));
        if (valid) {
            view.showSignInSuccessView();
            userId = memberDao.getMemberIdByUsername(username);
            userMain(username);
        } else {
            view.showSignInFailView();
            signInOrUp();
        }
    }

    private static void signUp() {
        view.newPage();

        Member member = new Member();
        Person person = new Person();
        Address address = new Address();

        member.setUsername(view.requireUsername());
        if (memberDao.containsUsername(member.getUsername())) {
            view.showDuplicateUsernameView();
            signInOrUp();
            return;
        }
        member.setPassword(Encryption.encrypt(view.requirePassword()));
        member.setReward(0);
        member.setSuperMember(0);
        person.setFirstName(view.requireFirstName());
        person.setLastName(view.requireLastName());
        person.setGender(view.requireGender());
        person.setBirthday(view.requireBirthday());
        person.setPhone(view.requirePhoneNumber());
        address.setLine1(view.requireLine1());
        String line2 = view.requireLine2();
        address.setLine2(line2);
        address.setLine3(line2 == null ? null : view.requireLine3());
        address.setCity(view.requireCity());
        address.setState(view.requireState());
        address.setPostalCode(view.requirePostalCode());

        long addressId = addressDao.insert(address);
        person.setAddressId(addressId);

        long personId = personDao.insert(person);
        member.setPersonId(personId);

        userId = memberDao.insert(member);

        view.showSignUpSuccessView();

        userMain(member.getUsername());
    }

    private static void userMain(String username) {
        view.newPage();
        view.showGreet(username);
        int option = view.showUserActionView();
        switch (option) {
            case 0:
                // log out
                return;
            case 1:
                // shopping
                shopping();
                break;
            case 2:
                // become super member
                joinSuperMember();
                break;
            default:
                throw new IllegalStateException();
        }
        userMain(username);
    }

    private static void shopping() {
        view.newPage();

        Map<Product, Integer> products = productDao.getAllProducts();
        Map<Long, Integer> cart = new HashMap<>();
        addProduct(products, cart);

        String paymentMethod = view.requirePaymentMethod();
        saleDao.insert(userId, paymentMethod, cart);

        Map<Product, Integer> shoppingList =
                cart.keySet().stream().collect(Collectors.toMap(productDao::get, cart::get, (k, v) -> v));
        double totalPrice = Calculator.calculateTotalPrice(shoppingList, memberDao.isSuperMember(userId));
        view.showShoppingResult(totalPrice, shoppingList);
    }

    private static void addProduct(Map<Product, Integer> products, Map<Long, Integer> cart) {
        int option = view.showShoppingAction();
        switch (option) {
            case 0:
                return;
            case 1:
                view.showProductList(products);
                break;
            case 2:
                long productId = view.requireProductId();
                Product fakeProduct = new Product(productId);
                if (!products.containsKey(fakeProduct)) {
                    view.showProductIdNotFoundView(productId);
                    break;
                }
                int amount = view.requireProductAmount();
                int stock = products.get(fakeProduct);
                if (stock < amount) {
                    view.showAddToCartFailView(productId, stock);
                } else {
                    cart.put(productId, cart.getOrDefault(productId, 0) + amount);
                }
                break;
            default:
                throw new IllegalStateException();
        }
        addProduct(products, cart);
    }

    private static void joinSuperMember() {
        view.newPage();
        boolean joined = view.showJoinMembershipView();
        if (joined) {
            memberDao.joinSuperMember(userId);
            view.showJoinMembershipSuccessView();
        }
    }

    private static void manageDatabase() {
        int option = view.showManagerMainView();
        switch (option) {
            case 0:
                return;
            case 1:
                // address
                manageAddress();
                break;
            case 2:
                // category
                manageCategory();
                break;
            case 3:
                // employee
                manageEmployee();
                break;
            case 4:
                // group
                manageGroup();
                break;
            case 5:
                // member
                manageMember();
                break;
            case 6:
                // person
                managePerson();
                break;
            case 7:
                // product
                manageProduct();
                break;
            case 8:
                // sale
                manageSale();
                break;
            case 9:
                // sub sale
                manageSubSale();
                break;
            case 10:
                // supplier
                manageSupplier();
                break;
            case 11:
                // warehouse
                manageWarehouse();
                break;
            default:
                throw new IllegalStateException();
        }
    }

    private static void manageAddress() {
        view.newPage();
        int option = view.manageAddress();
        switch (option) {
            case 0:
                return;
            case 1:
                // add address record
                Address address = new Address();
                address.setLine1(view.requireLine1());
                String line2 = view.requireLine2();
                address.setLine2(line2);
                address.setLine3(line2 == null ? null : view.requireLine3());
                address.setCity(view.requireCity());
                address.setState(view.requireState());
                address.setPostalCode(view.requirePostalCode());

                addressDao.insert(address);
                view.showInsertAddressSuccessView();
                break;
            case 2:
                // delete address record
                long addressId = view.requireAddressId();
                boolean success = addressDao.delete(addressId);
                if (success) {
                    view.deleteAddressSuccess();
                } else {
                    view.deleteAddressFail();
                }
                break;
            case 3:
                // list all address records
                List<Address> addresses = addressDao.getAll();
                view.listAddresses(addresses);
                break;
            default:
                throw new IllegalStateException();
        }
        manageAddress();
    }

    private static void manageCategory() {
        view.newPage();
        int option = view.manageCategory();
        switch (option) {
            case 0:
                return;
            case 1: {
                // add category record
                Category category = new Category();
                category.setName(view.requireCategoryName());
                long categoryId = categoryDao.insert(category);
                if (categoryId != -1) {
                    view.addCategorySuccess();
                } else {
                    view.addCategoryFail();
                }
                break;
            }
            case 2:
                // delete category record
                long categoryId = view.requireCategoryId();
                boolean success = categoryDao.delete(categoryId);
                if (success) {
                    view.deleteCategorySuccess();
                } else {
                    view.deleteCategoryFail();
                }
                break;
            case 3:
                // list all category records
                // TODO: 12/6/20
                break;
            default:
                throw new IllegalStateException();
        }
        manageCategory();
    }

    private static void manageEmployee() {
        view.newPage();
        int option = view.manageEmployee();
        switch (option) {
            case 0:
                return;
            case 1:
                // add employee record
                // TODO: 12/6/20
                break;
            case 2:
                // delete employee record
                // TODO: 12/6/20
                break;
            case 3:
                // list all employee records
                // TODO: 12/6/20
                break;
            default:
                throw new IllegalStateException();
        }
        manageEmployee();
    }

    private static void manageGroup() {
        view.newPage();
        int option = view.manageGroup();
        switch (option) {
            case 0:
                return;
            case 1:
                // add group record
                // TODO: 12/6/20
                break;
            case 2:
                // delete group record
                // TODO: 12/6/20
                break;
            case 3:
                // list all group records
                // TODO: 12/6/20
                break;
            default:
                throw new IllegalStateException();
        }
        manageGroup();
    }

    private static void manageMember() {
        view.newPage();
        int option = view.manageMember();
        switch (option) {
            case 0:
                return;
            case 1:
                // add member record
                // TODO: 12/6/20
                break;
            case 2:
                // delete member record
                // TODO: 12/6/20
                break;
            case 3:
                // list all member records
                // TODO: 12/6/20
                break;
            default:
                throw new IllegalStateException();
        }
        manageMember();
    }

    private static void managePerson() {
        view.newPage();
        int option = view.managePerson();
        switch (option) {
            case 0:
                return;
            case 1:
                // add person record
                // TODO: 12/6/20
                break;
            case 2:
                // delete person record
                // TODO: 12/6/20
                break;
            case 3:
                // list all person records
                // TODO: 12/6/20
                break;
            default:
                throw new IllegalStateException();
        }
        managePerson();
    }

    private static void manageProduct() {
        view.newPage();
        int option = view.manageProduct();
        switch (option) {
            case 0:
                return;
            case 1:
                // add product record
                // TODO: 12/6/20
                break;
            case 2:
                // delete product record
                // TODO: 12/6/20
                break;
            case 3:
                // list all product records
                // TODO: 12/6/20
                break;
            default:
                throw new IllegalStateException();
        }
        manageProduct();
    }

    private static void manageSale() {
        view.newPage();
        int option = view.manageSale();
        switch (option) {
            case 0:
                return;
            case 1:
                // add sale record
                // TODO: 12/6/20
                break;
            case 2:
                // delete sale record
                // TODO: 12/6/20
                break;
            case 3:
                // list all sale records
                // TODO: 12/6/20
                break;
            default:
                throw new IllegalStateException();
        }
        manageSale();
    }

    private static void manageSubSale() {
        view.newPage();
        int option = view.manageSubSale();
        switch (option) {
            case 0:
                return;
            case 1:
                // add sub sale record
                // TODO: 12/6/20
                break;
            case 2:
                // delete sub sale record
                // TODO: 12/6/20
                break;
            case 3:
                // list all sub sale records
                // TODO: 12/6/20
                break;
            default:
                throw new IllegalStateException();
        }
        manageSubSale();
    }

    private static void manageSupplier() {
        view.newPage();
        int option = view.manageSupplier();
        switch (option) {
            case 0:
                return;
            case 1:
                // add supplier record
                // TODO: 12/6/20
                break;
            case 2:
                // delete supplier record
                // TODO: 12/6/20
                break;
            case 3:
                // list all supplier records
                // TODO: 12/6/20
                break;
            default:
                throw new IllegalStateException();
        }
        manageSupplier();
    }

    private static void manageWarehouse() {
        view.newPage();
        int option = view.manageWarehouse();
        switch (option) {
            case 0:
                return;
            case 1:
                // add warehouse record
                // TODO: 12/6/20
                break;
            case 2:
                // delete warehouse record
                // TODO: 12/6/20
                break;
            case 3:
                // list all warehouse records
                // TODO: 12/6/20
                break;
            default:
                throw new IllegalStateException();
        }
        manageWarehouse();
    }
}
