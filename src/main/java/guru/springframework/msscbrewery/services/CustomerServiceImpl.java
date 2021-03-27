package guru.springframework.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomer(UUID customerId) {
		// TODO Auto-generated method stub
		return CustomerDto.builder().id(UUID.randomUUID()).name("Alex").build();
	}

	@Override
	public CustomerDto saveCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		return CustomerDto.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void handleUpdate(UUID customerId, CustomerDto customerDto) {
		// TODO Auto-generated method stub
		log.debug("Resource updated....");
	}

	@Override
	public void deleteById(UUID customerId) {
		// TODO Auto-generated method stub
		log.debug("Resource deleted....");
	}

}
