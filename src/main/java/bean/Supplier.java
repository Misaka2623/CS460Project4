package bean;

import java.util.Objects;

public class Supplier {
    private int supplierId;
    private String name;
    private String address;
    private String contactPerson;

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
                "sid=" + supplierId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                '}';
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
}
