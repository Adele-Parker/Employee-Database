import java.sql.SQLException;
import java.util.ArrayList;
	
public class DatabaseTester {

		public static void main(String[] args) throws SQLException {
			// TODO Auto-generated method stub
			
			System.out.println("All Employees test");
			ArrayList<Employee> allEmployees = new ArrayList<Employee>();
			allEmployees = EmployeeDAO.getAllEmployees();
			int size = allEmployees.size();
			for (int i = 0; i<size; i++)
			{
				System.out.println(allEmployees.get(i));
			}
			
			System.out.println();
			
			System.out.println("One Employee test");
			int no = 10001234;
			System.out.println(EmployeeDAO.getEmployee(no));
			
			System.out.println();
			
			System.out.println("Insert and retrieve all test");
			Employee e2 = new Employee("Isobel Martin","Female","15/04/1988","70 Jesmond Road","IV44 6TL",10001236,"Art","23/12/2015",(float)10000.00,"martin@mail.com");
			//'Isobel Martin','Female','15/04/1988','70 Jesmond Road','IV44 6TL',10001236,'Art','23/12/2015',10000.00,'Martin@mail.com'
			//Employee e3 = new Employee("Kyle Smart","Male","08/06/1956","56 Wrexham Road","KA5 4GX",10001237,"Languages","04/09/2000",(float)12000.00,"smart@mail.com");
			EmployeeDAO.insertEmployee(e2);
			//EmployeeDAO.insertEmployee(e3);
			//EmployeeDAO.updateEmployee(e3);
			allEmployees = EmployeeDAO.getAllEmployees();
			size = allEmployees.size();
			for (int i = 0; i<size; i++)
			{
				System.out.println(allEmployees.get(i));
			}
			
			System.out.println();
			
			System.out.println("Delete and retrieve all test");
			int nu = 10001236;
			EmployeeDAO.deleteEmployee(nu);
			allEmployees = EmployeeDAO.getAllEmployees();
			size = allEmployees.size();
			for (int i = 0; i<size; i++)
			{
				System.out.println(allEmployees.get(i));
			}
			
			System.out.println();
			
			System.out.println("Update and retrieve all test");
			Employee e4 = new Employee("Kyle Smart","Male","08/06/1956","56 Wrexham Road","KA5 4GX",10001237,"Languages","04/09/2000",(float)12000.00,"smartupdate@mail.com");
			EmployeeDAO.updateEmployee(e4);
			allEmployees = EmployeeDAO.getAllEmployees();
			size = allEmployees.size();
			for (int i = 0; i<size; i++)
			{
				System.out.println(allEmployees.get(i));
			}
		}

	}
