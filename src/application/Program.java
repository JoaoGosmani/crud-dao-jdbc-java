package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter 1 to test Seller CRUD or 2 to test Department CRUD: ");
		int answer = sc.nextInt();
		
		if (answer == 1) {	
			SellerDao sellerDao = DaoFactory.createSellerDao();
			
			System.out.println("=== TESTE 1: seller findById ===");
			Seller seller = sellerDao.findById(3);
			System.out.println(seller);
			
			System.out.println("\n=== TESTE 2: seller findByDepartment ===");
			Department department = new Department(2, null);
			List<Seller> sellers = sellerDao.findByDepartment(department);
			for (Seller seller2 : sellers) {
				System.out.println(seller2);			
			}
			
			System.out.println("\n=== TESTE 3: seller findAll ===");
			sellers = sellerDao.findAll();
			for (Seller seller2 : sellers) {
				System.out.println(seller2);			
			}
			
			System.out.println("\n=== TESTE 4: seller insert ===");
			Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
			sellerDao.insert(newSeller);
			System.out.println("Inserted! New id = " + newSeller.getId());
			
			System.out.println("\n=== TESTE 5: seller update ===");
			seller = sellerDao.findById(1);
			seller.setName("Martha Wayne");
			sellerDao.update(seller);
			System.out.println("Update completed");
			
			System.out.println("\n=== TESTE 6: seller delete ===");
			System.out.print("Enter id for delete test: ");
			int id = sc.nextInt(); 
			sellerDao.deleteById(id);
			System.out.println("Delete completed!");
		} else if (answer == 2) {
			DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
			
			System.out.println("=== TESTE 1: department findById ===");
			Department department = departmentDao.findById(3);
			System.out.println(department);
			
			System.out.println("\n=== TESTE 2: department findAll ===");
			List<Department> departments = new ArrayList<Department>();
			departments = departmentDao.findAll();
			for (Department department2 : departments) {
				System.out.println(department2);			
			}
			
			System.out.println("\n=== TESTE 3: department insert ===");
			Department newDepartment = new Department(null, "Foods");
			departmentDao.insert(newDepartment);
			System.out.println("Inserted! New id = " + newDepartment.getId());
			
			System.out.println("\n=== TESTE 4: department update ===");
			department = departmentDao.findById(1);
			department.setName("Sports");
			departmentDao.update(department);
			System.out.println("Update completed");
			
			System.out.println("\n=== TESTE 5: department delete ===");
			System.out.print("Enter id for delete test: ");
			int id = sc.nextInt(); 
			departmentDao.deleteById(id);
			System.out.println("Delete completed!");
		} else {
			System.out.println("Error! Enter with a valid number");
		}
		
		sc.close();
	}

}
