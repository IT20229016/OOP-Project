package net.javaguides.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.usermanagement.model.Vehicle_Reservation;


public class UserDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3366/vehicle_rent";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_USERS_SQL = "INSERT INTO customer_res" + "  (name, number, type, Address, sdate, edate) VALUES "
			+ " (?, ?, ?, ?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select id,name,number,type,Address,sdate,edate from customer_res where id =?";
	private static final String SELECT_ALL_USERS = "select * from customer_res";
	private static final String DELETE_USERS_SQL = "delete from customer_res where id = ?;";
	private static final String UPDATE_USERS_SQL = "update customer_res set name = ?,number= ?, type =?, Address =?, sdate =?, edate =? where id = ?;";

	public UserDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(Vehicle_Reservation vehicle_Reservation) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, vehicle_Reservation.getName());
			preparedStatement.setString(2, vehicle_Reservation.getNumber());
			preparedStatement.setString(3, vehicle_Reservation.getType());
			preparedStatement.setString(4, vehicle_Reservation.getAddress());
			preparedStatement.setString(5, vehicle_Reservation.getSdate());
			preparedStatement.setString(6, vehicle_Reservation.getEdate());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Vehicle_Reservation selectUser(int id) {
		Vehicle_Reservation vehicle_Reservation = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String number = rs.getString("number");
				String type = rs.getString("type");
				String Address = rs.getString("Address");
				String sdate = rs.getString("sdate");
				String edate = rs.getString("edate");
				vehicle_Reservation = new Vehicle_Reservation(id, name, number, type, Address, sdate, edate);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return vehicle_Reservation;
	}

	public List<Vehicle_Reservation> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Vehicle_Reservation> vehicle_Reservations = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String number = rs.getString("number");
				String type = rs.getString("type");
				String Address = rs.getString("Address");
				String sdate = rs.getString("sdate");
				String edate = rs.getString("edate");
				vehicle_Reservations.add(new Vehicle_Reservation(id, name, number, type, Address, sdate, edate));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return vehicle_Reservations;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(Vehicle_Reservation vehicle_Reservation) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, vehicle_Reservation.getName());
			statement.setString(2, vehicle_Reservation.getNumber());
			statement.setString(3, vehicle_Reservation.getType());
			statement.setString(4, vehicle_Reservation.getAddress());
			statement.setString(5, vehicle_Reservation.getSdate());
			statement.setString(6, vehicle_Reservation.getEdate());
			statement.setInt(7, vehicle_Reservation.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
