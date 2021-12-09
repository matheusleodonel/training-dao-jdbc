package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
				
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("------- FindById Test -------");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n------- FindByDepartment Test -------");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n------- FindAll Test -------");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n------- Seller insert Test -------");
		Seller addSeller = new Seller(null, "Matheus", "matheus@gmail.com", new Date(), 6000.0, department);
		sellerDao.insert(addSeller);
		System.out.println("New seller successfully inserted! Your id: " + addSeller.getId());
		
		System.out.println("\n------- Seller update Test -------");
		seller = sellerDao.findById(1);
		seller.setName("Severina Lateral");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n------- Seller delete Test -------");
		System.out.println("Do you want to delete seller?\n1- Yes\n2- No");
		int aux = sc.nextInt();
		
		if(aux == 1) {
			System.out.println("Enter seller id to delete: ");
			int id = sc.nextInt();
			sellerDao.deleteById(id);
			System.out.println("Delete completed");
		}

		sc.close();
	}
}