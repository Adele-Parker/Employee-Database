import java.sql.SQLException;

public class Controller {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		

		System.out.println("Peron and Employee test");
		Person p1 = new Person("Luffy", "male", "01/01/2001", "Brazil", "Br1 11a");
		Employee e1 = new Employee("Zolo", "male", "02/02/2002", "Japan", "Ja2 22p", 123456, "Swordsman", "20,12,2012", (float) 50000.59, "zolo@mail.com");
		System.out.println(p1.toString());
		System.out.println(e1.toString());
	}
}

