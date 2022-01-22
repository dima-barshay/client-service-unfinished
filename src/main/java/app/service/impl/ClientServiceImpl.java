package app.service.impl;

import app.dao.ClientDao;
import app.exception.DataProcessingException;
import app.lib.Inject;
import app.lib.Service;
import app.model.Client;
import app.model.PhoneNumber;
import app.service.ClientService;
import app.validator.PhoneNumberValidator;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Inject
    private PhoneNumberValidator phoneNumberValidator;
    @Inject
    private ClientDao clientDao;

    @Override
    public Long add(String fullName, PhoneNumber phoneNumber) throws DataProcessingException {
        if(!phoneNumberValidator.isValid(phoneNumber)) {
            throw new DataProcessingException("Can't add client to DB. Phone number is invalid");
        }
        Optional<Client> clientOptional = clientDao.findByPhoneNumber(phoneNumber);
        if (clientOptional.isPresent()) {
            return clientOptional.get().getId();
        }
        return clientDao.add(fullName, phoneNumber);
    }

    @Override
    public boolean delete(Long clientId) throws DataProcessingException {
        if (clientDao.get(clientId).isPresent()) {
            return clientDao.delete(clientId);
        }
        throw new DataProcessingException("This client is deactivated!");
    }
}
