package carrentalsystem.customermanagement.controller;



import carrentalsystem.customermanagement.model.Customer;
import carrentalsystem.customermanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        if (customers.isEmpty())
            return new ResponseEntity<String>("No customers found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        try
        {
            Customer savedCustomer = customerService.createCustomer(customer);
            return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        try {
            Customer updated = customerService.updateCustomer(customer, id);
            return new ResponseEntity<Customer>(updated, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {

        try {
            customerService.deleteCustomer(id);
            return new ResponseEntity<String>("Customer deleted successfully", HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
