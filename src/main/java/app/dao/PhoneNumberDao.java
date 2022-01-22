package app.dao;

import app.model.PhoneNumber;
import java.util.List;

public interface PhoneNumberDao {
    List<PhoneNumber> getByClientId(Long id);
}
