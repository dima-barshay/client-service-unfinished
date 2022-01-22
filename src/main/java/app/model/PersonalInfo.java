package app.model;

import java.time.LocalDate;
import java.util.Objects;

public class PersonalInfo {
    private Long id;
    private Long clientId;
    private String fullName;
    private String passport;
    private LocalDate birthDate;
    private LocalDate created;
    private LocalDate deleted;

    public PersonalInfo(String fullName, String passport,
                        LocalDate birthDate, LocalDate created, LocalDate deleted) {
        this.fullName = fullName;
        this.passport = passport;
        this.birthDate = birthDate;
        this.created = created;
        this.deleted = deleted;
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

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getDeleted() {
        return deleted;
    }

    public void setDeleted(LocalDate deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalInfo that = (PersonalInfo) o;
        return Objects.equals(clientId, that.clientId)
                && Objects.equals(fullName, that.fullName)
                && Objects.equals(passport, that.passport)
                && Objects.equals(birthDate, that.birthDate)
                && Objects.equals(created, that.created)
                && Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, fullName, passport, birthDate, created, deleted);
    }
}
