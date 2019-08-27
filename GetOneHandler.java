import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.HashMap;

import com.sun.net.httpserver.HttpHandler;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;


public class GetOneHandler implements HttpHandler {
	//String employee = "";
	public void handle(HttpExchange he) throws IOException 
	{
		HashMap<String,String> mapEmp = new HashMap<String,String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(he.getRequestBody()));
		String line = "";
		String request = "";
		while((line = reader.readLine()) != null)
		{
			request = request + line;
		}
		String[] pairs = request.split("&");
		for(int i=0; i<pairs.length;i++)
		{
			String pair = pairs[i];
			mapEmp.put(URLDecoder.decode(pair.split("=")[0],("UTF-8")),URLDecoder.decode(pair.split("=")[1],("UTF-8")));
		}
		int employeeNumber = Integer.parseInt(mapEmp.get("EmployeeNumber"));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
		try {
			he.sendResponseHeaders(200, 0);
			Gson gson = new Gson();
			//employee = gson.toJson(EmployeeDAO.getEmployee(employeeNumber));
			Employee employee = EmployeeDAO.getEmployee(employeeNumber);
			writer.write(employee.toString());
			writer.close();
			System.out.println(employee.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*public String toString() 
	{
		return "Employee: " + employee;
	}*/
}
