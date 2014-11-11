import static org.junit.Assert.*;

import org.junit.Test;




	import static org.junit.Assert.*;

	import org.junit.Before;
	import org.junit.BeforeClass;
	import org.junit.Test;


	public class SavingsCustomerPremierTest {

		private final String firstName = "Bobby";
		private final String lastName = "Johnson";
		private final String statusPremier = "Premier";
		private final String streetAddress = "3400 Lexington Ave";
		private final String city = "San Diego";
		private final String state = "California";
		private final int zipCode = 92126;
		private Customer testCustomerPremier;
		private Account testCustomerSavings;
		private Customer testCustomerPremier1;
		private Account testCustomerSavings1;
		private Customer testCustomerPremier2;
		private Account testCustomerSavings2;
		private Customer testCustomerPremier3;
		private Account testCustomerSavings3;
		private Customer testCustomerPremier4;
		private Account testCustomerSavings4;
		
		
		
		
		@Before
		public void initSavings(){
			testCustomerPremier = new Customer.Builder("Pat", "Roberts", "Premier").setStreetAddress(streetAddress).setCity(city).setState(state).setZipcode(zipCode).build();
			testCustomerSavings = new Savings(1000, testCustomerPremier);
			testCustomerSavings.setBeginningBalance(60000.00);
			testCustomerSavings.processTransaction(1, 5000.00, 3);
			testCustomerSavings.processTransaction(1, 2000.00, 25);
			testCustomerSavings.processTransaction(-1, 1500.00, 17);
			testCustomerSavings.processTransaction(-1, 1000.00, 1);
			testCustomerSavings.processTransaction(-1, 3000.00, 29);
			
			
			testCustomerPremier1 = new Customer.Builder("Andy", "Garcia", "Regular").setStreetAddress(streetAddress).setCity(city).setState(state).setZipcode(zipCode).build();
			testCustomerSavings1 = new Savings(20000, testCustomerPremier1);
			testCustomerSavings1.setBeginningBalance(600.00);
			testCustomerSavings1.processTransaction(1, 200.00, 4);
			testCustomerSavings1.processTransaction(1, 7300.00, 23);
			testCustomerSavings1.processTransaction(-1, 500.00, 11);
			testCustomerSavings1.processTransaction(-1, 2100.00, 3);
			
			testCustomerPremier2 = new Customer.Builder("Debby", "Dupont", "Regular").setStreetAddress(streetAddress).setCity(city).setState(state).setZipcode(zipCode).build();
			testCustomerSavings2 = new Savings(3000, testCustomerPremier2);
			testCustomerSavings2.setBeginningBalance(500.00);
			testCustomerSavings2.processTransaction(1, 20.00, 1);
			testCustomerSavings2.processTransaction(1, 100.00, 1);
			testCustomerSavings2.processTransaction(-1, 500.00, 9);
			testCustomerSavings2.processTransaction(-1, 2100.00, 28);
			
			testCustomerPremier3 = new Customer.Builder("Ramon", "Spaulding", "Regular").setStreetAddress(streetAddress).setCity(city).setState(state).setZipcode(zipCode).build();
			testCustomerSavings3 = new Savings(40000, testCustomerPremier3);
			testCustomerSavings3.setBeginningBalance(2000.00);
			testCustomerSavings3.processTransaction(1, 200.00,15);
			testCustomerSavings3.processTransaction(1, 300.00, 2);
			testCustomerSavings3.processTransaction(-1, 500.00, 19);
			testCustomerSavings3.processTransaction(-1, 2100.00, 24);
			
			testCustomerPremier4 = new Customer.Builder("Mike", "Rice", "Regular").setStreetAddress(streetAddress).setCity(city).setState(state).setZipcode(zipCode).build();
			testCustomerSavings4 = new Savings(40000, testCustomerPremier4);
			testCustomerSavings4.setBeginningBalance(22000.00);
			testCustomerSavings4.processTransaction(1, 2200.00, 12);
			testCustomerSavings4.processTransaction(1, 300.00, 25);
			testCustomerSavings4.processTransaction(-1, 500.00, 12);
			testCustomerSavings4.processTransaction(-1, 2100.00, 16);
			testCustomerSavings4.processTransaction(1, 1300.00, 18);
		
		}
		
		/*
		@Test
		public void isSavingsInstanceTest(){	
			assertTrue(testCustomerSavings instanceof Savings);
			assertTrue(testCustomerSavings instanceof Account);
			
		}
		
		@Test
		public void testStatus(){
			assertTrue(testCustomerSavings.getAccountOwner().getCustomerStatus().equalsIgnoreCase("premier"));
		}
		
		@Test
		public void accountNumTest(){
			assertTrue(testCustomerSavings.getBeginningBalance() == 60000.00);
		}
		*/
		
		

		@Test
		public void testGetAllCustomer(){
			
			
			
			//Account.getAllCustomers();
			System.out.print(testCustomerSavings.printStatement());
			System.out.printf("%n");
			
			System.out.print(testCustomerSavings1.printStatement());
			System.out.printf("%n");
			System.out.print(testCustomerSavings2.printStatement());
			System.out.printf("%n");
			System.out.print(testCustomerSavings3.printStatement());
			System.out.printf("%n");
			System.out.print(testCustomerSavings4.printStatement());
			
		}
		
	}

