package app.dao.impl;

import app.dao.ClientDao;
import app.lib.Dao;
import app.model.Client;
import app.model.PhoneNumber;
import java.util.Optional;

@Dao
public class ClientDaoImpl implements ClientDao {
    @Override
    public Long add(String fullName, PhoneNumber phoneNumber) {
        return null;
    }

    @Override
    public Optional<Client> findByPhoneNumber(PhoneNumber number) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> get(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
