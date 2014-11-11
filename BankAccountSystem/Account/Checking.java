/*Michael Learo
 * November 5, 2014
 * 
 * 
 * 
 * 
 * 
 * */

public class Checking extends Account {

	private double totalFee;
	private final double extraRegularCustomerFee = 20.00;
	private final double extraPremiercustomerFee = 10.00;
	private final double regularCustomerFee = 15.00;
	private final double premierCustomerFee = 0.00; // need amount from
													// professor

	public Checking(int newAccountNumber, Customer newCustomerReference) {
		super(newAccountNumber, newCustomerReference);
		this.totalFee = 0.0;
	}

	@Override
	public double computeAverageBalance() {
		return 0.1;
	}

	@Override
	public String printStatement() {
		return "";
	}

}
