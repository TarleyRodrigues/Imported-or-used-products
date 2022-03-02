package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Products;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of products: ");

		int num = sc.nextInt();

		List<Products> list = new ArrayList<>();

		for (int i = 1; i <= num; i++) {

			System.out.println("Enter #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i): ");

			char c = sc.next().charAt(0);

			if (c == 'c') {
				sc.nextLine();
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				list.add(new Products(name, price));
			}

			if (c == 'u') {
				sc.nextLine();
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Manufacture Date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, date));
			}

			if (c == 'i') {
				sc.nextLine();
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Customs fee: ");
				double cf = sc.nextDouble();
				list.add(new ImportedProduct(name, price, cf));	
			}

		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Products product : list) {
			System.out.println(product.priceTag());
		}

		sc.close();

	}

}
