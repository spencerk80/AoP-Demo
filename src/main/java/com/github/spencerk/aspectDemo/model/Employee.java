package com.github.spencerk.aspectDemo.model;

import com.github.spencerk.aspectDemo.enums.EmployeeLevel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
@Scope("prototype")
public class Employee {
    private final   UUID            id;
    private         String          fname,
                                    lname,
                                    streetAddr,
                                    city,
                                    state,
                                    zip,
                                    phoneNumber,
                                    email;
    private         EmployeeLevel   employeeLevel;

    public Employee() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getStreetAddr() {
        return streetAddr;
    }

    public void setStreetAddr(String streetAddr) {
        this.streetAddr = streetAddr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeLevel getEmployeeLevel() {
        return employeeLevel;
    }

    public void setEmployeeLevel(EmployeeLevel employeeLevel) {
        this.employeeLevel = employeeLevel;
    }

    @Override
    public String toString() {
        return String.format(
                "Employee{\n\tid = %s,\n\tfname = %s,\n\tlname = %s,\n\tstreetAddr = %s,\n\tcity = %s,\n\t" +
                "state = %s,\n\tzip = %s,\n\tphoneNumber = %s,\n\temail = %s,\n\temployeeLevel = %s\n}",
                id,
                fname,
                lname,
                streetAddr,
                city,
                state,
                zip,
                phoneNumber,
                email,
                employeeLevel
        );
    }

    @Override
    public boolean equals(Object o) {
        Employee employee;

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        employee = (Employee) o;

        return id.equals(employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
