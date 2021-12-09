package artursfg.beerservice.bootstrap;

import artursfg.beerservice.domain.Beer;
import artursfg.beerservice.repositories.BeerRepository;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeerLoader implements CommandLineRunner {

  private final BeerRepository repository;

  @Override
  public void run(String... args) throws Exception {
    loadBeerObjects();
  }

  private void loadBeerObjects() {
    if (repository.count() == 0) {
      repository.save(Beer.builder()
          .beerName("Mango Bobs")
          .beerStyle("IPA")
          .quantityToBrew(200)
          .minOnHand(12)
          .price(new BigDecimal("19.99"))
          .upc(337010000001L)
          .build());

      repository.save(Beer.builder()
          .beerName("Brazilian Beer")
          .beerStyle("PALE_ALE")
          .price(new BigDecimal("25.59"))
          .quantityToBrew(200)
          .minOnHand(12)
          .upc(337010000002L)
          .build());
    }
    System.out.println("Loaded Beers: " + repository.count());
  }
}
