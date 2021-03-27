package guru.springframework.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
	
	private final CustomerService customerService;
	
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId){
		return new ResponseEntity<CustomerDto>(customerService.getCustomer(customerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity handlePost(@RequestBody CustomerDto customerDto) {
		CustomerDto savedDto = customerService.saveCustomer(customerDto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/customer/"+ savedDto.getId());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity handleUpdate(@PathVariable UUID customerId, @RequestBody CustomerDto customerDto) {
		customerService.handleUpdate(customerId, customerDto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable UUID customerId) {
		customerService.deleteById(customerId);
	}
	
}
