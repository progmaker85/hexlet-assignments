package exercise.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// BEGIN
@Getter
@Setter
public class GuestCreateDTO {

    @NotEmpty
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "\\+\\d+")
    @Size(min = 11, max = 13)
    private String phoneNumber;

    @Size(max = 4, min = 4)
    private String clubCard;

    @Future
    private LocalDate cardValidUntil;
}
// END
