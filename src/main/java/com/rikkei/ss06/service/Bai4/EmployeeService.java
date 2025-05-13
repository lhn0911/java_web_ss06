package com.rikkei.ss06.service.Bai4;

import com.rikkei.ss06.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    boolean create(Employee employee);
    Employee findById(int id);
    boolean update(Employee employee);
    boolean delete(int id);
}
