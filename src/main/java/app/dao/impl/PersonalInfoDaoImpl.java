package app.dao.impl;

import app.dao.PersonalInfoDao;
import app.lib.Dao;
import app.model.PersonalInfo;
import java.util.Optional;

@Dao
public class PersonalInfoDaoImpl implements PersonalInfoDao {
    @Override
    public Optional<PersonalInfo> get(Long id) {
        return Optional.empty();
    }

    @Override
    public PersonalInfo update(PersonalInfo personalInfo) {
        return null;
    }
}
