package com.rikkei.ss06.service.Bai4;

import com.rikkei.ss06.dao.Bai4.EmployeeDao;
import com.rikkei.ss06.dao.Bai4.EmployeeDaoImp;
import com.rikkei.ss06.model.Employee;

import java.util.List;

public class EmployeeServiceImp implements EmployeeService{
    private EmployeeDao employeeDao;

    public EmployeeServiceImp() {
        employeeDao = new EmployeeDaoImp();
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public boolean create(Employee employee) {
        return employeeDao.create(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    public boolean update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public boolean delete(int id) {
        return employeeDao.delete(id);
    }
}
