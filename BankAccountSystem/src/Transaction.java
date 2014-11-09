/*Michael Learo
 * November 5, 2014
 * 
 * 
 * Class Transaction creates an instance for each transaction a customer process and 
 * store relevant information about the transaction.
 * 
 * 
 * */
import java.util.Date;

public class Transaction {

	
	private int transactionType;
	private Date transactionDay;
	private double transactionAmount;
	private String transactionMessage;
	
	
	public Transaction(int newTransactionType, Date newTransactionDay, double newTransactionAmount, String newMessage)
	{
		this.transactionType = newTransactionType;
		this.transactionDay = newTransactionDay;
		this.transactionAmount = newTransactionAmount;
		this.transactionMessage = newMessage;
	}
	
	protected String getTransType()
	{	
		return (this.transactionType == -1) ? "Withdrawal" : "Deposit";
	}
	
	protected String getTransDay()
	{
		
		return this.transactionDay.toString(); 
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
