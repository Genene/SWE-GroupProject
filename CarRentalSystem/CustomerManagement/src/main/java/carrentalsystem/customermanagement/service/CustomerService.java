package carrentalsystem.customermanagement.service;

import carrentalsystem.customermanagement.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
     List<Customer> getAllCustomers() ;
     Optional<Customer> getCustomerById(Long id) ;
     Customer createCustomer(Customer customer) ;
     Customer updateCustomer(Customer customer, Long id);
     void deleteCustomer(Long id) ;

}
