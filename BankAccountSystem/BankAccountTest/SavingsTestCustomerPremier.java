import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class SavingsTestCustomerPremier {

	private final String firstName = "Bobby";
	private final String lastName = "Johnson";
	private final String statusPremier = "Premier";
	private final String streetAddress = "3400 Lexington Ave";
	private final String city = "San Diego";
	private final String state = "California";
	private final int zipCode = 92126;
	private Customer testCustomerPremier;
	private Savings testCustomerSavings;
	
	
	
	
	
	@Before
	public void initSavings(){
		testCustomerPremier = new Customer.Builder(firstName, lastName, statusPremier).setStreetAddress(streetAddress).setCity(city).setState(state).setZipcode(zipCode).build();
		testCustomerSavings = new Savings(10000, testCustomerPremier);
		testCustomerSavings.setBeginningBalance(2000.00);
		testCustomerSavings.processTransaction(1, 200.00);
		testCustomerSavings.processTransaction(1, 300.00);
		testCustomerSavings.processTransaction(-1, 500.00);
		testCustomerSavings.processTransaction(-1, 2100.00);
	}
	
	
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
	public void getAllTransactionsTest(){
		//testCustomerSavings.getAllTransaction();
		
		//testCustomerSavingsRegular.getAllTransaction();

	}
	
	@Test
	public void testGetAllCustomer(){
		
		Account.getAllCustomers();
	}
	
}
