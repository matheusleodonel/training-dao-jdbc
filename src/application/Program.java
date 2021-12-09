package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

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
	}
}