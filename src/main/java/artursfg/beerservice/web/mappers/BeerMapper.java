package artursfg.beerservice.web.mappers;

import artursfg.beerservice.domain.Beer;
import artursfg.beerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
  BeerDto beerToBeerDto(Beer beer);

  Beer  beerDtoToBeer(BeerDto dto);
}
