package app.dao.impl;

import app.dao.PhoneNumberDao;
import app.lib.Dao;
import app.model.PhoneNumber;
import java.util.List;

@Dao
public class PhoneNumberDaoImpl implements PhoneNumberDao {
    @Override
    public List<PhoneNumber> getByClientId(Long id) {
        return null;
    }
}
