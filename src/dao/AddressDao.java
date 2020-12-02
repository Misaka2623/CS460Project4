package dao;

import bean.Address;

public interface AddressDao {
    /**
     * insert a line of specified address object into the table. some fields of the specified address might be empty.
     * the id field of the specified address is not filled, so to implement this method should find the appropriate
     * id of this address.
     *
     * @param address the address that should be inserted.
     * @return the id of the address.
     */
    long insert(Address address);
}
