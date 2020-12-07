package dao;

import bean.Warehouse;

public class WarehouseDaoImpl extends BaseDao implements WarehouseDao {
	/**
	 * insert a new line to add a specified product
	 * 
	 * @param a specified product should be inserted
	 * @return the ID of the product
	 */
	
	long insert(Warehouse warehouse);
}