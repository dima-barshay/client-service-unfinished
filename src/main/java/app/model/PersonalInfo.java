package app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PersonalInfo {
    private Long id;
    private Long clientId;
    private String fullName;
    private String passport;
    private LocalDate birthDate;
    private LocalDateTime created;
    private LocalDateTime deleted;

    public PersonalInfo(Long clientId, String fullName, String passport, LocalDate birthDate) {
        this.clientId = clientId;
        this.fullName = fullName;
        this.passport = passport;
        this.birthDate = birthDate;
        this.created = LocalDateTime.now();
    }

    public PersonalInfo(Long clientId, String fullName) {
        this.clientId = clientId;
        this.fullName = fullName;
        this.created = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getDeleted() {
        return deleted;
    }

    public void setDeleted(LocalDateTime deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "PersonalInfo{"
                + "id=" + id
                + ", clientId=" + clientId
                + ", fullName='" + fullName + '\''
                + ", passport='" + passport + '\''
                + ", birthDate=" + birthDate
                + ", created=" + created
                + ", deleted=" + deleted
                + '}';
    }
}
