package dao;

import bean.Category;

public interface CategoryDao {
    long insert(Category category);

    boolean delete(long categoryId);
}
