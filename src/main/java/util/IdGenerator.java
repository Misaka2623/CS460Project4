package util;

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
import org.springframework.jdbc.core.JdbcTemplate;

@SuppressWarnings("SqlResolve")
public class IdGenerator {
    public static long generateAddressId(JdbcTemplate jdbcTemplate) {
        return generateId(jdbcTemplate, Address.class.getSimpleName().toLowerCase());
    }

    public static long generateCategoryId(JdbcTemplate jdbcTemplate) {
        return generateId(jdbcTemplate, Category.class.getSimpleName().toLowerCase());
    }

    public static long generateEmployeeId(JdbcTemplate jdbcTemplate) {
        return generateId(jdbcTemplate, Employee.class.getSimpleName().toLowerCase());
    }

    public static long generateGroupId(JdbcTemplate jdbcTemplate) {
        return generateId(jdbcTemplate, Group.class.getSimpleName().toLowerCase());
    }

    public static long generateMemberId(JdbcTemplate jdbcTemplate) {
        return generateId(jdbcTemplate, Member.class.getSimpleName().toLowerCase());
    }

    public static long generatePersonId(JdbcTemplate jdbcTemplate) {
        return generateId(jdbcTemplate, Person.class.getSimpleName().toLowerCase());
    }

    public static long generateProductId(JdbcTemplate jdbcTemplate) {
        return generateId(jdbcTemplate, Product.class.getSimpleName().toLowerCase());
    }

    public static long generateSaleId(JdbcTemplate jdbcTemplate) {
        return generateId(jdbcTemplate, Sale.class.getSimpleName().toLowerCase());
    }

    public static long generateSubSaleId(JdbcTemplate jdbcTemplate) {
        return generateId(jdbcTemplate, SubSale.class.getSimpleName().toLowerCase());
    }

    public static long generateSupplierId(JdbcTemplate jdbcTemplate) {
        return generateId(jdbcTemplate, Supplier.class.getSimpleName().toLowerCase());
    }

    public static long generateWarehouseId(JdbcTemplate jdbcTemplate) {
        return generateId(jdbcTemplate, Warehouse.class.getSimpleName().toLowerCase());
    }

    private static long generateId(JdbcTemplate jdbcTemplate, String tableName) {
        Long id = jdbcTemplate.queryForObject("SELECT max(\"?\") FROM ?", Long.class,
                tableName + "_id", tableName);
        return id == null ? 0 : id + 1;
    }
}
