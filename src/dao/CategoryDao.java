package dao;

import bean.Category;

import java.util.List;

public interface CategoryDao {
    long insert(Category category);

    boolean delete(long categoryId);

    long insert(String name);

    List<Category> getAll();
}
