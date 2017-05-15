# simple-crud

simple-crud is a java web application that connects to a postgres database, reads data and display it on a website. There is also an option to add new records, edit them and delete existing ones. The project was deployed on a apache tomcat server. The sql needed to create a table is presented below:

CREATE TABLE contacts (  
id SERIAL PRIMARY KEY,  
name text NOT NULL,  
last_name text NOT NULL,  
mail text NOT NULL,  
number text NOT NULL,  
born text NOT NULL  
);
