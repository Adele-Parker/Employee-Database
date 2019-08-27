
public class Employee  extends Person {

	private int employeeNumber;
	private String department;
	private String startDate;
	private float salary;
	private String email;
	
	public Employee(String name, String gender, String dob, String address, String postcode, int employeeNumber, String department,String startDate, float salary, String email )
	{
		super(name,gender,dob,address,postcode);
		setEmployeeNumber(employeeNumber);
		setDepartment(department);
		setStartDate(startDate);
		setSalary(salary);
		setEmail(email);
		
	}
	
	public int getEmployeeNumber()
	{
		return this.employeeNumber;
	}
	
	public void setEmployeeNumber(int employeeNumber)
	{
		this.employeeNumber = employeeNumber;
	}
	
	public String getDepartment()
	{
		return this.department;
	}
	
	public void setDepartment(String department)
	{
		this.department = department;
	}
	
	public String getStartDate()
	{
		return this.startDate;
	}
	
	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}
	
	public float getSalary()
	{
		return this.salary;
	}
	
	public void setSalary(float salary)
	{
		this.salary = salary;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String toString()
	{
		return super.toString() + " Employee Number: " + getEmployeeNumber() + " Department: " + getDepartment() + " Start Date: " + getStartDate() + " Salary: " + getSalary() + " Email: " + getEmail();
	}
	
}