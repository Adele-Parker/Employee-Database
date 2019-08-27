import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.HashMap;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class postedHandler implements HttpHandler{

	public void handle(HttpExchange he) throws IOException
	{
		
		HashMap<String,String> mapString = new HashMap<String,String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(he.getRequestBody()));
		String line = "";
		String request = "";
		while((line = reader.readLine()) != null)
			{
			request = request + line;
			}
		System.out.println("Adding new contact " + request);
		String[] pairs = request.split("&");
		for(int i=0;i<pairs.length; i++)
		{
			String pair = pairs[i];
			System.out.println(pairs[i]);
			mapString.put(URLDecoder.decode(pair.split("=")[0], "UTF-8"),URLDecoder.decode(pair.split("=")[1],"UTF-8"));
		}
		String name = mapString.get("Name");
		String gender = mapString.get("Gender");
		String dob = mapString.get("DOB");
		String address = mapString.get("Address");
		String postcode = mapString.get("Postcode");
		int employeeNumber = Integer.parseInt(mapString.get("EmployeeNumber"));
		String department = mapString.get("Department");
		String startDate = mapString.get("StartDate");
		float salary = Float.parseFloat(mapString.get("Salary"));
		String email = mapString.get("Email");
		Employee e1 = new Employee(name,gender,dob,address,postcode,employeeNumber,department,startDate,salary,email);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
		
		
		
		try
		{
			final EmployeeDAO dao = new EmployeeDAO();
			EmployeeDAO.insertEmployee(e1);
			he.sendResponseHeaders(200, 0);
			writer.write("Success!");
			System.out.println("Success!");
		}catch (SQLException e) 
		{
			he.sendResponseHeaders(500, 0);
			writer.write("Error Adding contact");
			System.out.println("Error Adding contact");
		}
	}
	
}
