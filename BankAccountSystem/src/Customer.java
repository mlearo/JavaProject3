import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/*Michael Learo
 * November 5, 2014
 * 
 * 
 * 
 * 
 * 
 * */

public class Customer {

	private final String firstName;
	private final String lastName;
	private final String customerStreetAddress;
	private final String customerCity;
	private final String customerState;
	private final String customerStatus;
	private final int customerZipCode;
	private static SecureRandom number;
	
	public static class Builder{
		//Required parameters
		private String firstName;
		private String lastName;
		private String customerStatus;
		
		//Optional parameters
		private String customerStreetAddress = " ";
		private String customerCity = " ";
		private String customerState = " ";
		private int customerZipCode = 00000;
		
		public Builder(String newFirstName, String newLastName, String newCustomerStatus){
			
			this.firstName = newFirstName;
			this.lastName = newLastName;
			this.customerStatus = newCustomerStatus;
		}
		
		public Builder setStreetAddress(String newCustomerAddress)
			{this.customerStreetAddress = newCustomerAddress; return this;}
		
		public Builder setCity(String newCity)
			{this.customerCity = newCity;	return this;}
		
		public Builder setState(String newState)
			{this.customerState = newState;		return this;}
		
		public Builder setZipcode(int newZipCode)
			{ this.customerZipCode = newZipCode;	return this;}
		
		public Customer build(){
			return new Customer(this);
		}
		
		
		
	}
	
	private Customer(Builder builder)
	{
		firstName = builder.firstName;
		lastName = builder.lastName;
		customerStatus = builder.customerStatus;
		customerStreetAddress = builder.customerStreetAddress;
		customerCity = builder.customerCity;
		customerState = builder.customerState;
		customerZipCode = builder.customerZipCode;
		
	}
	
	public String getCustomerFirstName(){
		return this.firstName;
	}
	
	public String getCustomerLastName(){
		return this.lastName;
	}
	
	public String getCustomerStatus(){
		return this.customerStatus;
	}
	
	public String getCustomerStreetAddress(){
		return this.customerStreetAddress;
	}
	
	public String getCustomerCity(){
		return this.customerCity;
	}
	
	public String getCustomerState(){
		return this.customerState;
	}
	
	public int getCustomerZipCode(){
		return this.customerZipCode;
	}
	
	/* Playing with SecureRandom to generate a secure random account number*/
	private static void random() {
		//number = new SecureRandom.getInstance("SHA1PRNG");
		number = new SecureRandom();
		System.out.println((Math.ceil((number.nextDouble() * number.nextInt(10000000)))));
	}
	protected static void callRandom(){
		Customer.random();
	}
}
