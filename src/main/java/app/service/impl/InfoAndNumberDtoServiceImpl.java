package app.service.impl;

import app.dao.PersonalInfoDao;
import app.dao.PhoneNumberDao;
import app.dto.InfoAndNumbersDto;
import app.exception.DataProcessingException;
import app.lib.Inject;
import app.lib.Service;
import app.model.PersonalInfo;
import app.model.PhoneNumber;
import app.service.InfoAndNumbersDtoService;
import app.service.mapper.InfoAndNumberDtoMapper;
import app.validator.PersonalInfoValidator;
import app.validator.PhoneNumberValidator;
import java.util.Optional;

@Service
public class InfoAndNumberDtoServiceImpl implements InfoAndNumbersDtoService {
    @Inject
    private PersonalInfoValidator personalInfoValidator;
    @Inject
    private PhoneNumberValidator phoneNumberValidator;
    @Inject
    private PersonalInfoDao personalInfoDao;
    @Inject
    private PhoneNumberDao phoneNumberDao;
    @Inject
    private InfoAndNumberDtoMapper infoAndNumberDtoMapper;

    @Override
    public InfoAndNumbersDto update(Long clientId, PersonalInfo personalInfo,
                                    PhoneNumber additionalNumber) throws DataProcessingException {
        if (!personalInfoValidator.isValid(personalInfo)
                || !phoneNumberValidator.isValid(additionalNumber)) {
            throw new DataProcessingException("Can't update information, data is invalid");
        }
        Optional<PersonalInfo> infoFromDb = personalInfoDao.get(clientId);
        if (infoFromDb.isPresent() && infoFromDb.get().equals(personalInfo)) {
            return infoAndNumberDtoMapper.toDto(personalInfo,
                    phoneNumberDao.getByClientId(clientId));
        }
        return infoAndNumberDtoMapper.toDto(personalInfoDao.update(personalInfo),
                phoneNumberDao.getByClientId(clientId));
    }

    @Override
    public InfoAndNumbersDto get(Long clientId) throws DataProcessingException {
        return infoAndNumberDtoMapper.toDto(personalInfoDao.get(clientId).orElseThrow(() ->
                        new DataProcessingException("This client is deactivated!")),
                phoneNumberDao.getByClientId(clientId));
    }
}
