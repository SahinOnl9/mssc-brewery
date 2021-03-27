package guru.springframework.msscbrewery.services;

import java.util.UUID;

import guru.springframework.msscbrewery.web.model.CustomerDto;

public interface CustomerService {

	CustomerDto getCustomer(UUID customerId);

	CustomerDto saveCustomer(CustomerDto customerDto);

	void handleUpdate(UUID customerId, CustomerDto customerDto);

	void deleteById(UUID customerId);

}
