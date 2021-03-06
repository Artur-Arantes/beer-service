package artursfg.beerservice.web.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import artursfg.beerservice.web.model.BeerDto;
import artursfg.beerservice.web.model.BeerStyleEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  BeerDto getValidBeerDto(){
    return BeerDto.builder()
        .beerName("Brazilian Beer")
        .beerStyle(BeerStyleEnum.ALE)
        .price(new BigDecimal("25.99"))
        .id(UUID.randomUUID())
        .upc(123123123123L)
        .build();
  }

  @Test
  void getBeerById() throws Exception {
  BeerDto beerDto=getValidBeerDto();
  mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/"+beerDto.getId().toString())
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());

  }

  @Test
  void saveNewBeer() throws Exception {
    BeerDto beerDto = getValidBeerDto();
    String beerDtoJson = objectMapper.writeValueAsString(beerDto);

    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(beerDtoJson))
        .andExpect(status().isCreated());
  }

  @Test
  void updateBeerById() throws Exception {
    BeerDto beerDto = getValidBeerDto();
    String beerDtoJson = objectMapper.writeValueAsString(beerDto);

    mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/" + UUID.randomUUID().toString())
            .contentType(MediaType.APPLICATION_JSON)
            .content(beerDtoJson))
        .andExpect(status().isNoContent());
  }
}