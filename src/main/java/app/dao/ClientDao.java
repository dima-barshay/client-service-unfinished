package app.dao;

import app.model.Client;
import app.model.PhoneNumber;
import java.util.Optional;

public interface ClientDao {
    Long add(String fullName, PhoneNumber number);

    Optional<Client> findByPhoneNumber(PhoneNumber number);

    Optional<Client> get(Long id);

    boolean delete(Long id);
}
