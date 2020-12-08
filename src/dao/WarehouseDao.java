package dao;

import bean.Warehouse;

import java.util.List;

public interface WarehouseDao {
    /**
     * insert a new line to add a specified product
     *
     * @param a specified product should be inserted
     * @return the ID of the product
     */
    long insert(Warehouse warehouse);

    /**
     * insert a new line to add a specified product
     *
     * @param warehouseId Long Integer Related warehouse ID
     * @return whether it's success or failure
     */
    boolean delete(long warehouseId);

    List<Warehouse> getAll();
}
