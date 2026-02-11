package gentjanahani.u2w6d3.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class NewAuthorPayload {
    private String name;
    private String surname;
    private String email;
    private LocalDate dateOfBirth;

}
