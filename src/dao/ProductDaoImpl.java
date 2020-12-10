package dao;

import java.util.Map;

import bean.Product;

public class ProductDaoImpl extends BaseDao implements ProductDao {
    @Override
    public long insert(Product product){
        product.setProductId(generateId());
        if( product.getName() == null)
            return 0;

        ResultSet answer = executeSql("INSERT INTO \"product\" VALUES (?,?,?,?,?)",
        product.getProductId(), product.getName(), product.getRetailPrice(), product.getCategoryId(), product.getMembershipDiscount());

        return product.getProductId();
    }

    @Override
    public boolean delete(long productId){
        int answer = executeUpdate("DELETE FROM product WHERE product_id = (?)", productId);
        if(answer == 0)
            return false;
        return true;
    }

    @Override
    public int calculateProductAmount(long productId){
        ResultSet answer = executeSql("SELECT count(*) FROM \"product\"  WHERE product_id = (?)", productId);
        answer.last();
        return answer.getRow();
    }

    @Override
    public double getPriceOfProduct(long productId){
        ResultSet answer = executeSql("SELECT retail_price from \"product\"  WHERE product_id = (?)", productId);
        return answer.getDouble();
    }

    @Override
    public Product get(long productId){
        //if return null then nothing 
        Result answer = executeSql("SELECT * from \"product\"  WHERE product_id = (?)", productId);
        Product product = null;
        if(answer.next())
        {
            long product_id = answer.getLong();
            String name = answer.getString();
            double retail_price = answer.getDouble();
            long category_id = answer.getLong();
            double membership_discount = answer.getDouble();
            product = Product(product_id, name, retail_price, category_id, membership_discount);
        }
        return product;
    }

    @Override
    public Map<Product, Integer> getAllProducts(){
        Map<Product, Integer> total = new Map<Product, Integer>(); 
        List<Product> list = self.getAll();
        for(Product key: list)
        {
            if (total.containsKey(key) == false)
                total.put(key, 0);
            
            total.put(key, total.get(key) + 1);
        }
        return total;
    }

    public  List<Product> getAll(){
        List<Product> total = new List<Product>();
        Result answer = executeSql("SELECT * from \"product\" ");
        while(answer.next())
        {
            long product_id = answer.getLong();
            String name = answer.getString();
            double retail_price = answer.getDouble();
            long category_id = answer.getLong();
            double membership_discount = answer.getDouble();
            Product each = Product(product_id, name, retail_price, category_id, membership_discount);
            total.add(each);
        }
        return total;

    }
}
