package dao;

public class ProductDaoImpl extends BaseDao implements ProductDao {
    @Override
    public long insert(Product product){
        return 0;
    }

    @Override
    public boolean delete(long productId){
        return 0;
    }

    @Override
    public int calculateProductAmount(long productId){
        return 0;
    }

    @Override
    public double getPriceOfProduct(long productId){
        return 0.0;
    }

    @Override
    public Product get(long productId){
        return null;
    }

    @Override
    public Map<Product, Integer> getAllProducts(){
        return null;
    }

}
