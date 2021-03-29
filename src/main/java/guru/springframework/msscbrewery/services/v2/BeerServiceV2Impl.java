package guru.springframework.msscbrewery.services.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BeerServiceV2Impl implements BeerServiceV2 {

	@Override
	public BeerDtoV2 getBeerById(UUID beerId) {
		log.debug("Api v2 get method..");
		return null;
	}

	@Override
	public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
		log.debug("Api v2 post method..");
		return null;
	}

	@Override
	public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
		log.debug("Api v2 update method..");

	}

	@Override
	public void deleteById(UUID beerId) {
		log.debug("Api v2 delete method..");

	}

}
