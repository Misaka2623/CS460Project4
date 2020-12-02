package dao;

import bean.Address;

public class AddressDaoImpl extends BaseDao implements AddressDao {
    @Override
    public long insert(Address address) {
        address.setAddressId(generateId());
        // TODO: 12/1/20
        return address.getAddressId();
    }

    @Override
    protected String getTableName() {
        return Address.class.getSimpleName().toLowerCase();
    }
}
