/*Michael Learo
 * November 5, 2014
 * 
 * 
 * 
 * 
 * 
 * */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Map;


public abstract class Account {

	private int accountNumber;
	private double beginningBalance, balance, averageBalance, totalWithdrawal, totalDeposit;
	private Customer customerReference;
	private List<Transaction> transactionArrayList = new ArrayList<>();
	private static final HashMap<Customer, List<Transaction>> customerAndTransactionMap = new HashMap<>();
	private SecureRandom number;
	private static Date transactionDateSetter = new Date();

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
	
	public double getTotalDeposit()
	{
		return this.totalDeposit;
	}
	
	public double getTotalWithdrawal()
	{
		return this.totalWithdrawal;
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
	
	
	protected void processTransaction(int transType, double amount, int transDay)
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
					 customerAndTransactionMap.get(this.customerReference).add(new Transaction(transType,transDay, amount, "Your account is overdrawn by " + this.getBalance())); 
				} 
			else 
				{
					//if account owner is overdrawn and has status of premier 
					this.chooseTransactionOption(-1, 10); 
					customerAndTransactionMap.get(this.customerReference).add(new Transaction(transType, transDay, amount, "Your account is overdrawn by " + this.getBalance()));
				}
		} 
		else 
		{
			//if the account owner is not overdrawn
			this.transactionArrayList.add(new Transaction(transType, transDay, amount, " "));
		}
	}
	
	

	

	
	private static void getAllTransaction(Customer customer)
	{
		
		Collections.sort(customerAndTransactionMap.get(customer), Transaction.transactionDate); 
		
		for(Transaction trans : (customerAndTransactionMap.get(customer)))
		{
			System.out.printf("Transaction Date: %s%nTransaction Type: %s%nTransaction Amount: $%.2f%n", trans.getTransDay(), trans.getTransType(), trans.getAmount());
			if(!trans.getMessage().equalsIgnoreCase(" ")){
				System.out.printf("Message: %s%n", trans.getMessage());
			}
			System.out.println("------------------------------");
		}
		System.out.println("");
	}
	
	
	
	//this prints a list of all customers and their transactions. Is for project3, would remove in production.
	protected static void getAllCustomers()
	{
		for(Customer customer: (customerAndTransactionMap.keySet()))
		{
			//System.out.println(customer.getClass());
			System.out.printf("Name:   %s%nStatus: %s%n",customer.getCustomerFullName(), customer.getCustomerStatus());
			
			getAllTransaction(customer);
		}
	}
	
	
	
	protected String getCustomerTransaction()
	{
		StringBuilder newString = new StringBuilder(500);
		
		Collections.sort(customerAndTransactionMap.get(this.customerReference), Transaction.transactionDate); 
		
		for(Transaction trans : (customerAndTransactionMap.get(this.customerReference)))
		{
			newString.append(String.format("Transaction Date:   %s%n", trans.getTransDay()))
					 .append(String.format("Transaction Type:   %s%n",trans.getTransType()))
					 .append(String.format("Transaction Amount: $%.2f%n", trans.getAmount()));
			//System.out.printf("Transaction Date: %s%nTransaction Type: %s%nTransaction Amount: $%.2f%n", trans.getTransDay(), trans.getTransType(), trans.getAmount());
			if(!trans.getMessage().equalsIgnoreCase(" ")){
				
				newString.append(String.format("Message: %s%n",trans.getMessage()));
				//System.out.printf("Message: %s%n", trans.getMessage());
			}
			newString.append(String.format("------------------------------%n"));
			//System.out.println("------------------------------");
		}
		newString.append(String.format("%n"));
		//System.out.println("");
		return newString.toString();
	}
	
	
	
	
	
	
	
	//below doesn't really have a purpose yet just learning how to navigate data structures
	/*
	private void printMap(){
		for (Map.Entry<Customer, List<Transaction>> entry : customerAndTransactionMap.entrySet()) 
		{
			Customer key = entry.getKey();
		    Object value = entry.getValue();
		    System.out.printf("Key is: %s%nValue is: %s%n", key.toString(), value.toString());
		}
	}
	
	public void print()
	{
		printMap();
	}
	*/
	public abstract double computeAverageBalance();
	public abstract String printStatement();
}
