package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contact;
import utility.DatabaseConnection;

public class ContactDAO {
    private Connection connection;
    
    public ContactDAO(){
        connection = DatabaseConnection.getConnection();
    }
    
    public List<Contact> getContacts(){
        List<Contact> contacts = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM contacts");

            while (resultSet.next()){
                Contact contact = new Contact();
                contact.setId(resultSet.getInt("id"));
                contact.setName(resultSet.getString("name"));
                contact.setLastName(resultSet.getString("last_name"));
                contact.setMail(resultSet.getString("mail"));
                contact.setNumber(resultSet.getString("number"));
                contact.setBornDate(resultSet.getString("born"));
                contacts.add(contact);
            }
            
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return contacts;
    }
    
    public void addContact(Contact newContact){
        String query = "INSERT INTO contacts (name, last_name, mail, "
                + "number, born) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newContact.getName());
            preparedStatement.setString(2, newContact.getLastName());
            preparedStatement.setString(3, newContact.getMail());
            preparedStatement.setString(4, newContact.getNumber());
            preparedStatement.setString(5, newContact.getBornDate());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}