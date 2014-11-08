/*Michael Learo
 * November 5, 2014
 * 
 * 
 * 
 * 
 * 
 * */

public class Savings extends Account {

	private final double interestRate = 0.05;
	private double interest;

	public Savings(int newAccountNumber, Customer newCustomerReference){
		super(newAccountNumber, newCustomerReference);
		this.interest = 0.0;
	}
	
	@Override
	public double computeAverageBalance()
	{
		return 0.1;
		//return this.getAverageBalance();
	}	

	@Override
	public void printStatement(){
		
	}
}
