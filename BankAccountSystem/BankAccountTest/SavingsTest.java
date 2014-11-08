import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class SavingsTest {

	private final String firstName = "Bobby";
	private final String lastName = "Johnson";
	private final String status = "Premier";
	private final String streetAddress = "3400 Lexington Ave";
	private final String city = "San Diego";
	private final String state = "California";
	private final int zipCode = 92126;
	private Customer testCustomerPremier;
	private Customer testCustomerRegular;
	private Savings testCustomerSavings;
	
	
	
	
	@Before
	public void initSavings(){
		testCustomerPremier = new Customer.Builder(firstName, lastName, status).setStreetAddress(streetAddress).setCity(city).setState(state).setZipcode(zipCode).build();
		testCustomerRegular = new Customer.Builder(firstName, lastName, status).setStreetAddress(streetAddress).setCity(city).setState(state).setZipcode(zipCode).build();
		testCustomerSavings = new Savings(10000, testCustomerPremier);
		testCustomerSavings.setBeginningBalance(2000.00);
		testCustomerSavings.processTransaction(1, 25, 200.00);
		testCustomerSavings.processTransaction(1, 2, 300.00);
		testCustomerSavings.processTransaction(-1, 3, 500.00);
		testCustomerSavings.processTransaction(-1, 17, 2100.00);
	}
	
	
	@Test
	public void isSavingsInstanceTest(){
		
		assertTrue(testCustomerSavings instanceof Savings);
		assertTrue(testCustomerSavings instanceof Account);
			}
	
	/*
	@Test
	public void beginningDepositTest(){		
		assertTrue("balance is not equal",testCustomerSavings.getBeginningBalance() == 2000.00);
		assertFalse("balance is not equal",testCustomerSavings.getBeginningBalance() == 1000.00);	
	} */
	
	
	@Test
	public void getAllTransactionsTest(){
		testCustomerSavings.getAllTransaction();
		System.out.println(testCustomerSavings.getBalance());
	}
}
