package guru.springframework.msscbrewery.web.model;

import java.util.UUID;

import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
	
	@Null
	private UUID id;
	
	@Size(min = 3, max = 100, message = "Name should atleast contain 3 letters and a maximum of 100 letters")
	private String name;
}
