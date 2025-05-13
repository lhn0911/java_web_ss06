package com.rikkei.ss06.dao.Bai4;

import com.rikkei.ss06.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
    boolean create(Employee employee);
    Employee findById(int id);
    boolean update(Employee employee);
    boolean delete(int id);
}
