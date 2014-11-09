import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class CustomerTest {

	private final String firstName = "Bobby";
	private final String lastName = "Johnson";
	private final String status = "Premier";
	private final String streetAddress = "3400 Lexington Ave";
	private final String city = "San Diego";
	private final String state = "California";
	private final int zipCode = 92126;
	private final int deposit = 1;
	private final int withdrawal = -1;
	private Customer testCustomer;
	
	@Before
	public void init(){
		testCustomer = new Customer.Builder(firstName, lastName, status).setStreetAddress(streetAddress).setCity(city).setState(state).setZipcode(zipCode).build();
	}
	
	@Test
	public void getCustomerFirstNameTest(){
		assertTrue(testCustomer.getCustomerFirstName().equalsIgnoreCase(firstName));
	}
	
	@Test
	public void getCustomerLastNameTest(){
		assertTrue(testCustomer.getCustomerLastName().equalsIgnoreCase(lastName));
	}
	
	@Test
	public void getCustomerStatusTest(){
		assertTrue(testCustomer.getCustomerStatus().equalsIgnoreCase(status));
	}
	
	@Test
	public void getCustomerStreetAddressTest(){
		assertTrue(testCustomer.getCustomerStreetAddress().equalsIgnoreCase(streetAddress));
	}
	
	@Test 
	public void getCustomerCityTest(){
		assertTrue(testCustomer.getCustomerCity().equalsIgnoreCase(city));
		assertFalse(testCustomer.getCustomerCity().equalsIgnoreCase("Las Vegas"));
	}
	
	@Test
	public void getCustomerStateTest(){
		assertTrue(testCustomer.getCustomerState().equalsIgnoreCase(state));
		assertFalse(testCustomer.getCustomerState().equalsIgnoreCase("New York"));
	}
	
	@Test
	public void getCustomerZipCodeTest(){
		assertEquals(testCustomer.getCustomerZipCode(), zipCode);
		assertNotEquals(testCustomer.getCustomerZipCode(), 92127);
	}
	
	@Test
	public void setAccountOwnerReferenceTest(){
	
	}
	
	
	
	
}
