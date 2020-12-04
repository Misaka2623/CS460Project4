package dao;

import bean.Product;

import java.util.Map;

public interface ProductDao {
    /**
     * calculate the amount of the product by specified product id.
     *
     * @param productId the id of the product which should be calculated.
     * @return the amount of the product.
     */
    int calculateProductAmount(long productId);

    /**
     * get the price of the product whose id is {@code productId}.
     *
     * @param productId the id of the product.
     * @return the price of the product.
     */
    double getPriceOfProduct(long productId);

    /**
     * grab all products which have at least 1 in stock into a list.
     *
     * @return a map that contains all products in the database. It's key is a product, and it's value is the amount
     * of the related product.
     */
    Map<Product, Integer> getAllProducts();
}
