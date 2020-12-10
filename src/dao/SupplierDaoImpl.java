package dao;

public class SupplierDaoImpl extends BaseDao implements SupplierDao {
	public long insert(Supplier supplier) {
		 return Supplier.setSupplierId();
	}
	
	public boolean boolean delete(long Supplier) {
		//TODO: check if delete sucess
		int answer = executeUpdate("DELETE FROM supplier WHERE supplier_id = (?)", supplierId);
        if(answer == 0)
            return false;
        return true;
	}
	
	public List<Supplier> getAll(){
		//TODO: implement getAll
        List<Supplier> all = new List<Supplier>();
        Result answer = executeSql("SELECT * from \"supplier\");
        while(answer.next())
        {
            long supplier_id = answer.getLong();
            String name = answer.getString();
            long address_id = answer.getLong();
            long contact_person = answer.getLong();
            Supplier each = Supplier(supplier_id, name, address_id, contact_person);
            total.add(each);
        }
        return total;
}
