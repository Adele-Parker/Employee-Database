import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class GetHomeHandler implements HttpHandler {

	public void handle(HttpExchange he) throws IOException {
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
	he.sendResponseHeaders(200, 0);
	writer.write("RESTful webservice for Employee Database running");
	writer.close();
	}
}
