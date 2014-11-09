import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SavingsTestCustomerRegular {

	private final String firstName = "James";
	private final String lastName = "Gonzalez";
	private final String statusRegular = "Regular";
	private final String streetAddress = "45900 Los Mirabel Ave";
	private final String city = "San Diego";
	private final String state = "California";
	private final int zipCode = 92340;
	private Customer testCustomerRegular;
	private Account testCustomerSavingsRegular;
	
	
	@Before
	public void initSavingsRegular(){
		testCustomerRegular = new Customer.Builder(firstName, lastName, statusRegular).setStreetAddress(streetAddress).setCity(city).setState(state).setZipcode(zipCode).build();
		testCustomerSavingsRegular = new Savings(20000, testCustomerRegular);
		testCustomerSavingsRegular.setBeginningBalance(2000.00);
		testCustomerSavingsRegular.processTransaction(1, 200.00, 1);
		testCustomerSavingsRegular.processTransaction(1, 300.00,  3);
		testCustomerSavingsRegular.processTransaction(-1, 500.00, 5);
		testCustomerSavingsRegular.processTransaction(-1, 2100.00,  17);

	}
	
	@Test
	public void isSavingsInstanceTest(){	
		assertTrue(testCustomerSavingsRegular instanceof Savings);
		assertTrue(testCustomerSavingsRegular instanceof Account);
	}
	
	@Test
	public void testStatus(){
		assertTrue(testCustomerSavingsRegular.getAccountOwner().getCustomerStatus().equalsIgnoreCase("regular"));
	}
	
	@Test
	public void testGetAllCustomer(){
		Account.getAllCustomers();
	}
	
}
