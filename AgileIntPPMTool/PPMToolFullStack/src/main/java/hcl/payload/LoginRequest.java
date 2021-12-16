package hcl.payload;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class LoginRequest {
	@NotBlank(message="Username cannot be blank")
	private String username;
	@NotBlank(message="Password cannot be blank")
    private String password;

}
