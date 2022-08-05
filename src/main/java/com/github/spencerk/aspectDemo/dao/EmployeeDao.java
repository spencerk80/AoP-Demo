package com.github.spencerk.aspectDemo.dao;

import com.github.spencerk.aspectDemo.exception.NonUniqueIdException;
import com.github.spencerk.aspectDemo.model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeDao {
    List<Employee> getAll();
    void saveEmployee(Employee employee);
    Employee getEmployee(UUID id) throws NonUniqueIdException;
    void updateEmployee(Employee employee);
    void deleteEmployee(UUID id) throws NonUniqueIdException;
}
