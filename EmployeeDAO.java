import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.ArrayList;

public class EmployeeDAO {

	public static Connection getDBConnection()
	{
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
		}catch (ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
		try{
			String dbURL = "jdbc:sqlite:empdb.sqlite";
			connection = DriverManager.getConnection(dbURL);
			//System.out.println("Connected");
			return connection;
		}catch (SQLException e){System.out.println(e.getMessage());}
		return connection;
	}
	
	public static ArrayList<Employee> getAllEmployees() throws SQLException
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Employee> allEmployees = new ArrayList<Employee>();
		//HashMap<String,String> employee = new HashMap<String,String>();
		Employee temp;
		
		connection = getDBConnection();
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {System.out.println(e.getMessage());}
		try {
			resultSet = statement.executeQuery("SELECT * FROM employees;");
			while (resultSet.next()) {
				String name = resultSet.getString("Name");
				String gender = resultSet.getString("Gender");
				String dob = resultSet.getString("DOB");
				String address = resultSet.getString("Address");
				String postcode = resultSet.getString("Postcode");
				int employeeNumber = resultSet.getInt("EmployeeNumber");
				String department = resultSet.getString("Department");
				String startDate = resultSet.getString("StartDate");
				float salary = resultSet.getFloat("Salary");
				String email = resultSet.getString("Email");
				
				temp = new Employee(name,gender,dob,address,postcode,employeeNumber,department,startDate,salary,email);
				allEmployees.add(temp);
				
				//System.out.println("Name: " + resultSet.getString("Name") + " Gender: " + resultSet.getString("Gender") + " DOB: " + resultSet.getString("DOB") + " Address: " + resultSet.getString("Address") + " Postcode: " + resultSet.getString("Postcode") + " Employee Number: " + resultSet.getString("EmployeeNumber") + " Department: " + resultSet.getString("Department") + " Start Date: " + resultSet.getString("StartDate") + " Salary: " + resultSet.getString("Salary") + " Email: " + resultSet.getString("Email"));
				//allEmployees.add(resultSet.getString("Name") + resultSet.getString("Gender") + resultSet.getString("DOB") + resultSet.getString("Address") + resultSet.getString("Postcode") + resultSet.getString("EmployeeNumber") + resultSet.getString("Department") + resultSet.getString("StartDate") + resultSet.getString("Salary") + resultSet.getString("Email"));
			}
		}catch (SQLException e) {System.out.println(e.getMessage());}
		finally {
			if (resultSet != null) {resultSet.close();}
			if (statement != null) {statement.close();}
			if (connection != null) {connection.close();}
		}
		
		return allEmployees;
	}
	
	public static Employee getEmployee(int empNumber) throws SQLException
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Employee oneEmployee = null;
		try {
			connection = getDBConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT employees.Name,employees.Gender,employees.DOB,employees.Address,employees.Postcode,employees.EmployeeNumber,employees.Department,employees.StartDate,employees.Salary,employees.Email FROM employees WHERE employees.EmployeeNumber=" + empNumber +";");
			while(resultSet.next())
			{
				String name = resultSet.getString("Name");
				String gender = resultSet.getString("Gender");
				String dob = resultSet.getString("DOB");
				String address = resultSet.getString("Address");
				String postcode = resultSet.getString("Postcode");
				int employeeNumber = resultSet.getInt("EmployeeNumber");
				String department = resultSet.getString("Department");
				String startDate = resultSet.getString("StartDate");
				float salary = resultSet.getFloat("Salary");
				String email = resultSet.getString("Email");
				
				oneEmployee = new Employee(name,gender,dob,address,postcode,employeeNumber,department,startDate,salary,email);
				
			} 
		}catch(SQLException e) {System.out.println(e.getMessage());}
		finally
		{
			if (resultSet != null) {resultSet.close();}
			if (statement != null) {statement.close();}
			if (connection != null) {connection.close();}
		}
		return oneEmployee;
	}
	
	public static Boolean insertEmployee(Employee e1) throws SQLException
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getDBConnection();
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			String name = e1.getName();
			String gender = e1.getGender();
			String dob = e1.getDob();
			String address = e1.getAddress();
			String postcode = e1.getPostcode();
			int employeeNumber = e1.getEmployeeNumber();
			String department = e1.getDepartment();
			String startDate = e1.getStartDate();
			float salary = e1.getSalary();
			String email = e1.getEmail();
			String insert = "Name,Gender,DOB,Address,Postcode,EmployeeNumber,Department,StartDate,Salary,Email";
			statement.executeUpdate("INSERT INTO employees (" + insert + ") VALUES ('" + name + "','" + gender + "','" + dob + "','" + address + "','" + postcode + "'," + employeeNumber + ",'" + department + "','" + startDate + "'," + salary + ",'" + email + "');");
			System.out.println(e1.toString());
			connection.commit();
		}catch(SQLException e) {System.out.println(e.getMessage());}
		finally
		{
			if (resultSet != null) {resultSet.close();}
			if (statement != null) {statement.close();}
			if (connection != null) {connection.close();}
		}
		return false;
	}
	
	public static Boolean deleteEmployee(int empNumber) throws SQLException
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try{
			connection = getDBConnection();
			statement = connection.createStatement();
			connection.setAutoCommit(false);
			statement.executeUpdate("DELETE from employees WHERE employees.EmployeeNumber=" + empNumber +";");
			connection.commit();
		}catch(SQLException e) {System.out.println(e.getMessage());}
		finally
		{
			if (resultSet != null) {resultSet.close();}
			if (statement != null) {statement.close();}
			if (connection != null) {connection.close();}
		}
		return false;
	}
	
	public static Boolean updateEmployee (Employee emp) throws SQLException
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getDBConnection();
			statement = connection.createStatement();
			connection.setAutoCommit(false);
			String name = emp.getName();
			String gender = emp.getGender();
			String dob = emp.getDob();
			String address = emp.getAddress();
			String postcode = emp.getPostcode();
			int employeeNumber = emp.getEmployeeNumber();
			String department = emp.getDepartment();
			String startDate = emp.getStartDate();
			float salary = emp.getSalary();
			String email = emp.getEmail();
			statement.executeUpdate("UPDATE employees SET Name = '" + name + "' WHERE EmployeeNumber = " + employeeNumber + ";");
			statement.executeUpdate("UPDATE employees SET Gender = '" + gender + "' WHERE EmployeeNumber = " + employeeNumber + ";");
			statement.executeUpdate("UPDATE employees SET DOB = '" + dob + "' WHERE EmployeeNumber = " + employeeNumber + ";");
			statement.executeUpdate("UPDATE employees SET Address = '" + address + "' WHERE EmployeeNumber = " + employeeNumber + ";");
			statement.executeUpdate("UPDATE employees SET Postcode = '" + postcode + "' WHERE EmployeeNumber = " + employeeNumber + ";");
			
			statement.executeUpdate("UPDATE employees SET Department = '" + department + "' WHERE EmployeeNumber = " + employeeNumber + ";");
			statement.executeUpdate("UPDATE employees SET StartDate = '" + startDate + "' WHERE EmployeeNumber = " + employeeNumber + ";");
			statement.executeUpdate("UPDATE employees SET Salary = " + salary + " WHERE EmployeeNumber = " + employeeNumber + ";");
			statement.executeUpdate("UPDATE employees SET Email = '" + email + "' WHERE EmployeeNumber = " + employeeNumber + ";");
			connection.commit();
		}catch(SQLException e) {System.out.println(e.getMessage());}
		finally
		{
			if (resultSet != null) {resultSet.close();}
			if (statement != null) {statement.close();}
			if (connection != null) {connection.close();}
		}
		return false;
	}
	
	public static Boolean CheckLoginCredentials(String username, String password) throws SQLException
	{
		
	}
	
	public static Boolean CheckApiKey(String key) throws SQLExpcetion
	{
		
	}
	
	
}
