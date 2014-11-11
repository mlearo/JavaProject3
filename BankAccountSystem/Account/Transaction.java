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
import java.sql.Timestamp;
import java.util.Comparator;

public class Transaction {

	private int transactionType;
	private int transactionDay;
	private double transactionAmount;
	private String transactionMessage;

	public Transaction(int newTransactionType, int newTransactionDay,
			double newTransactionAmount, String newMessage) {
		this.transactionType = newTransactionType;
		// this.transactionDay = newTransactionDay;
		this.transactionDay = newTransactionDay;
		this.transactionAmount = newTransactionAmount;
		this.transactionMessage = newMessage;
	}

	protected String getTransType() {
		return (this.transactionType == -1) ? "Withdrawal" : "Deposit";
	}

	protected int getTransDay() {

		return this.transactionDay;
	}

	protected double getAmount() {
		return this.transactionAmount;
	}

	protected String getMessage() {
		return this.transactionMessage;
	}

	public static Comparator<Transaction> transactionDate = new Comparator<Transaction>() {

		public int compare(Transaction tran1, Transaction tran2) {

			int first = tran1.transactionDay;
			int second = tran2.transactionDay;

			return first - second;
		}

	};
}
