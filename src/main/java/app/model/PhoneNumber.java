package app.model;

import java.time.LocalDateTime;

public class PhoneNumber {
    private Long id;
    private Long clientId;
    private String number;
    private Long typeId;
    private LocalDateTime created;
    private LocalDateTime deleted;

    public PhoneNumber(Long clientId, String number, Long typeId) {
        this.clientId = clientId;
        this.number = number;
        this.typeId = typeId;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
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
        return "PhoneNumber{"
                + "id=" + id
                + ", clientId=" + clientId
                + ", number='" + number + '\''
                + ", typeId=" + typeId
                + ", created=" + created
                + ", deleted=" + deleted
                + '}';
    }
}
