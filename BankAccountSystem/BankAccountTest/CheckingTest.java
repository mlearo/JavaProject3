import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CheckingTest {

	
	private final String firstName = "Bobby";
	private final String lastName = "Johnson";
	private final String status = "Premier";
	private final String streetAddress = "3400 Lexington Ave";
	private final String city = "San Diego";
	private final String state = "California";
	private final int zipCode = 92126;
	private Customer testCustomerPremier;
	private Customer testCustomerRegular;
	private Checking testCustomerCheckingPremier;
	private Checking testCustomerCheckingRegular;
	
	
	@Before
	public void initChecking(){
		testCustomerPremier = new Customer.Builder(firstName, lastName, status).setStreetAddress(streetAddress).setCity(city).setState(state).setZipcode(zipCode).build();
		testCustomerCheckingPremier = new Checking(10000, testCustomerPremier);
		testCustomerCheckingPremier.setBeginningBalance(2000.00);
		testCustomerCheckingPremier.processTransaction(1,  200.00);
		testCustomerCheckingPremier.processTransaction(1,  300.00);
		testCustomerCheckingPremier.processTransaction(-1, 500.00);
		testCustomerCheckingPremier.processTransaction(-1, 2100.00);
	}
}
