package com.github.spencerk.aspectDemo.dao;

import com.github.spencerk.aspectDemo.exception.NonUniqueIdException;
import com.github.spencerk.aspectDemo.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class EmployeeMemDao implements EmployeeDao {
    private List<Employee> employees;

    public EmployeeMemDao() {
        employees = new ArrayList<>();
    }

    @Override
    public void saveEmployee(Employee employee) {
        if( ! employees.contains(employee)) employees.add(employee);
    }

    @Override
    public Employee getEmployee(UUID id) throws NonUniqueIdException {
        Employee foundEmployee = null;

        for(Employee e : employees)
            if(e.getId().toString().startsWith(id.toString())) {
                if(foundEmployee == null) {
                    foundEmployee = e;
                    continue;
                }

                //If reached, two employees were found to match the bit of ID entered
                throw new NonUniqueIdException();
            }

        return foundEmployee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        employees = employees.stream().map(e -> e.equals(employee) ? employee : e).collect(Collectors.toList());
    }

    @Override
    public void deleteEmployee(UUID id) throws NonUniqueIdException {
        Employee foundEmployee = getEmployee(id);

        if(foundEmployee != null) employees.remove(foundEmployee);
    }
}
