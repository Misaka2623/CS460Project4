package dao;

import java.sql.ResultSet;
import java.util.Map;

public class SaleDaoImpl extends BaseDao implements SaleDao {
    @Override
    public long insert(long memberId, String paymentMethod, Map<Long, Integer> cart){
        //TODO: insert sale table and sub_sale table
        int saleID = generateId();

        //missing total price
        //ResultSet answer = executeSql("INSERT INTO \"sale\" VALUES (?,CURRENT_TIMESTAMP,?,?,?)",
        //        saleID, paymentMethod, memberId, );

        return saleID;
    }

    @Override
    public boolean delete(long saleId){
        //TODO: delete sale record by saleID and the corresponding sub_sale recording
        //String query = "DELETE FROM sale WHERE sale_id = " + String.valueOf(saleId);
        ResultSet answer = executeSql("DELETE FROM sale WHERE sale_id = (?)", saleId);
        return 0;
    }

    @Override
    public  double getTotalPriceById(long saleId){
        //TODO: get total price
        ResultSet answer = executeSql("SELECT total_price FROM sale WHERE sale_id = (?)", saleId);
        return answer.getDouble("total_price");
    }
}
