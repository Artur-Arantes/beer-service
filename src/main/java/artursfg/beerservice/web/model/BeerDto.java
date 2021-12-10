package artursfg.beerservice.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
  @NonNull
  private UUID id;

  private Integer version;

  private OffsetDateTime createdDate;
  private OffsetDateTime lastModifiedDate;

  @NotBlank
  private String beerName;

  private BeerStyleEnum beerStyle;

  @NonNull
  private Long upc;

  @NonNull
  private BigDecimal price;


  private Integer quantityOnHand;
}
