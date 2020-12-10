package dao;

public class CategoryDaoImpl extends BaseDao implements CategoryDao {
    public long insert(Category category){
        category.setCategoryId(generateId());

        if( category.getName() == null)
            return 0;
        ResultSet answer = executeSql("INSERT INTO \"category\" VALUES (?,?)",
        category.getCategoryId(), category.getName());

        return category.getCategoryId();
    }

    public boolean delete(long categoryId){
        //TODO: check if delete sucess
        int answer = executeUpdate("DELETE FROM category WHERE category_id = (?)", categoryId);
        if(answer == 0)
            return false;
        return true;
    }

    public long insert(String name){
        long categoryId = generateId();
        ResultSet answer = executeSql("INSERT INTO \"category\" VALUES (?,?)",categoryId, name);
        return categoryId;
    }

    public List<Category> getAll(){
        //TODO: implement getAll
        List<Category> all = new List<category>();
        return all;
    }
}
