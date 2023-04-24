package com.myrestapi.myrestapi.controllers;

import java.util.Optional;

import com.myrestapi.myrestapi.entity.Customer;
import com.myrestapi.myrestapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    // create new customer
    @PostMapping("/add")
    public Customer addNewCustomer(@RequestBody Customer newCustomer) {
        Customer user = new Customer();
        user.setName(newCustomer.getName());
        user.setEmail(newCustomer.getEmail());
        user.setCity(newCustomer.getCity());
        user.setAddress(newCustomer.getAddress());
        user.setBirthday(newCustomer.getBirthday());
        user.setCountry(newCustomer.getCountry());
        user.setModify_date(newCustomer.getModify_date());
        user.setCreated_date(newCustomer.getCreated_date());
        customerRepository.save(user);
        return user;
    }

    // view all customers
    @GetMapping("view/all")
    public @ResponseBody Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // view specific customer
    @GetMapping("view/{id}")
    public Optional<Customer> getCustomer(@PathVariable Integer id) {
        return customerRepository.findById(id);
    }

    // update an existing customer
    @PutMapping("/edit/{id}")
    public String update(@RequestBody Customer updateCustomer, @PathVariable Integer id) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(updateCustomer.getName());
                    customer.setEmail(updateCustomer.getEmail());
                    customer.setCity(updateCustomer.getCity());
                    customer.setCountry(updateCustomer.getCountry());
                    customer.setAddress(updateCustomer.getAddress());
                    customer.setBirthday(updateCustomer.getBirthday());
                    customer.setCreated_date(updateCustomer.getCreated_date());
                    customer.setModify_date(updateCustomer.getModify_date());
                    customerRepository.save(customer);
                    return "Customer details have been successfully updated!";
                }).orElseGet(() -> {
                    return "This customer doesn't exist";
                });
    }


    // delete customer
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        customerRepository.deleteById(id);
        return "Customer has been successfully deleted!";
    }


}
