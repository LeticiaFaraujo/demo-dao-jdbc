package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerdao = DaoFactory.createSellerDao(); 
		
		System.out.println("\n--- TEST 1: Seller find by ID ---");
		Seller seller = sellerdao.findById(3);
		System.out.println(seller);

		System.out.println("\n--- TEST 2: Seller find by DEPARTMENT ---");
		Department department = new Department(2, null);
		List<Seller> list = sellerdao.findByDep(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n--- TEST 3: Seller find ALL ---");
		list = sellerdao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		
		}
		
		System.out.println("\n--- TEST 4: Seller INSERT ---");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerdao.insert(newSeller);
		System.out.println("inserted: New id: " + newSeller.getId());

	}
}
