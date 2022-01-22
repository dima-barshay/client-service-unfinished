package app.service;

import app.dto.InfoAndNumbersDto;
import app.exception.DataProcessingException;
import app.model.PersonalInfo;
import app.model.PhoneNumber;

public interface InfoAndNumbersDtoService {
    InfoAndNumbersDto update(Long clientId, PersonalInfo personalInfo, PhoneNumber additionalNumber)
            throws DataProcessingException;
    InfoAndNumbersDto get(Long clientId) throws DataProcessingException;
}
