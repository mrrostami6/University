package project;


import connection.DbConnection;
import main.ConsoleScanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student extends Person {
    public Student(String firstName, String lastName, int id) {
        super(firstName, lastName, id);
    }

    /**
     * This Method Creates a Prepared Statement and set student inf : from ConsoleScanner
     * for insert a new row to database.
     */
    @Override
    public void save() throws SQLException {
        // query for insert a new row to student table
        String query = "INSERT INTO student\n" +
                "(first_name, last_name, student_id)\n" +
                "VALUES(?, ?, ?);\n";
        // create connection
        Connection connection = DbConnection.createConnection();
        // create preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        // set preparedStatement Parameters
        preparedStatement.setString(1, this.getFirstName());
        preparedStatement.setString(2, this.getLastName());
        preparedStatement.setInt(3, this.getId());
        // execute data to database
        preparedStatement.executeUpdate();
        // print the result
        System.out.println("The new Student Added !");
        preparedStatement.close();

    }


    /**
     * This Method Creates a Prepared Statement and set student inf : from ConsoleScanner
     * for update a row in database.
     */
    @Override
    public void update() throws SQLException {
        // query for update a row of student based id
        String query = "UPDATE student\n" +
                "SET first_name=?, last_name=?\n" +
                "WHERE student_id=?;\n";
        // create connection
        Connection connection = DbConnection.createConnection();
        // create preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        // set preparedStatement Parameters
        preparedStatement.setString(1, this.getFirstName());
        preparedStatement.setString(2, this.getLastName());
        preparedStatement.setInt(3, this.getId());
        // check id existing
        int result = preparedStatement.executeUpdate();
        if (result == 0)
            System.out.println("The ID Is Wrong...");
        else
            System.out.println("Successful Updated...");
        preparedStatement.close();
    }


    /**
     * This Method Creates a Prepared Statement and set student inf : from ConsoleScanner
     * for delete a row in database.
     */
    @Override
    public void delete() throws SQLException {
        // query for update a row of student based id
        String query = "DELETE FROM student\n" +
                "WHERE student_id=?;";
        // create connection
        Connection connection = DbConnection.createConnection();
        // create preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        // set preparedStatement Parameter
        preparedStatement.setInt(1, this.getId());
        // check id existing
        int result = preparedStatement.executeUpdate();
        if (result == 0)
            System.out.println("The ID Is Wrong...");
        else
            System.out.println("Successful Deleted...");
        preparedStatement.close();

    }

}
