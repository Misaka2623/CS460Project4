package dao;

import bean.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CategoryDaoImpl extends BaseDao implements CategoryDao {
    public long insert(Category category) {
        category.setCategoryId(generateId());

        if (category.getName() == null) {
            return 0;
        }
        ResultSet answer = executeSql("INSERT INTO \"category\" VALUES (?,?)",
                category.getCategoryId(), category.getName());

        return category.getCategoryId();
    }

    public boolean delete(long categoryId) {
        int answer = executeUpdate("DELETE FROM category WHERE category_id = (?)", categoryId);
        return answer != 0;
    }

    public long insert(String name) {
        long categoryId = generateId();
        ResultSet answer = executeSql("INSERT INTO \"category\" VALUES (?,?)", categoryId, name);
        return categoryId;
    }

    public List<Category> getAll() {
        //TODO: implement getAll
        List<Category> all = new LinkedList<>();
        try (ResultSet answer = executeSql("SELECT * from category")) {
            while (answer.next()) {
                long id = answer.getLong("category_id");
                String name = answer.getString("name");
                Category each = new Category(id, name);
                all.add(each);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    @Override
    protected String getTableName() {
        return Category.class.getSimpleName().toLowerCase();
    }
}
