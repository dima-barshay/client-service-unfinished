package app.service.impl;

import app.dao.ClientDao;
import app.dao.PersonalInfoDao;
import app.dao.PhoneNumberDao;
import app.exception.DataProcessingException;
import app.lib.Service;
import app.model.Client;
import app.model.PersonalInfo;
import app.model.PhoneNumber;
import app.service.ClientService;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientDao clientDao;
    private final PersonalInfoDao personalInfoDao;
    private final PhoneNumberDao phoneNumberDao;

    public ClientServiceImpl(ClientDao clientDao, PersonalInfoDao personalInfoDao, PhoneNumberDao phoneNumberDao) {
        this.clientDao = clientDao;
        this.personalInfoDao = personalInfoDao;
        this.phoneNumberDao = phoneNumberDao;
    }

    @Override
    public Long add(String fullName, String mainPhoneNumber) {
        Optional<Client> clientOptional;
        if (phoneNumberDao.getClientIdByMainPhone(mainPhoneNumber).isEmpty()) {
            clientOptional = Optional.empty();
        } else {
            clientOptional = clientDao.getById(phoneNumberDao.getClientIdByMainPhone(mainPhoneNumber).get());
        }
        if (clientOptional.isPresent()) {
            return clientOptional.get().getId();
        }
        Client clientToAdd = new Client();
        Long id = clientDao.add(clientToAdd);
        PersonalInfo personalInfo = new PersonalInfo(id, fullName);
        personalInfoDao.add(personalInfo);
        PhoneNumber phoneNumber = new PhoneNumber(id, fullName, 1L);
        phoneNumberDao.add(phoneNumber);
        return id;
    }


    @Override
    public boolean delete(Long clientId) throws DataProcessingException {
        if (clientDao.getById(clientId).isPresent()) {
            return clientDao.delete(clientId);
        }
        throw new RuntimeException("This client is deactivated!");
    }
}
