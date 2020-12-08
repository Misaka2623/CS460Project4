package dao;

import bean.Supplier;

import java.util.List;

public interface SupplierDao {
    long insert(Supplier supplier);

    boolean delete(long supplierId);

    List<Supplier> getAll();
}
