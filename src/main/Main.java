package main;

import bean.Address;
import bean.Member;
import bean.Person;
import bean.Product;
import dao.AddressDao;
import dao.AddressDaoImpl;
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
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final View view = new TextView();
    private static final AddressDao addressDao = new AddressDaoImpl();
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
                // TODO: 12/1/20
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
        address.setLine2(view.requireLine2());
        address.setLine3(view.requireLine3());
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
                // TODO: 12/4/20
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
                int amount = view.requireProductAmount();
                int stock = products.get(new Product(productId));
                if (stock < amount) {
                    view.showAddToCartFailView(productId, stock);
                } else {
                    cart.put(productId, cart.getOrDefault(productId, 0) + amount);
                }
        }
        addProduct(products, cart);
    }
}
