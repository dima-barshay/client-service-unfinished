package app.dao.impl;

import app.dao.ClientDao;
import app.exception.DataProcessingException;
import app.model.Client;
import app.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

public class ClientDaoImpl implements ClientDao {

    @Override
    public Long add(Client client) {
        String insertClientRequest = "INSERT INTO clients (created) VALUES (?);";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement addClientStatement =
                     connection.prepareStatement(insertClientRequest,
                             Statement.RETURN_GENERATED_KEYS)) {
            addClientStatement.setTimestamp(1,
                    Timestamp.valueOf(client.getCreated()));
            addClientStatement.executeUpdate();
            ResultSet generatedKeys = addClientStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                client.setId(generatedKeys.getObject(1, Long.class));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Cant add " + client + " to DB", e);
        }
        return client.getId();
    }

    @Override
    public Optional<Client> getById(long id) {
        String getClientRequest = "SELECT * FROM clients WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement getClientByIdStatement
                     = connection.prepareStatement(getClientRequest)) {
            getClientByIdStatement.setLong(1, id);
            ResultSet resultSet = getClientByIdStatement.executeQuery();
            Client client = null;
            if (resultSet.next()) {
                client = getClient(resultSet);
            }
            return Optional.ofNullable(client);
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldnt get client by id " + id, throwable);
        }
    }

    @Override
    public boolean delete(long id) {
        String deleteClientRequest = "UPDATE clients SET is_deleted = TRUE WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement deleteClientStatement
                     = connection.prepareStatement(deleteClientRequest)) {
            deleteClientStatement.setLong(1, id);
            return deleteClientStatement.executeUpdate() > 0;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't delete a driver by id " + id, throwable);
        }
    }

    private Client getClient(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        LocalDateTime created = resultSet.getTimestamp("created").toLocalDateTime();
        Client client = new Client();
        client.setId(id);
        client.setCreated(created);
        return client;
    }
}
