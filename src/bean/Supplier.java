package bean;

import java.util.Objects;

public class Supplier {
    private long supplierId;
    private String name;
    private long addressId;
    private long contactPerson;

    public Supplier() {
    }

    public Supplier(long supplierId, String name, long addressId, long contactPerson) {
        this.supplierId = supplierId;
        this.name = name;
        this.addressId = addressId;
        this.contactPerson = contactPerson;
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Supplier)) {
            return false;
        }
        Supplier supplier = (Supplier) o;
        return supplierId == supplier.supplierId;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", name='" + name + '\'' +
                ", addressId=" + addressId +
                ", contactPerson=" + contactPerson +
                '}';
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public long getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(long contactPerson) {
        this.contactPerson = contactPerson;
    }
}
