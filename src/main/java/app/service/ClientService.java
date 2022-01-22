package app.service;

import app.exception.DataProcessingException;
import app.model.PhoneNumber;

public interface ClientService {
    Long add(String fullName, PhoneNumber number) throws DataProcessingException;

    boolean delete(Long clientId) throws DataProcessingException;
}
