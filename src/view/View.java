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
    /**
     * switch to a new page.
     */
    void newPage();

    /**
     * greet to the user.
     */
    void greet();

    /**
     * require the user enter his identity:
     * 0 - quit the app
     * 1 - user
     * 2 - manager
     *
     * @return the inputted option.
     */
    int selectIdentity();

    /**
     * exit this app.
     */
    void exit();

    /**
     * require the user enter one of the following options:
     * 0 - back
     * 1 - sign in
     * 2 - sign up
     *
     * @return the inputted option.
     */
    int signInOrUp();

    /**
     * require the user enter one of the following options:
     * 0 - back
     * 1 - manage address
     * 2 - manage category
     * 3 - manage employee
     * 4 - manege group
     * 5 - manage member
     * 6 - manage person
     * 7 - manage product
     * 8 - manage sale
     * 9 - manage sub sale
     * 10 - manage supplier
     * 11 - manage warehouse
     *
     * @return the inputted option.
     */
    int managerMain();

    /**
     * require the user input the username.
     *
     * @return
     */
    String requireUsername();

    /**
     * require the user input the password.
     *
     * @return the inputted password.
     */
    String requirePassword();

    /**
     * show the sign in is succeed.
     */
    void signInSuccess();

    /**
     * show the sign in is failed.
     */
    void signInFail();

    /**
     * show the sign up is failed.
     */
    void signUpFail();

    /**
     * require the user input the information of a member.
     *
     * @return the inputted member.
     */
    Member requireMember();

    /**
     * require the user input the information of a person.
     *
     * @return the inputted person.
     */
    Person requirePerson();

    /**
     * require the user input the information of an address.
     *
     * @return the inputted address.
     */
    Address requireAddress();

    /**
     * show the sign up is succeed.
     */
    void signUpSuccess();

    /**
     * manage the address table by require the user enter one of the following options:
     * 0 - back
     * 1 - add record
     * 2 - delete record
     * 3 - list all records.
     *
     * @return the inputted option.
     */
    int manageAddress();

    /**
     * manage the category table by require the user enter one of the following options:
     * 0 - back
     * 1 - add record
     * 2 - delete record
     * 3 - list all records.
     *
     * @return the input option.
     */
    int manageCategory();

    /**
     * manage the employee table by require the user enter one of the following options:
     * 0 - back
     * 1 - add record
     * 2 - delete record
     * 3 - list all records.
     *
     * @return the input option.
     */
    int manageEmployee();

    /**
     * manage the group table by require the user enter one of the following options:
     * 0 - back
     * 1 - add record
     * 2 - delete record
     * 3 - list all records.
     *
     * @return the input option.
     */
    int manageGroup();

    /**
     * manage the member table by require the user enter one of the following options:
     * 0 - back
     * 1 - add record
     * 2 - delete record
     * 3 - list all records.
     *
     * @return the input option.
     */
    int manageMember();

    /**
     * manage the person table by require the user enter one of the following options:
     * 0 - back
     * 1 - add record
     * 2 - delete record
     * 3 - list all records.
     *
     * @return the input option.
     */
    int managePerson();

    /**
     * manage the product table by require the user enter one of the following options:
     * 0 - back
     * 1 - add record
     * 2 - delete record
     * 3 - list all records.
     *
     * @return the input option.
     */
    int manageProduct();

    /**
     * manage the sale table by require the user enter one of the following options:
     * 0 - back
     * 1 - add record
     * 2 - delete record
     * 3 - list all records.
     *
     * @return the input option.
     */
    int manageSale();

    /**
     * manage the sub_sale table by require the user enter one of the following options:
     * 0 - back
     * 1 - add record
     * 2 - delete record
     * 3 - list all records.
     *
     * @return the input option.
     */
    int manageSubSale();

    /**
     * manage the supplier table by require the user enter one of the following options:
     * 0 - back
     * 1 - add record
     * 2 - delete record
     * 3 - list all records.
     *
     * @return the input option.
     */
    int manageSupplier();

    /**
     * manage the warehouse table by require the user enter one of the following options:
     * 0 - back
     * 1 - add record
     * 2 - delete record
     * 3 - list all records.
     *
     * @return the input option.
     */
    int manageWarehouse();

    /**
     * greet the user for using this app.
     *
     * @param firstName the first name of the user.
     * @param lastName  the last name of the user.
     */
    void greetUser(String firstName, String lastName);

    /**
     * require the user enter one of the following options:
     * 0 - logout
     * 1 - shopping
     * 2 - join membership
     *
     * @return the input option.
     */
    int userAction();

    /**
     * show adding address is failed.
     */
    void addAddressFail();

    /**
     * show adding address is succeed.
     */
    void addAddressSuccess();

    /**
     * require the user input the id of an address.
     *
     * @return the inputted id of an address.
     */
    long requireAddressId();

    /**
     * show the deleting address is succeed.
     */
    void deleteAddressSuccess();

    /**
     * show the deleting address is failed.
     */
    void deleteAddressFail();

    /**
     * list all the given addresses.
     *
     * @param addresses the addresses that should be listed.
     */
    void listAddresses(List<Address> addresses);

    /**
     * require the user input the information of a category.
     *
     * @return the inputted category.
     */
    Category requireCategory();

    /**
     * show adding category is failed.
     */
    void addCategoryFail();

    /**
     * show adding category is succeed.
     */
    void addCategorySuccess();

    /**
     * require the user input the id of a category.
     *
     * @return the inputted id of a category.
     */
    long requireCategoryId();

    /**
     * show the deleting category is succeed.
     */
    void deleteCategorySuccess();

    /**
     * show the deleting category is failed.
     */
    void deleteCategoryFail();

    /**
     * list all the given categories.
     *
     * @param categories the categories that should be listed.
     */
    void listCategories(List<Category> categories);

    /**
     * require the user input the information of an employee.
     *
     * @return the inputted employee.
     */
    Employee requireEmployee();

    /**
     * show the adding employee is failed.
     */
    void addEmployeeFail();

    /**
     * show the adding employee is succeed.
     */
    void addEmployeeSuccess();

    /**
     * require the user input the id of an employee.
     *
     * @return the inputted id of an employee.
     */
    long requireEmployeeId();

    /**
     * show the deleting employee is succeed.
     */
    void deleteEmployeeSuccess();

    /**
     * show the deleting employee is failed.
     */
    void deleteEmployeeFail();

    /**
     * list all the given employees.
     *
     * @param employees the employees that should be listed.
     */
    void listEmployees(List<Employee> employees);

    /**
     * require the user input the information of the group.
     *
     * @return the inputted group.
     */
    Group requireGroup();

    /**
     * show the adding group is failed.
     */
    void addGroupFail();

    /**
     * show the adding group is succeed.
     */
    void addGroupSuccess();

    /**
     * require the user input the id of a group.
     *
     * @return the inputted id of the group.
     */
    long requireGroupId();

    /**
     * show the deleting group is succeed.
     */
    void deleteGroupSuccess();

    /**
     * show the deleting group is failed.
     */
    void deleteGroupFail();

    /**
     * list all the given groups.
     *
     * @param groups the groups that should be listed.
     */
    void listGroups(List<Group> groups);

    /**
     * show the adding member is failed.
     */
    void addMemberFail();

    /**
     * show the adding member is succeed.
     */
    void addMemberSuccess();

    /**
     * require the user input the id of a member.
     *
     * @return the inputted id of the member.
     */
    long requireMemberId();

    /**
     * show the deleting member is succeed.
     */
    void deleteMemberSuccess();

    /**
     * show the deleting member is failed.
     */
    void deleteMemberFail();

    /**
     * list all the given members.
     *
     * @param members the members that should be listed.
     */
    void listMembers(List<Member> members);

    /**
     * show the adding person is failed.
     */
    void addPersonFail();

    /**
     * show the adding person is succeed.
     */
    void addPersonSuccess();

    /**
     * require the user input the id of the person.
     *
     * @return the inputted id of the person.
     */
    long requirePersonId();

    /**
     * show the deleting person is succeed.
     */
    void deletePersonSuccess();

    /**
     * show the deleting person is failed.
     */
    void deletePersonFail();

    /**
     * list all the given people.
     *
     * @param people the people that should be listed.
     */
    void listPeople(List<Person> people);

    /**
     * require the user input the information of a product.
     *
     * @return the inputting product.
     */
    Product requireProduct();

    /**
     * show the adding product is failed.
     */
    void addProductFail();

    /**
     * show the adding product is succeed.
     */
    void addProductSuccess();

    /**
     * require the user input the id of the product.
     *
     * @return the inputted id of the product.
     */
    long requireProductId();

    /**
     * show the deleting product is succeed.
     */
    void deleteProductSuccess();

    /**
     * show the deleting product is failed.
     */
    void deleteProductFail();

    /**
     * list all the given products.
     *
     * @param products the products that should be listed.
     */
    void listProducts(List<Product> products);

    /**
     * require the user input the information of the sale.
     *
     * @return the inputted sale.
     */
    Sale requireSale();

    /**
     * show the adding sale is failed.
     */
    void addSaleFail();

    /**
     * show the adding sale is succeed.
     */
    void addSaleSuccess();

    /**
     * require the user input the id of the sale.
     *
     * @return the inputted id of the sale.
     */
    long requireSaleId();

    /**
     * show the deleting sale is succeed.
     */
    void deleteSaleSuccess();

    /**
     * show the deleting sale is failed.
     */
    void deleteSaleFail();

    /**
     * list all given sales.
     *
     * @param sales the sales that should be listed.
     */
    void listSales(List<Sale> sales);

    /**
     * require the user input the information of the sub sale.
     *
     * @return the inputted sub sale.
     */
    SubSale requireSubSale();

    /**
     * show the adding sub sale is failed.
     */
    void addSubSaleFail();

    /**
     * show the adding sub sale is succeed.
     */
    void addSubSaleSuccess();

    /**
     * require the user input the id of the sub sale.
     *
     * @return the id of the sub sale.
     */
    long requireSubSaleId();

    /**
     * show the deleting sub sale is succeed.
     */
    void deleteSubSaleSuccess();

    /**
     * show the deleting sub sale is failed.
     */
    void deleteSubSaleFail();

    /**
     * list all given sub sales.
     *
     * @param subSales the sub sales that should be listed.
     */
    void listSubSales(List<SubSale> subSales);

    /**
     * require the user input the information of a supplier.
     *
     * @return the inputted supplier.
     */
    Supplier requireSupplier();

    /**
     * show the adding supplier is failed.
     */
    void addSupplierFail();

    /**
     * show the adding supplier is succeed.
     */
    void addSupplierSuccess();

    /**
     * require the user input the id of supplier.
     *
     * @return the id of supplier.
     */
    long requireSupplierId();

    /**
     * show the deleting supplier is succeed.
     */
    void deleteSupplierSuccess();

    /**
     * show the deleting supplier is failed.
     */
    void deleteSupplierFail();

    /**
     * list all given suppliers.
     *
     * @param suppliers the suppliers that should be listed.
     */
    void listSuppliers(List<Supplier> suppliers);

    /**
     * require the user input the information of a warehouse.
     *
     * @return the inputted warehouse.
     */
    Warehouse requireWarehouse();

    /**
     * show the adding warehouse record is failed.
     */
    void addWarehouseFail();

    /**
     * show the adding warehouse record is succeed.
     */
    void addWarehouseSuccess();

    /**
     * require the user input the warehouse id.
     *
     * @return the id of the warehouse.
     */
    long requireWarehouseId();

    /**
     * show the deleting warehouse record is succeed.
     */
    void deleteWarehouseSuccess();

    /**
     * show the deleting warehouse record is failed.
     */
    void deleteWarehouseFail();

    /**
     * list all given warehouses.
     *
     * @param warehouses the warehouses that should be listed.
     */
    void listWarehouses(List<Warehouse> warehouses);

    /**
     * require the user input his payment method.
     *
     * @return the inputted payment method.
     */
    String requirePaymentMethod();

    /**
     * show the recipe of the shopping.
     *
     * @param totalPrice   the total price of the shopping.
     * @param shoppingList a map that refers a shopping list (key: product, value: the bought amount).
     */
    void shoppingResult(double totalPrice, Map<Product, Integer> shoppingList);

    /**
     * ask the user to join the membership.
     *
     * @return {@code true} if the user wants to join the membership; {@code false} otherwise.
     */
    boolean joinMembership();

    /**
     * show the join membership is succeed.
     */
    void joinMembershipSuccess();

    /**
     * require the user enter one of the following options:
     * 0 - pay the bill
     * 1 - show product list
     * 2 - add product to cart
     *
     * @return the input options.
     */
    int shoppingAction();

    /**
     * list all the given products.
     *
     * @param products a map that refers products and its stock
     */
    void listProducts(Map<Product, Integer> products);

    /**
     * show the product id is not found.
     *
     * @param productId the id of the product.
     */
    void productIdNotFound(long productId);

    /**
     * require the user input the amount of the product.
     *
     * @return the amount of the product.
     */
    int requireProductAmount();

    /**
     * show the adding to cart is failed.
     *
     * @param productId the id of the product that should be added into the cart.
     * @param stock     the actual stock of the product.
     */
    void addToCartFail(long productId, int stock);
}
