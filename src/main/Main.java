package main;

import bean.Address;
import bean.Category;
import bean.Employee;
import bean.Group;
import bean.Member;
import bean.Person;
import bean.Product;
import bean.Sale;
import bean.SubSale;
import bean.Supplier;
import bean.Warehouse;
import dao.AddressDao;
import dao.AddressDaoImpl;
import dao.CategoryDao;
import dao.CategoryDaoImpl;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import dao.GroupDao;
import dao.GroupDaoImpl;
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
import dao.SupplierDao;
import dao.SupplierDaoImpl;
import dao.WarehouseDao;
import dao.WarehouseDaoImpl;
import util.Calculator;
import view.TextView;
import view.View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static util.Encryption.encrypt;

public class Main {
    private static final View view = new TextView();

    private static final AddressDao addressDao = new AddressDaoImpl();
    private static final CategoryDao categoryDao = new CategoryDaoImpl();
    private static final EmployeeDao employeeDao = new EmployeeDaoImpl();
    private static final GroupDao groupDao = new GroupDaoImpl();
    private static final MemberDao memberDao = new MemberDaoImpl();
    private static final PersonDao personDao = new PersonDaoImpl();
    private static final ProductDao productDao = new ProductDaoImpl();
    private static final SaleDao saleDao = new SaleDaoImpl();
    private static final SubSaleDao subSaleDao = new SubSaleDaoImpl();
    private static final SupplierDao supplierDao = new SupplierDaoImpl();
    private static final WarehouseDao warehouseDao = new WarehouseDaoImpl();

    private static long memberId = 0;

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
        int option = view.selectIdentity();
        switch (option) {
            case 0:
                view.newPage();
                view.exit();
                return;
            case 1:
                signInOrUp();
                break;
            case 2:
                manageDatabase();
                break;
            default:
                throw new IllegalStateException();
        }
        recognizeIdentity();
    }

    private static void signInOrUp() {
        view.newPage();
        int option = view.signInOrUp();
        switch (option) {
            case 0:
                return;
            case 1:
                signIn();
                break;
            case 2:
                signUp();
                break;
            default:
                throw new IllegalStateException();
        }
        signInOrUp();
    }

    private static void manageDatabase() {
        int option = view.managerMain();
        switch (option) {
            case 0:
                return;
            case 1:
                manageAddress();
                break;
            case 2:
                manageCategory();
                break;
            case 3:
                manageEmployee();
                break;
            case 4:
                manageGroup();
                break;
            case 5:
                manageMember();
                break;
            case 6:
                managePerson();
                break;
            case 7:
                manageProduct();
                break;
            case 8:
                manageSale();
                break;
            case 9:
                manageSubSale();
                break;
            case 10:
                manageSupplier();
                break;
            case 11:
                manageWarehouse();
                break;
            default:
                throw new IllegalStateException();
        }
        manageDatabase();
    }

    private static void signIn() {
        view.newPage();
        String username = view.requireUsername();
        String password = view.requirePassword();
        boolean valid = memberDao.checkUsernameAndPassword(username, encrypt(password));
        if (valid) {
            view.signInSuccess();
            memberId = memberDao.getMemberIdByUsername(username);
            userMain();
        } else {
            view.signInFail();
        }
    }

    private static void signUp() {
        view.newPage();

        Member member = view.requireMember();
        Person person = view.requirePerson();
        Address address = view.requireAddress();

        long addressId = addressDao.insert(address);
        person.setAddressId(addressId);

        long personId = personDao.insert(person);
        member.setPersonId(personId);

        memberId = memberDao.insert(member);

        view.signUpSuccess();
        userMain();
    }

    private static void manageAddress() {
        view.newPage();
        int option = view.manageAddress();
        switch (option) {
            case 0:
                return;
            case 1:
                addAddress();
                break;
            case 2:
                deleteAddress();
                break;
            case 3:
                listAllAddresses();
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
            case 1:
                addCategory();
                break;
            case 2:
                deleteCategory();
                break;
            case 3:
                listAllCategories();
                break;
            default:
                throw new IllegalStateException();
        }
        manageCategory();
    }

    private static void manageEmployee() {
        view.newPage();
        int option = view.manageCategory();
        switch (option) {
            case 0:
                return;
            case 1:
                addEmployee();
                break;
            case 2:
                deleteEmployee();
                break;
            case 3:
                listAllEmployees();
                break;
            default:
                throw new IllegalStateException();
        }
        manageCategory();
    }

    private static void manageGroup() {
        view.newPage();
        int option = view.manageGroup();
        switch (option) {
            case 0:
                return;
            case 1:
                addGroup();
                break;
            case 2:
                deleteGroup();
                break;
            case 3:
                listAllGroups();
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
                addMember();
                break;
            case 2:
                deleteMember();
                break;
            case 3:
                listAllMembers();
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
                addPerson();
                break;
            case 2:
                deletePerson();
                break;
            case 3:
                listAllPeople();
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
                addProduct();
                break;
            case 2:
                deleteProduct();
                break;
            case 3:
                listAllProducts();
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
                addSale();
                break;
            case 2:
                deleteSale();
                break;
            case 3:
                listAllSales();
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
                addSubSale();
                break;
            case 2:
                deleteSubSale();
                break;
            case 3:
                listAllSubSales();
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
                addSupplier();
                break;
            case 2:
                deleteSupplier();
                break;
            case 3:
                listAllSuppliers();
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
                addWarehouse();
                break;
            case 2:
                deleteWarehouse();
                break;
            case 3:
                listAllWarehouses();
                break;
            default:
                throw new IllegalStateException();
        }
        manageWarehouse();
    }

    private static void userMain() {
        view.newPage();
        Member member = memberDao.get(memberId);
        Person person = personDao.get(member.getPersonId());
        view.greetUser(person.getFirstName(), person.getLastName());
        int option = view.userAction();
        switch (option) {
            case 0:
                return;
            case 1:
                shopping();
                break;
            case 2:
                joinMembership();
                break;
            default:
                throw new IllegalStateException();
        }
        userMain();
    }

    private static void addAddress() {
        view.newPage();
        Address address = view.requireAddress();
        long addressId = addressDao.insert(address);
        if (addressId == 0) {
            view.addAddressFail();
        } else {
            view.addAddressSuccess();
        }
    }

    private static void deleteAddress() {
        view.newPage();
        long addressId = view.requireAddressId();
        boolean success = addressDao.delete(addressId);
        if (success) {
            view.deleteAddressSuccess();
        } else {
            view.deleteAddressFail();
        }
    }

    private static void listAllAddresses() {
        view.newPage();
        List<Address> addresses = addressDao.getAll();
        view.listAddresses(addresses);
    }

    private static void addCategory() {
        view.newPage();
        Category category = view.requireCategory();
        long categoryId = categoryDao.insert(category);
        if (categoryId == 0) {
            view.addCategoryFail();
        } else {
            view.addCategorySuccess();
        }
    }

    private static void deleteCategory() {
        view.newPage();
        long categoryId = view.requireCategoryId();
        boolean success = categoryDao.delete(categoryId);
        if (success) {
            view.deleteCategorySuccess();
        } else {
            view.deleteCategoryFail();
        }
    }

    private static void listAllCategories() {
        view.newPage();
        List<Category> categories = categoryDao.getAll();
        view.listCategories(categories);
    }

    private static void addEmployee() {
        view.newPage();
        Employee employee = view.requireEmployee();
        long employeeId = employeeDao.insert(employee);
        if (employeeId == 0) {
            view.addEmployeeFail();
        } else {
            view.addEmployeeSuccess();
        }
    }

    private static void deleteEmployee() {
        view.newPage();
        long employeeId = view.requireEmployeeId();
        boolean success = employeeDao.delete(employeeId);
        if (success) {
            view.deleteEmployeeSuccess();
        } else {
            view.deleteEmployeeFail();
        }
    }

    private static void listAllEmployees() {
        view.newPage();
        List<Employee> employees = employeeDao.getAll();
        view.listEmployees(employees);
    }

    private static void addGroup() {
        view.newPage();
        Group group = view.requireGroup();
        long groupId = groupDao.insert(group);
        if (groupId == 0) {
            view.addGroupFail();
        } else {
            view.addGroupSuccess();
        }
    }

    private static void deleteGroup() {
        view.newPage();
        long groupId = view.requireGroupId();
        boolean success = groupDao.delete(groupId);
        if (success) {
            view.deleteGroupSuccess();
        } else {
            view.deleteGroupFail();
        }
    }

    private static void listAllGroups() {
        view.newPage();
        List<Group> groups = groupDao.getAll();
        view.listGroups(groups);
    }

    private static void addMember() {
        view.newPage();
        Member member = view.requireMember();
        long memberId = memberDao.insert(member);
        if (memberId == 0) {
            view.addMemberFail();
        } else {
            view.addMemberSuccess();
        }
    }

    private static void deleteMember() {
        view.newPage();
        long memberId = view.requireMemberId();
        boolean success = memberDao.delete(memberId);
        if (success) {
            view.deleteMemberSuccess();
        } else {
            view.deleteMemberFail();
        }
    }

    private static void listAllMembers() {
        view.newPage();
        List<Member> members = memberDao.getAll();
        view.listMembers(members);
    }

    private static void addPerson() {
        view.newPage();
        Person person = view.requirePerson();
        long personId = personDao.insert(person);
        if (personId == 0) {
            view.addPersonFail();
        } else {
            view.addPersonSuccess();
        }
    }

    private static void deletePerson() {
        view.newPage();
        long personId = view.requirePersonId();
        boolean success = personDao.delete(personId);
        if (success) {
            view.deletePersonSuccess();
        } else {
            view.deletePersonFail();
        }
    }

    private static void listAllPeople() {
        view.newPage();
        List<Person> people = personDao.getAll();
        view.listPeople(people);
    }

    private static void addProduct() {
        view.newPage();
        Product product = view.requireProduct();
        long productId = productDao.insert(product);
        if (productId == 0) {
            view.addProductFail();
        } else {
            view.addProductSuccess();
        }
    }

    private static void deleteProduct() {
        view.newPage();
        long productId = view.requireProductId();
        boolean success = productDao.delete(productId);
        if (success) {
            view.deleteProductSuccess();
        } else {
            view.deleteProductFail();
        }
    }

    private static void listAllProducts() {
        view.newPage();
        List<Product> products = productDao.getAll();
        view.listProducts(products);
    }

    private static void addSale() {
        view.newPage();
        Sale sale = view.requireSale();
        long saleId = saleDao.insert(sale);
        if (saleId == 0) {
            view.addSaleFail();
        } else {
            view.addSaleSuccess();
        }
    }

    private static void deleteSale() {
        view.newPage();
        long saleId = view.requireSaleId();
        boolean success = saleDao.delete(saleId);
        if (success) {
            view.deleteSaleSuccess();
        } else {
            view.deleteSaleFail();
        }
    }

    private static void listAllSales() {
        view.newPage();
        List<Sale> sales = saleDao.getAll();
        view.listSales(sales);
    }

    private static void addSubSale() {
        view.newPage();
        SubSale subSale = view.requireSubSale();
        long subSaleId = subSaleDao.insert(subSale);
        if (subSaleId == 0) {
            view.addSubSaleFail();
        } else {
            view.addSubSaleSuccess();
        }
    }

    private static void deleteSubSale() {
        view.newPage();
        long subSaleId = view.requireSubSaleId();
        boolean success = subSaleDao.delete(subSaleId);
        if (success) {
            view.deleteSubSaleSuccess();
        } else {
            view.deleteSubSaleFail();
        }
    }

    private static void listAllSubSales() {
        view.newPage();
        List<SubSale> subSales = subSaleDao.getAll();
        view.listSubSales(subSales);
    }

    private static void addSupplier() {
        view.newPage();
        Supplier supplier = view.requireSupplier();
        long supplierId = supplierDao.insert(supplier);
        if (supplierId == 0) {
            view.addSupplierFail();
        } else {
            view.addSupplierSuccess();
        }
    }

    private static void deleteSupplier() {
        view.newPage();
        long supplierId = view.requireSupplierId();
        boolean success = supplierDao.delete(supplierId);
        if (success) {
            view.deleteSupplierSuccess();
        } else {
            view.deleteSupplierFail();
        }
    }

    private static void listAllSuppliers() {
        view.newPage();
        List<Supplier> suppliers = supplierDao.getAll();
        view.listSuppliers(suppliers);
    }

    private static void addWarehouse() {
        view.newPage();
        Warehouse warehouse = view.requireWarehouse();
        long warehouseId = warehouseDao.insert(warehouse);
        if (warehouseId == 0) {
            view.addWarehouseFail();
        } else {
            view.addWarehouseSuccess();
        }
    }

    private static void deleteWarehouse() {
        view.newPage();
        long warehouseId = view.requireWarehouseId();
        boolean success = warehouseDao.delete(warehouseId);
        if (success) {
            view.deleteWarehouseSuccess();
        } else {
            view.deleteWarehouseFail();
        }
    }

    private static void listAllWarehouses() {
        view.newPage();
        List<Warehouse> warehouses = warehouseDao.getAll();
        view.listWarehouses(warehouses);
    }

    private static void shopping() {
        view.newPage();

        Map<Product, Integer> products = productDao.getAllProducts();
        Map<Long, Integer> cart = new HashMap<>();
        addProducts(products, cart);

        String paymentMethod = view.requirePaymentMethod();
        saleDao.insert(memberId, paymentMethod, cart);

        Map<Product, Integer> shoppingList =
                cart.keySet().stream().collect(Collectors.toMap(productDao::get, cart::get, (k, v) -> v));
        double totalPrice = Calculator.calculateTotalPrice(shoppingList, memberDao.isSuperMember(memberId));
        view.shoppingResult(totalPrice, shoppingList);
    }

    private static void joinMembership() {
        view.newPage();
        boolean success = view.joinMembership();
        if (success) {
            memberDao.joinSuperMember(memberId);
            view.joinMembershipSuccess();
        }
    }

    private static void addProducts(Map<Product, Integer> products, Map<Long, Integer> cart) {
        int option = view.shoppingAction();
        switch (option) {
            case 0:
                return;
            case 1:
                view.listProducts(products);
                break;
            case 2:
                addToCart(products, cart);
                break;
            default:
                throw new IllegalStateException();
        }
        addProducts(products, cart);
    }

    private static void addToCart(Map<Product, Integer> products, Map<Long, Integer> cart) {
        long productId = view.requireProductId();
        Product fakeProduct = new Product(productId);
        if (!products.containsKey(fakeProduct)) {
            view.productIdNotFound(productId);
        } else {
            int amount = view.requireProductAmount();
            int stock = products.get(fakeProduct);
            if (stock < amount) {
                view.addToCartFail(productId, stock);
            } else {
                cart.put(productId, cart.getOrDefault(productId, 0) + amount);
            }
        }
    }
}
