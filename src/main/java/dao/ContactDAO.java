package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Contact getContact(int contactId){
        String query = "SELECT * FROM contacts WHERE id=?";
        Contact contact = new Contact();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, contactId);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                contact.setId(contactId);
                contact.setName(resultSet.getString("name"));
                contact.setLastName(resultSet.getString("last_name"));
                contact.setMail(resultSet.getString("mail"));
                contact.setNumber(resultSet.getString("number"));
                contact.setBornDate(resultSet.getString("born"));
            }
            
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return contact;
    }
    
    public void deleteContact(int contactId){
        String query = "DELETE FROM contacts WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, contactId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateContact(Contact contact){
        String query = "UPDATE contacts SET (name, last_name, mail, number, "
                + "born) = (?, ?, ?, ?, ?) WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setString(2, contact.getLastName());
            preparedStatement.setString(3, contact.getMail());
            preparedStatement.setString(4, contact.getNumber());
            preparedStatement.setString(5, contact.getBornDate());
            preparedStatement.setInt(6, contact.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}