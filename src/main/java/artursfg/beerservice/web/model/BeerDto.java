package artursfg.beerservice.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

  @JsonFormat(pattern = "yyyy-mm-dd", shape = JsonFormat.Shape.STRING)
  private OffsetDateTime createdDate;

  @JsonFormat(pattern = "yyyy-mm-dd", shape = JsonFormat.Shape.STRING)
  private OffsetDateTime lastModifiedDate;

  @NotBlank
  private String beerName;

  private BeerStyleEnum beerStyle;

  @NonNull
  private Long upc;

  @NonNull
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal price;


  private Integer quantityOnHand;
}
