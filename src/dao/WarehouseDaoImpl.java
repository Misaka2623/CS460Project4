package dao;

public class WarehouseDaoImpl extends BaseDao implements WarehouseDao {
	@Override
	public long insert(Warehouse warehouse) {
		 return warehouse.setWarehouseId();
		 }
	
	public boolean delete(long warehouseId) {
		//TODO: check if delete sucess
		int answer = executeUpdate("DELETE FROM warehouse WHERE warehouse_id = (?)", warehouseId);
        if(answer == 0)
            return false;
        return true;
	}
	
	public List<Warehouse> getAll(){
		//TODO: implement getAll
        List<Warehouse> all = new List<Warehouse>();
        Result answer = executeSql("SELECT * from \"warehouse\" ");
        while(answer.next())
        {
            long warehouse_id = answer.getLong();
            long supplier_id = answer.getLong();
            long product_id = answer.getLong();
            date incoming_date = answer.getDate();
            double purchase_price = answer.getDouble();
            int amount = answer.getInt();
            Warehouse each = Warehouse(warehouse_id, supplier_id, product_id, incoming_date, purchase_price);
            total.add(each);
        }
        return total;
}