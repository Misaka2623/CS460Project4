package dao;

import bean.Address;

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
    protected String getTableName() {
        return Address.class.getSimpleName().toLowerCase();
    }
}
