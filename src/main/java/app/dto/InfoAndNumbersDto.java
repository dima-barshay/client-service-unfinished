package app.dto;

import app.model.PhoneNumber;
import java.time.LocalDate;
import java.util.List;

public class InfoAndNumbersDto {
    private Long clientId;
    private String fullName;
    private String passport;
    private LocalDate birthDate;
    private LocalDate infoCreated;
    private LocalDate infoDeleted;
    private List<PhoneNumber> phoneNumbers;
}
