import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class WebServiceTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(8014),0);
			server.createContext("/", new GetHomeHandler());
			server.createContext("/get-json",new GetAllHandler());
			server.createContext("/post",new PostHandler());
			server.createContext("/posted", new postedHandler());
			server.createContext("/one", new GetOneHandler());
			server.createContext("/delete", new DeleteHandler());
			server.setExecutor(null);
			server.start();
			System.out.println("Server is running on port 8014");
			System.out.println("Get All Employees is running on extension /get-json");
			System.out.println("Insert Employee is running on extension /post");
			System.out.println("Get one Emloyee is running on extension /getemployee");
			System.out.println("Delete Employee is running on extension /delete");
		}catch(IOException e) {System.out.println("Connection issue " + e.getMessage());}

	}

}
