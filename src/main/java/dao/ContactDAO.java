package dao;

import java.sql.Connection;
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
}