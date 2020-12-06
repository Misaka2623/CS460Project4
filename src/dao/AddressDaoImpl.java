package dao;

import bean.Address;

public class AddressDaoImpl extends BaseDao implements AddressDao {
    @Override
    public long insert(Address address) {
        address.setAddressId(generateId());
        // TODO: 12/1/20 insert address into database
        // if id, line1, city, state, post code has none then return -1;
        Connection connect = getConnection();
        long id = address.getAddressId();
        String line1 = address.getLine1();
        String line2 = address.getLine2();
        String line3 = address.getLine3();
        String city = address.getCity();
        String state = address.getState();
        String post_code = address.getPostalCode();

        if(id == none || line1 == none || city == none || state == none || post_code == none)
            return -1;

        String query = "INSERT INTO address VALUES (id,line1,line2,line3,city,state,post_code);";
        executeSql(query);

        return address.getAddressId();
    }

    @Override
    protected String getTableName() {
        return Address.class.getSimpleName().toLowerCase();
    }
}
