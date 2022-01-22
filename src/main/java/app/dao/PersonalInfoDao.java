package app.dao;

import app.model.PersonalInfo;
import java.util.Optional;

public interface PersonalInfoDao {
    Optional<PersonalInfo> get(Long id);

    PersonalInfo update(PersonalInfo personalInfo);
}
