package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

class Matcher {
    public String username;
    public String password;
}

@CrossOrigin(value = "http://localhost:3000/")
@RestController
public class APIController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value =  "/get-employees")
    public List<Employee> getName(){

        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @PostMapping(value =  "/add-employee")
    public  Employee getName2(@RequestBody() Employee emp){
        employeeRepository.save(emp);
        return emp;
    }

    @PostMapping(value =  "/create-user")
    public  User createUser(@RequestBody() User user){
        userRepository.save(user);
        return user;
    }


    @DeleteMapping(value = "/delete-employee/{id}")
    public  int DeleteEmployee(@PathVariable("id") int id){
        employeeRepository.deleteById(id);
        return id;
    }

    @PutMapping(value = "/update-employee/{id}")
    public Employee UpdateEmployee(@PathVariable("id") int id,@RequestBody() Employee newData){

        Employee emp = employeeRepository.findById(id).get();
        if(emp != null){
            emp.setName(newData.getName());
        }
        employeeRepository.save(emp);
        return emp;
    }
};



///  static class  -->

/// Array users array of User class

//  add method (User user)




// api --> get-all-users  // GET
// api --> add-new-user   // POST