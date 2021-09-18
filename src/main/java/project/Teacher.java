package project;

import connection.DbConnection;
import main.ConsoleScanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Teacher extends Person {
    public Teacher(String firstName, String lastName, int id) {
        super(firstName, lastName, id);
    }

    /**
     * This Method Creates a Prepared Statement and set teacher inf : from ConsoleScanner
     * for insert a new row to database.
     */
    @Override
    public void save() throws SQLException {
        // query for insert a new row to student table
        String query = "INSERT INTO teacher\n" +
                "(first_name, last_name, teacher_id)\n" +
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
        System.out.println("The new Teacher Added !");
        preparedStatement.close();

    }


    /**
     * This Method Creates a Prepared Statement and set teacher inf : from ConsoleScanner
     * for update a row in database.
     */
    @Override
    public void update() throws SQLException {
        // query for update a row of student based id
        String query = "UPDATE teacher\n" +
                "SET first_name=?, last_name=?\n" +
                "WHERE teacher_id=?;\n";
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
     * This Method Creates a Prepared Statement and set teacher inf : from ConsoleScanner
     * for delete a row in database.
     */
    @Override
    public void delete() throws SQLException {
        // query for update a row of student based id
        String query = "DELETE FROM teacher\n" +
                "WHERE teacher_id=?;";
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


    /**
     * This Method Creates a Prepared Statement and set teacher ID : from ConsoleScanner
     * for show all students of teacher in database.
     */
    public static void showStudentsBasedTeacherId() throws SQLException {
        Integer id = ConsoleScanner.getShowStudentsInf();
        // query for update a row of student based id
        String query = "SELECT s.* FROM student s, teacher_student ts \n" +
                "WHERE ts.teacher_id = ? AND s.student_id  = ts.student_id";
        // create connection
        Connection connection = DbConnection.createConnection();
        // create preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        // create a ResultSet to select students
        ResultSet resultSet;
        // set preparedStatement Parameter
        if (id != null) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            // loop throw the rows (select query)
            while (resultSet.next()) {
                System.out.print("First Name : " + resultSet.getString("first_name") + " , ");
                System.out.print("Last Name : " + resultSet.getString("last_name") + " , ");
                System.out.println("ID : " + resultSet.getInt("student_id"));
            }
        }
    }
}