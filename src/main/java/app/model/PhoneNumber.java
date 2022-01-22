package app.model;

import java.time.LocalDate;

public class PhoneNumber {
    private Long id;
    private Long clientId;
    private String number;
    private PhoneType phoneType;
    private LocalDate created;
    private LocalDate deleted;

    public enum PhoneType {
        MAIN,
        ADDITIONAL
    }

    public PhoneNumber(String number, PhoneType phoneType, LocalDate created, LocalDate deleted) {
        this.number = number;
        this.phoneType = phoneType;
        this.created = created;
        this.deleted = deleted;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
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
}
