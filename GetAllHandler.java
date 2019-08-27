import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import com.google.gson.Gson;

public class GetAllHandler implements HttpHandler {

	Gson gson = new Gson();
	
	public void handle(HttpExchange he) throws IOException {
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
		he.sendResponseHeaders(200, 0);
		
		String allEmployees;
		try {
			allEmployees = gson.toJson(EmployeeDAO.getAllEmployees());
			writer.write(allEmployees);
			writer.close();
		} catch (SQLException e) {e.printStackTrace();}
	
	}
}
/*writer.write("<html><head></head><body><form method=\"POST\" action=\"/getone\">");
		writer.write("Employee Number:<br><input type=\"number\" name=\"EmployeeNumber\"><br>");
		writer.write("<input type=\"submit\" value=\"Submit\">");
		writer.write("</fieldset></body><html>");*/
		
		//StringBuilder builder = new StringBuilder();
		//BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
		//he.sendResponseHeaders(200, 0);