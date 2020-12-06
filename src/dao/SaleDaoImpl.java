package dao;

public class SaleDaoImpl extends BaseDao implements SaleDao {
    @Override
    public long insert(long memberId, String paymentMethod, Map<Long, Integer> cart){
        //TODO: insert sale table and sub_sale table
        return 0;
    }

    @Override
    public boolean delete(long saleId){
        //TODO: delete sale record by saleID and the corresponding sub_sale recording
        return 0;
    }

    @Override
    public  double getTotalPriceById(long saleId){
        //TODO: get total price
        return 0.0;
    }
}
