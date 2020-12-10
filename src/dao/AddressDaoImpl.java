package dao;

import bean.Address;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AddressDaoImpl extends BaseDao implements AddressDao {
    @Override
    public long insert(Address address) {
        address.setAddressId(generateId());

        executeSql("INSERT INTO \"address\" VALUES (?,?,?,?,?,?,?)",
                address.getAddressId(), address.getLine1(), address.getLine2(), address.getLine3(), address.getCity(),
                address.getState(), address.getPostalCode());

        return address.getAddressId();
    }

    @Override
    public boolean delete(long addressId) {
        return executeUpdate("DELETE FROM \"address\" WHERE \"address_id\"=?", addressId) != 0;
    }

    @Override
    public List<Address> getAll() {
        try (ResultSet resultSet = executeSql("SELECT * FROM \"address\"")) {
            List<Address> addresses = new LinkedList<>();
            while (resultSet.next()) {
                Address address = new Address();
                address.setAddressId(resultSet.getLong("address_id"));
                address.setLine1(resultSet.getString("line1"));
                address.setLine2(resultSet.getString("line2"));
                address.setLine3(resultSet.getString("line3"));
                address.setCity(resultSet.getString("city"));
                address.setState(resultSet.getString("state"));
                address.setPostalCode(resultSet.getString("postal_code"));
                addresses.add(address);
            }
            return addresses;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected String getTableName() {
        return Address.class.getSimpleName().toLowerCase();
    }
}
