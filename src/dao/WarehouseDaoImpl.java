package dao;

public class WarehouseDaoImpl extends BaseDao implements WarehouseDao {
	@Override
	public long insert(Warehouse warehouse) {
		// return warehouseId
		warehouseID.setWarehouseId(generateId());
		long warehouse_id = warehouse.getWarehouseId();
		long supplierId = warehouse.getSupplierId();
		long productId = warehouse.getProductId();
		Date incomingDate = warehouse.getIncomingDate();
		double purchasePrice = warehouse.getPurchasePrice();
        int amount = warehouse.getAmount();
        
        if(amount == null) {
        	return 0;
        }
        
        String query = String.format("INSERT INFO warehouse VALUES (d%, d%, s%, d%, d%)", supplierId, productId, incomingDate, purchasePrice, amount )
	}
}