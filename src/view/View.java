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

import java.util.List;
import java.util.Map;

public interface View {
    void newPage();

    void greet();

    int selectIdentity();

    void exit();

    int signInOrUp();

    int managerMain();

    String requireUsername();

    String requirePassword();

    void signInSuccess();

    void signInFail();

    Member requireMember();

    Person requirePerson();

    Address requireAddress();

    void signUpSuccess();

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

    void greetUser(String firstName, String lastName);

    int userAction();

    void addAddressFail();

    void addAddressSuccess();

    long requireAddressId();

    void deleteAddressSuccess();

    void deleteAddressFail();

    void listAddresses(List<Address> addresses);

    Category requireCategory();

    void addCategoryFail();

    void addCategorySuccess();

    long requireCategoryId();

    void deleteCategorySuccess();

    void deleteCategoryFail();

    void listCategories(List<Category> categories);

    Employee requireEmployee();

    void addEmployeeFail();

    void addEmployeeSuccess();

    long requireEmployeeId();

    void deleteEmployeeSuccess();

    void deleteEmployeeFail();

    void listEmployees(List<Employee> employees);

    Group requireGroup();

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

    long requireProductId();

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

    String requirePaymentMethod();

    void shoppingResult(double totalPrice, Map<Product, Integer> shoppingList);

    boolean joinMembership();

    void joinMembershipSuccess();

    int shoppingAction();

    void listProducts(Map<Product, Integer> products);

    void productIdNotFound(long productId);

    int requireProductAmount();

    void addToCartFail(long productId, int stock);
}
