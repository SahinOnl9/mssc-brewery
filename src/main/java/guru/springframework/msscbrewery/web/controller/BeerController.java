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

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/beer")
@RequiredArgsConstructor
public class BeerController {
	
	private final BeerService beerService;

	@GetMapping({"/{beerId}"})
	public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId){
		
		return new ResponseEntity<BeerDto>(beerService.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity handlePost(@RequestBody BeerDto beerDto) {
		 BeerDto savedDto = beerService.saveNewBeer(beerDto);
		 
		 HttpHeaders headers = new HttpHeaders();
		 //to-do ADD host-name
		 headers.add("Location", "/api/v1/beer/"+savedDto.getId().toString());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping({"/{beerId}"})
	public ResponseEntity handleUpdate(@PathVariable UUID beerId, @RequestBody BeerDto beerDto) {
		
		beerService.updateBeer(beerId, beerDto);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	@DeleteMapping({"/{beerId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId) {
		beerService.deleteById(beerId);
	}
}
