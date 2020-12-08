package view;

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
import util.Gender;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface View {
    void greet();

    int selectIdentity();

    int signInOrUp();

    void signInSuccess();

    void signInFail();

    void signUpSuccess();

    void duplicateUsername();

    void greetUser(String firstName, String lastName);

    void listProducts(Map<Product, Integer> products);

    int shoppingAction();

    void addToCartFail(long productId, int stock);

    int userAction();

    void shoppingResult(double totalPrice, Map<Product, Integer> shoppingList);

    void productIdNotFound(long productId);

    boolean joinMembership();

    void joinMembershipSuccess();

    String requireUsername();

    String requirePassword();

    String requireFirstName();

    String requireLastName();

    Gender requireGender();

    Date requireBirthday();

    String requirePhoneNumber();

    String requireLine1();

    String requireLine2();

    String requireLine3();

    String requireCity();

    String requireState();

    String requirePostalCode();

    long requireProductId();

    int requireProductAmount();

    String requirePaymentMethod();

    void newPage();

    void exit();

    int managerMain();

    int manageAddress();

    int manageCategory();

    int manageEmployee();

    int manageGroup();

    int manageMember();

    int managePerson();

    int manageProduct();

    int manageSale();

    int manageSubSale();

    int manageSupplier();

    int manageWarehouse();

    void addAddressSuccess();

    long requireAddressId();

    void deleteAddressSuccess();

    void deleteAddressFail();

    void listAddresses(List<Address> addresses);

    String requireCategoryName();

    void addCategoryFail();

    void addCategorySuccess();

    long requireCategoryId();

    void deleteCategorySuccess();

    void deleteCategoryFail();

    void addAddressFail();

    Address requireAddress();

    Member requireMember();

    Person requirePerson();

    void listCategories(List<Category> categories);

    Employee requireEmployee();

    void addEmployeeFail();

    void addEmployeeSuccess();

    long requireEmployeeId();

    void deleteEmployeeSuccess();

    void deleteEmployeeFail();

    void listEmployees(List<Employee> employees);

    Group requireGroup();

    Category requireCategory();

    void addGroupFail();

    void addGroupSuccess();

    long requireGroupId();

    void deleteGroupSuccess();

    void deleteGroupFail();

    void listGroups(List<Group> groups);

    void addMemberFail();

    void addMemberSuccess();

    long requireMemberId();

    void deleteMemberSuccess();

    void deleteMemberFail();

    void listMembers(List<Member> members);

    void addPersonFail();

    void addPersonSuccess();

    long requirePersonId();

    void deletePersonSuccess();

    void deletePersonFail();

    void listPeople(List<Person> people);

    Product requireProduct();

    void addProductFail();

    void addProductSuccess();

    void deleteProductSuccess();

    void deleteProductFail();

    void listProducts(List<Product> products);

    Sale requireSale();

    void addSaleFail();

    void addSaleSuccess();

    long requireSaleId();

    void deleteSaleSuccess();

    void deleteSaleFail();

    void listSales(List<Sale> sales);

    SubSale requireSubSale();

    void addSubSaleFail();

    void addSubSaleSuccess();

    long requireSubSaleId();

    void deleteSubSaleSuccess();

    void deleteSubSaleFail();

    void listSubSales(List<SubSale> subSales);

    Supplier requireSupplier();

    void addSupplierFail();

    void addSupplierSuccess();

    long requireSupplierId();

    void deleteSupplierSuccess();

    void deleteSupplierFail();

    void listSuppliers(List<Supplier> suppliers);

    Warehouse requireWarehouse();

    void addWarehouseFail();

    void addWarehouseSuccess();

    long requireWarehouseId();

    void deleteWarehouseSuccess();

    void deleteWarehouseFail();

    void listWarehouses(List<Warehouse> warehouses);
}
