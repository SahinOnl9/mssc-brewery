package guru.springframework.msscbrewery.web.controller.v2;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbrewery.services.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v2/beer")
@RequiredArgsConstructor
public class BeerControllerV2 {

	private final BeerServiceV2 beerServiceV2;

	@GetMapping({ "/{beerId}" })
	public ResponseEntity<BeerDtoV2> getBeer(@PathVariable UUID beerId) {

		return new ResponseEntity<BeerDtoV2>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> handlePost(@Valid @RequestBody BeerDtoV2 beerDto) {
		System.out.println("POST BEER V2");
		BeerDtoV2 savedDto = beerServiceV2.saveNewBeer(beerDto);

		HttpHeaders headers = new HttpHeaders();
		// to-do ADD host-name
		headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@PutMapping({ "/{beerId}" })
	public ResponseEntity<?> handleUpdate(@PathVariable UUID beerId, @RequestBody @Valid BeerDtoV2 beerDto) {

		beerServiceV2.updateBeer(beerId, beerDto);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@DeleteMapping({ "/{beerId}" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId) {
		beerServiceV2.deleteById(beerId);
	}

//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){
//		List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
//		
//		e.getConstraintViolations().forEach(constraintViolation ->{
//				errors.add(constraintViolation.getPropertyPath()+" : "+constraintViolation.getMessage());
//		});
//		
//		return new ResponseEntity<List>(errors, HttpStatus.BAD_REQUEST);
//	}

	
}
