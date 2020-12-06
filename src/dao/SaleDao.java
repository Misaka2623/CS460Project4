package dao;

import java.util.Map;

public interface SaleDao {
    /**
     * insert a line of sale by given arguments.
     *
     * @param memberId      the id of the member who bought these products.
     * @param paymentMethod the payment method of this transaction.
     * @param cart          a shopping cart (key: productId, value: amount of the product)
     * @return the id of the sale.
     */
    long insert(long memberId, String paymentMethod, Map<Long, Integer> cart);

    /**
     * insert a line in product table
     *
     * @param saleId       long type of sale id
     * @return                whether it's success
     */
    boolean delete(long saleId);

    /**
     * get the total price of a transaction by the saleId.
     *
     * @param saleId the saleId.
     * @return the total price.
     */
    double getTotalPriceById(long saleId);
}
