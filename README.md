JavaProject3
============
**This is my version of the project below**


SDSU MIS515 Java project 3 from Dr. Alexis Koster
MIS 515 – Fall 2014.  Java Programming assignment #3.  Due:  December 5


Objectives: Superclasses and subclasses.  Abstract classes. inheritance and polymorphism

The previous program will be modified as follows

1.There are two types of accounts: Savings and Checking.  These will be subclasses of an abstract class Account

2. Methods of the class Account: relevant get and set methods; addDeposit method (add  deposit to the balance);  subtractWithdrawal (subtract  withdrawal from balance); printStatement(); maybe some of the other methods you already have;
abstract method: computeAverageBalance();

New fields of Account (instance variable) of the class Account: averageBalance,

Old fields: most of the fields as in assignment #3

3. Class Savings
  new fields: interest_rate (double) (will be 0.05 for all savings)
                    interest (the interest earned during the 30-day month)

 methods: printStatement() 
                 computeAverageBalance();
                    for a savings account,  the average balance for a given month is computed by     
                    method computeAverageBalance() as the half sum of the balances on the first day 
                     and last day of the month (before application of fees)"                
                   computeInterest(): interest rate times the average balance divided by 12
        .       
                 there are no fees on a Savings account

4. Class Checking

     new fields: 
 totalFee (see below)

     methods: printStatement()
                     computeAverageBalance()
                           for a checking account, the average balance is computed by method 
                            computeAverageBalance() as the half sum of the lowest and highest balances 
                             during the month                    
                         computeFee()
                             Fees: totalFee is computed by the method computeFee() as follows:
                                    Regular customers pay a monthly fee of $15 fee  
                                          If the averageBalance is less than 500, there is an extra fee:  $20 for 
                                            Regular customers, $10 for Premier Customer



5.  Test program requirements
First read customer information and set the array of Customers as in program3.

Then read account information and set one array of Account.  Note that each element of the array of Account will refer to either a Checking object or a Savings object.  This is polymorphism (see section 10.5 of Chapter10).


Then, for each account, as relevant, execute the following methods (again: invoked from the test program):
computeAverage(); computInterest(); computeFee (); printStatement()

Although this is not necessarily the best way to design such a program, I want to see at least those four methods invoked by the test program in order to illustrate the various types of methods in a hierarchy of classes and to illustrate polymorphism.




DATA

CUSTOMERS

Customer Last name, First Name:  Roberts, Pat  Customer-Status  : Premier
Customer Last name, First Name:  Garcia, Andy  Customer-Status: Regular
 Customer Last name, First Name:  Dupont, Debby  Customer-Status: Regular
 Customer Last name, First Name:  Spaulding  Ramon  Customer-Status: Regular
Customer Last name, First Name:  Rice  Mike  Customer-Status: Regular
 

 

ACCOUNTS and TRANSACTIONS


Account number: 1000  Account type: Savings
Customer Last name, First Name:  Roberts, Pat
Beginning balance   60000

 Transactions.  Each transaction shows3 numbers:the type of transaction (1 for Deposit, -1 for withdrawal, 0 for end of transaction for current account),  the day of the month, and the amount deposited or withdrawn
   1 5  5000 
   1  10  2000 
   -1  15 1500 
   -1   20 1000  
   -1   25 3000
  0

Account number: 1500  Account type: Checking
Customer Last name, First Name:  Garcia Andy
Beginning balance   600  

Transactions  
   1 1  500 
   1  10  2000 
   -1  15 1500 
   -1   20 1000  
   -1   25 3000
 0

  Account number: 2000  Checking 
Customer Last name, First Name:  Garcia, Andy
 Beginning balance   800
Transactions: -1  20 550;  0

  Account number: 3000  Savings
Customer Last name, First Name:  Dupont, Debby
Beginning balance   9000
Transactions: -1 2 50 ;  -1 5 2000 ;  1 10 1500 ; 1 20  400; 0
 
Account number: 3500  Checking 
Customer Last name, First Name:  Spaulding, ramon
Beginning balance   900
Transactions: -1 10  500;  -1 20   200;   1 25  1500 ; 1  26 200  ;0
 

  Account number: 4000  Checking
Customer Last name, First Name:  Rice Mike
 Beginning balance   300  
Transactions:  0 none

Input/output:.  At your choice:  use the class System  or a GUI


