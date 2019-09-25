package az.pashabank.learning_sessions.crud_operation.service;

import az.pashabank.learning_sessions.crud_operation.model.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO getCustomerById(Long id);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO addCustomer(CustomerDTO customer);

    CustomerDTO updateCustomer(CustomerDTO customer);

    void deleteCustomer(Long id);
}
