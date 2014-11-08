/*Michael Learo
 * November 5, 2014
 * 
 * 
 * 
 * 
 * 
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public abstract class Account {

	private int accountNumber;
	private double beginningBalance, balance, averageBalance, totalWithdrawal, totalDeposit;
	private Customer customerReference;
	private List<Transaction> transactionArrayList = new ArrayList<>();
	private final HashMap<Customer, List<Transaction>> customerAndTransactionMap = new HashMap<>();
	private SecureRandom number;
	//public constructor
	public Account(int newAccountNumber, Customer newCustomerReference)
	{
		this.accountNumber = newAccountNumber;
		this.beginningBalance = 0.0;
		this.balance = 0.0;
		this.customerReference = newCustomerReference;
		this.setCustomerAndTransactionMap();
	}
	
	//Setter methods
	public void setBeginningBalance(double newBeginningBalance)
	{
		this.beginningBalance = newBeginningBalance;
		this.deposit(this.beginningBalance);
	}
	
	public void setAccountOwner(Customer newCustomerReference)
	{
		this.customerReference = newCustomerReference;
		this.setCustomerAndTransactionMap();
	}
	
	private void setCustomerAndTransactionMap(){
		customerAndTransactionMap.put(this.getAccountOwner(), this.transactionArrayList);
	}
	
	
	//Getter methods
	public double getBalance()
	{
		return this.balance;
	}
	
	public double getBeginningBalance()
	{
		return this.beginningBalance;
	}
	
	public Customer getAccountOwner()
	{
		return this.customerReference;
	}
	
	
	//Deposit & Withdrawal Methods
	private void deposit(double amount)
	{
		this.balance += amount;
		this.totalDeposit += amount;	
	}

	private void withdrawal(double amount)
	{
		this.balance -= amount;
		this.totalWithdrawal += amount;	
	}

	protected void chooseTransactionOption(int option, double amount)
	{
		switch(option)
		{
			case 1: deposit(amount);
				break;
			case 2: this.getBalance();
				break;
			//create other cases to print transactions

			case -1: withdrawal(amount);
				break;

			default: break;		
		}
	}
	
	//method that receives information about a accounts transactions and places them in arrayList and processes each transaction.
	protected void processTransaction(int transType, int day, double amount)
	{	
		this.chooseTransactionOption(transType, amount);//call method to make deposit or withdrawal
				
		//checks if balance is overdrawn
		if(this.getBalance() < 0)
		{
				
			//if balance is overdrawn, retrieve the status of the account from Customer class using Customer reference
			String checkStatus = this.customerReference.getCustomerStatus();//get the customer status
			//check what type of status the account owner is
			if(checkStatus.equalsIgnoreCase("regular"))
				{
					//if account owner is overdrawn and has status of regular 
					this.chooseTransactionOption(-1, 40); 
					 customerAndTransactionMap.get(this.customerReference).add(new Transaction(transType, day, amount, "Your account is overdrawn by " + this.getBalance()));
					//this.transactionArrayList.add(new Transaction(transType, day, amount, "Your account is overdrawn by " + this.getBalance()));
				} else {
					//if account owner is overdrawn and has status of premier 
					this.chooseTransactionOption(-1, 10); 
					 customerAndTransactionMap.get(this.customerReference).add(new Transaction(transType, day, amount, "Your account is overdrawn by " + this.getBalance()));
					//this.transactionArrayList.add(new Transaction(transType, day, amount, "Your account is overdrawn by " + this.getBalance()));
				}
			} else {
				//if the account owner is not overdrawn
				this.transactionArrayList.add(new Transaction(transType, day, amount, ""));
		}
	}
	
	public void getAllTransaction()
	{
		for(Transaction trans : (this.customerAndTransactionMap.get(this.customerReference)))
		{
			System.out.printf("Transaction Day: %d%n Transaction Type: %s%n Transaction Amount %f%n Message: %s%n", trans.getTransDay(), trans.getTransType(), trans.getAmount(), trans.getMessage());
		}
	}
	
	public String getTransactionsByDay()
	{
		
		
		
		return "";
	}
		
	public abstract double computeAverageBalance();
	public abstract void printStatement();
}
