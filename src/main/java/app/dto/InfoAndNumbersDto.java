package app.dto;

import app.model.PhoneNumber;
import java.time.LocalDate;
import java.util.List;

public class InfoAndNumbersDto {
    private Long clientId;
    private String fullName;
    private String passport;
    private LocalDate birthDate;
    private List<PhoneNumber> phoneNumbers;

    public InfoAndNumbersDto(Long clientId, String fullName,
                             String passport, LocalDate birthDate,
                             List<PhoneNumber> phoneNumbers) {
        this.clientId = clientId;
        this.fullName = fullName;
        this.passport = passport;
        this.birthDate = birthDate;
        this.phoneNumbers = phoneNumbers;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
