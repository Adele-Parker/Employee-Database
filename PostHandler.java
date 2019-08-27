import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class PostHandler implements HttpHandler {

	public void handle(HttpExchange he) throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
		he.sendResponseHeaders(200, 0);
		writer.write("<html><head></head><body><form method=\"POST\" action=\"/posted\">");
		writer.write("<fieldset><legend>New Employee</legend>");
		writer.write("Name:<br><input type=\"text\" name=\"Name\"><br>");
		writer.write("Gender:<br><input type=\"text\" name=\"Gender\"><br>");
		writer.write("Date of Birth:<br><input type=\"text\" name=\"DOB\"><br>");
		writer.write("Address:<br><input type=\"text\" name=\"Address\"><br>");
		writer.write("Postcode:<br><input type=\"text\" name=\"Postcode\"><br>");
		writer.write("Employee Number:<br><input type=\"number\" name=\"EmployeeNumber\"><br>");
		writer.write("Department:<br><input type=\"text\" name=\"Department\"><br>");
		writer.write("Start Date:<br><input type=\"text\" name=\"StartDate\"><br>");
		writer.write("Salary:<br><input type=\"number\" name=\"Salary\"><br>");
		writer.write("Email:<br><input type=\"text\" name=\"Email\"><br>");
		writer.write("<input type=\"submit\" value=\"Submit\">");
		writer.write("</fieldset></form>");
		
		writer.write("<form method=\"POST\" action=\"/one\">");
		writer.write("<fieldset><legend>Json one employee</legend>");
		writer.write("Employee Number:<br><input type=\"number\" name=\"EmployeeNumber\"><br>");
		//writer.write("Employee: " + GetOneHandler.toString() + );
		writer.write("<input type=\"submit\" value=\"Submit\">");
		writer.write("</fieldset></form>");
		
		writer.write("<form method=\"POST\" action=\"/delete\">");
		writer.write("<fieldset><legend>Delete employee</legend>");
		writer.write("Employee Number:<br><input type=\"number\" name=\"EmployeeNumber\"><br>");
		writer.write("<input type=\"submit\" value=\"Submit\">");
		writer.write("</fieldset></form></body><html>");
		
		writer.close();
		
		
	}
	
	
	
}
	


/*public void createHTMLForm(HttpExchange he) throws IOException
{
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
	he.sendResponseHeaders(200, 0);
	writer.write("<html><head></head><body><form method=\"POST\" action=\"/posted\">");
	writer.write("<fieldset><legend>New Employee</legend>");
	writer.write("<input type=\"text\" name=\"Name: \"><br>");
	writer.write("<input type=\"text\" name=\"Gender: \"><br>");
	writer.write("<input type=\"text\" name=\"Date of Birth: \"><br>");
	writer.write("<input type=\"text\" name=\"Address: \"><br>");
	writer.write("<input type=\"text\" name=\"Postcode: \"><br>");
	writer.write("<input type=\"number\" name=\"Employee Number: \"><br>");
	writer.write("<input type=\"text\" name=\"Department: \"><br>");
	writer.write("<input type=\"text\" name=\"Start Date: \"><br>");
	writer.write("<input type=\"number\" name=\"Salary: \"><br>");
	writer.write("<input type=\"text\" name=\"Email: \"><br>");
	writer.write("<input type=\"submit\" name=\"Submit: \"><br>");
	writer.close();
}
*/

