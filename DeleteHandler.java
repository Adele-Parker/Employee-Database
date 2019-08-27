import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.HashMap;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class DeleteHandler implements HttpHandler 
{
	public void handle(HttpExchange he) throws IOException
	{
		HashMap<String,String> mapDelete = new HashMap<String,String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(he.getRequestBody()));
		String line = "";
		String request = "";
		while((line = reader.readLine()) != null)
		{
			request = request + line;
		}
		String[] pairs = request.split("&");
		for(int i=0; i<pairs.length; i++)
		{
			String pair = pairs[i];
			mapDelete.put(URLDecoder.decode(pair.split("=")[0],"UTF-8"), URLDecoder.decode(pair.split("=")[1],"UFT-8"));
		}
		int employeeNumber = Integer.parseInt(mapDelete.get("EmployeeNumber"));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
		try
		{
		he.sendResponseHeaders(200, 0);
		EmployeeDAO.deleteEmployee(employeeNumber); 
		writer.write("Employee Deleted");
		}catch (SQLException e)
		{
			writer.write("Error employee not deleted");
		}
	}
	
}
