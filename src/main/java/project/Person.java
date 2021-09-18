package project;

import connection.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int id;

    public Person(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public abstract void save() throws SQLException;

    public abstract void update() throws SQLException;

    public abstract void delete() throws SQLException;

    public static void set(int teacherId, int studentId) throws SQLException {
        // query for update a row of student based id
        String query = "INSERT INTO univercity.teacher_student\n" +
                "(teacher_id, student_id)\n" +
                "VALUES(?, ?)";
        // create connection
        Connection connection = DbConnection.createConnection();
        // create preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        // set preparedStatement Parameter
        preparedStatement.setInt(1, teacherId);
        preparedStatement.setInt(2, studentId);
        // Exception for F-K error
        try {
            preparedStatement.executeUpdate();
            System.out.println("Successful Set...");
        }
        catch (Exception e){
            System.out.println("SomeThing Went Wrong...\nError Name : " + e);
        }
        preparedStatement.close();

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
