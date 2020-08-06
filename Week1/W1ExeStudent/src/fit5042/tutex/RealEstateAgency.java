package fit5042.tutex;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.PropertyRepositoryFactory;
import fit5042.tutex.repository.SimplePropertyRepositoryImpl;
import fit5042.tutex.repository.entities.Property;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * TODO Exercise 1.3 Step 3 Complete this class. Please refer to tutorial
 * instructions. This is the main driver class. This class contains the main
 * method for Exercise 1A
 * 
 * This program can run without the completion of Exercise 1B.
 * 
 * @author Keyang Wang
 */
public class RealEstateAgency {
	private String name;
	private final PropertyRepository propertyRepository;
	private SimplePropertyRepositoryImpl impl;

	public RealEstateAgency(String name) throws Exception {
		this.name = name;
		this.propertyRepository = PropertyRepositoryFactory.getInstance();
		impl = new SimplePropertyRepositoryImpl();
	}

	// this method is for initializing the property objects
	// complete this method
	public void createProperty() throws Exception {
		Property property = new Property(1, "24 Boston Ave, Malvern East VIC 3145, Australia", 2, 150, 420000.00);
		impl.addProperty(property);
		Property property2 = new Property(2, "11 Bettina St, Clayton VIC 3168, Australia", 3, 352, 360000.00);
		impl.addProperty(property2);
		Property property3 = new Property(3, "3 Wattle Ave, Glen Huntly VIC 3163, Australia", 5, 800, 650000.00);
		impl.addProperty(property3);
		Property property4 = new Property(4, "3 Hamilton St, Bentleigh VIC 3204, Australia", 2, 170, 435000.00);
		impl.addProperty(property4);
		Property property5 = new Property(5, "82 Spring Rd, Hampton East VIC 3188, Australia", 1, 60, 820000.00);
		impl.addProperty(property5);
		System.err.println("5 properties added successfully");
	}

	// this method is for displaying all the properties
	// complete this method
	public void displayProperties() throws Exception {
		List<Property> resultList;
		resultList = impl.getAllProperties();
		for (Property property : resultList) {
			System.err.println(property.toString());
		}
	}

	// this method is for searching the property by ID
	// complete this method
	public void searchPropertyById() throws Exception {
		Property property;
		Scanner scanner = new Scanner(System.in);
		System.err.println("Enter the ID of the property you want to search:");
		int id = scanner.nextInt();
		property = impl.searchPropertyById(id);
		System.err.println(property.toString());		
	}

	public void run() throws Exception {
		createProperty();
		System.out.println("********************************************************************************");
		displayProperties();
		System.out.println("********************************************************************************");
		searchPropertyById();
	}

	public static void main(String[] args) {
		try {
			new RealEstateAgency("FIT5042 Real Estate Agency").run();
		} catch (Exception ex) {
			System.out.println("Application fail to run: " + ex.getMessage());
		}
	}
}
