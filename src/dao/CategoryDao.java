package dao;

import bean.Category;

import java.util.List;

public interface CategoryDao {
    long insert(Category category);

    boolean delete(long categoryId);

    List<Category> getAll();
}
