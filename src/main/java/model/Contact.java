package model;

public class Contact {
    private int id;
    private String name;
    private String lastName;
    private String mail;
    private String number;
    private String bornDate;
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getMail(){
        return mail;
    }
    
    public void setMail(String mail){
        this.mail = mail;
    }
    
    public String getNumber(){
        return number;
    }
    
    public void setNumber(String number){
        this.number  = number;
    }
    
    public String getBornDate(){
        return bornDate;
    }
    
    public void setBornDate(String bornDate){
        this.bornDate = bornDate;
    }
}