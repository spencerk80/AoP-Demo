package com.github.spencerk.aspectDemo.prompt;

import com.github.spencerk.aspectDemo.enums.EmployeeLevel;
import com.github.spencerk.aspectDemo.context.AppContext;
import com.github.spencerk.aspectDemo.dao.EmployeeDao;
import com.github.spencerk.aspectDemo.model.Employee;
import com.github.spencerk.aspectDemo.util.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddEmployeePrompt implements Prompt {
    @Autowired
    private EmployeeDao dao;

    @Override
    public Prompt run() {
        Employee    employee    = AppContext.getContext().getBean(Employee.class);
        String      zip,
                    phoneNumber,
                    email,
                    level;

        employee.setFname(UserInput.getString("Enter employee firstname."));
        employee.setLname(UserInput.getString("Enter employee lastname."));
        employee.setStreetAddr(UserInput.getString("Enter employee street address."));
        employee.setCity(UserInput.getString("Enter employee city."));
        employee.setState(UserInput.getString("Enter employee state."));

        do {
            zip = UserInput.getString("Enter employee zip code");
        } while( ! zip.matches("\\b\\d{5}\\b"));

        employee.setZip(zip);

        do {
            phoneNumber = UserInput.formatPhoneNumber(UserInput.getString("Enter employee phoneNumber"));
        } while( ! phoneNumber.matches("\\(\\d{3}\\) \\d{3} \\d{4}"));

        employee.setPhoneNumber(phoneNumber);

        do {
            email = UserInput.getString("Enter employee email address.");
        } while( ! email.matches(".+@.+\\.[a-z]{3}\\b"));

        employee.setEmail(email);
        level = UserInput.getString("Enter employee level.", "team_member", "shift_lead", "manager");
        employee.setEmployeeLevel(EmployeeLevel.valueOf(level.toUpperCase()));

        dao.saveEmployee(employee);

        return (Prompt) AppContext.getContext().getBean("mainMenuPrompt");
    }
}
