package dao;

import bean.Warehouse;

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
	
	/**
	 * Record of the incoming date of a specified product
	 * 
	 * @param warehouseId
	 * @return incomingDate
	 */
	Date getIncomeDate(Date incomingDate);
	
	/**
	 * the recording of a purchase price for the goods
	 * 
	 * @param warehouseId
	 * @return purchasePrice
	 */
	double getPurchasePrice(double purchasePrice);
}
