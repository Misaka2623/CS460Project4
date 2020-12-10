package dao;

public class SubSaleDaoImpl extends BaseDao implements SubSaleDao {
	@Override
	public long insert(long parentId, long productId, int amount) {
		//TODO: insert sub_sale table
		subSale.setSubSaleId(generateId());
		
		ResultSet answer = executeSql("INSERT INTO \"subSale\" VALUES (?,?,?,?,?)", subSale.setSubSaleId(), subSale.setProductId(), subSale.setSaleId(), subSale.getPrice(), subSale.getAmount();
				      
        // return SubSaleId
        return subSale.getSubSaleId();
	}
	
	@Override
    public Map<Long, Integer> getShoppingListBySaleId(long saleId){
		Map<Long, Integer> total = new Map<Long, Integer>();
		List<SubSale> list = self.getAll();
		for(SubSale key: list) {
            if (total.containsKey(key) == false)
                total.put(key, 0);
            
            total.put(key, total.get(key) + 1);
        }
        return total;
	}
	
	public boolean boolean delete(long subSaleId) {
		//TODO: check if delete sucess
		int answer = executeUpdate("DELETE FROM sub_sale WHERE sub_sale_id = (?)", subSaleId);
        if(answer == 0)
            return false;
        return true;
	}
	
	public long insert(SubSale subSale) {
		 return subSale.setSubSaleId();
	}
	
	public List<SubSale> getAll(){
		//TODO: implement getAll
        List<SubSale> all = new List<subSale>();
        Result answer = executeSql("SELECT * from \"subSale\" ");
        while(answer.next())
        {
            long sub_sale_id = answer.getLong();
            long product_id = answer.getLong();
            long sale_id = answer.getDouble();
            long price = answer.getLong();
            double amount = answer.getLong();
            SubSale each = SubSale(sub_sale_id, product_id, sale_id, price, amount);
            total.add(each);
        }
        return total;
	}
}
