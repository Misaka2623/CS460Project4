package dao;

import java.util.Map;

public interface SubSaleDao {
    /**
     * insert a line of sub sale by given arguments.
     *
     * @param parentId  the id of parent sale.
     * @param productId the id of the product of this sub sale.
     * @param amount    the amount of the product.
     * @return the if of this sub sale.
     */
    long insert(long parentId, long productId, int amount);

    /**
     * find all sub sales that has specified saleId field, and return a map (key: productId, value: amount).
     *
     * @param saleId the sale id to search.
     * @return a map (key: productId, value: amount)
     */
    Map<Long, Integer> getShoppingListBySaleId(long saleId);
}
