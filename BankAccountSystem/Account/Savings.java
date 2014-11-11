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

	public Savings(int newAccountNumber, Customer newCustomerReference) {
		super(newAccountNumber, newCustomerReference);
		this.interest = 0.0;
	}

	@Override
	public double computeAverageBalance() {
		return 0.1;
		// return this.getAverageBalance();
	}

	@Override
	public String printStatement() {
		StringBuilder state = new StringBuilder(500);
		String fullName = this.getAccountOwner().getCustomerFullName();
		String status = this.getAccountOwner().getCustomerStatus()
				.toUpperCase();
		double begBalance = this.getBeginningBalance();
		double totDeposit = this.getTotalDeposit();
		double totWithdrawal = this.getTotalWithdrawal();
		double endBalance = this.getBalance();

		state.append(String.format("Name:    %s%n", fullName))

		.append(String.format("Status:  %s%n", status))

		.append(String.format("Beginning Balance: $%.2f%n", begBalance))

		.append(String.format("Total Deposit:     $%.2f%n", totDeposit))

		.append(String.format("Total Withdrawals: $%.2f%n", totWithdrawal))

		.append(String.format("Ending Balance:    $%.2f%n", endBalance))
				.append(String.format("%n"))
				.append(String.format("Transactions: %n"))

				.append(this.getCustomerTransaction());

		return state.toString();
	}
}
