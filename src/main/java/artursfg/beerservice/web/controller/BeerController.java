package artursfg.beerservice.web.controller;


import artursfg.beerservice.web.model.BeerDto;
import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

  @RequestMapping("/{beerId}")
  public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID Id) {
    return new ResponseEntity<>(BeerDto.builder().id(UUID.randomUUID()).upc(123123123123L)
        .beerName("Brazilian Beer").price(new BigDecimal("25.99")).build(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity saveNewBeer(@RequestBody @Validated BeerDto beerDto) {
    return new ResponseEntity(HttpStatus.CREATED);
  }

  @PutMapping("/{beerId}")
  public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId,
                                       @Validated @RequestBody BeerDto beerDto) {
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }
}
