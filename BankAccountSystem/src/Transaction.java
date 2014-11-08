/*Michael Learo
 * November 5, 2014
 * 
 * 
 * Class Transaction creates an instance for each transaction a customer process and 
 * store relevant information about the transaction.
 * 
 * 
 * */

public class Transaction {

	private int transactionType;
	private int transactionDay;
	private double transactionAmount;
	private String transactionMessage;
	
	
	public Transaction(int newTransactionType, int newTransactionDay, double newTransactionAmount, String newMessage)
	{
		this.transactionType = newTransactionType;
		this.transactionDay = newTransactionDay;
		this.transactionAmount = newTransactionAmount;
		this.transactionMessage = newMessage;
	}
	
	protected int getTransType()
	{	
		return this.transactionType;
	}
	
	protected int getTransDay()
	{
		return this.transactionDay;
	}
	
	protected double getAmount()
	{
		return this.transactionAmount;
	}
	
	protected String getMessage()
	{
		return this.transactionMessage;
	}
}
