Author:
@https://github.com/zahidari


This is a Bank program written in JAVA and in Turkish language for a Final Project Assignment
The following tasks are fulfilled->

#####################################################################################################
Object-Oriented Programming

Final Project Assignment
(Due Date: May 23, 2022)

In this project, you are expected to implement a Java application for a newly established bank. This bank should have four different types of accounts: Short-Term, Long-Term, Special, and Current accounts. Each account type should have its own specific features as described below:

The Account class should be defined as abstract.
Each object derived from this class represents a bank account.
This class should have the following functions:
deposit: used to deposit money into the account.
withdraw: used to withdraw money from the account.
During this operation, attention should be paid to the account type and the current balance.
(Consider features like specifying the maximum withdrawal amount and giving an error if attempting to withdraw more than the available balance.)
getBalance: used to display the current balance of the account.
getID: used to display the account number. (The account number is a fixed integer.)
Benefit: calculates the profit based on the account's opening date and transaction date.
(If the annual profit rate is 'r', the daily profit is calculated as 'r/365'.)
The following rules should be defined for the four types of accounts in the program:

ShortTerm: This type of account provides an annual interest rate of 17% and requires a minimum balance of 1000 TL.
LongTerm: This type of account provides an annual interest rate of 24% and requires a minimum balance of 1500 TL.
Special: This type of account provides an annual interest rate of 12% and requires a minimum balance equal to the initial deposit.
Current: This account is interest-free, and there is no requirement for a minimum balance.
To control the entire system, another class (Bank) should be defined. This class should have a member field of type Account to store the addresses of all accounts. This class should have the following functions:

getAccount: used to display the list of existing accounts.
getDate: used to display the current system date.
deposit(ID, cash): used to deposit a specified amount of money into the account with the given ID.
withdraw(ID, cash): if possible, used to withdraw a specified amount of money from the account.
(The success or failure of the transaction should be communicated to the user.)
sortition: used to conduct a lottery among Special accounts. For every 2000 TL in a Special account, a point should be assigned, and the lottery should be based on these points.
(Accounts with higher points have a higher chance of being selected.)
The account selected in the lottery receives a reward of 10,000 TL, which is deposited into their account.
IMPORTANT NOTE: There should be only one object inside the main function, and this object should be created from the "Bank" class.

The program should enable the user to perform the following actions:

Create_S_ID_balance: Open a Short-Term account (account number=ID, initial balance=balance).
Create_L_ID_balance: Open a Long-Term account (account number=ID, initial balance=balance).
Create_O_ID_balance: Open a Special account (account number=ID, initial balance=balance).
Create_C_ID_balance: Open a Current account (account number=ID, initial balance=balance).
Increase_ID_cash: Add an amount of "cash" to the account with the specified ID.
Decrease_ID_cash: Withdraw an amount of "cash" from the account with the specified ID.
Set_dd_mm_yy: Set the current system date.
ShowAccount: Display the IDs of all accounts and their last 5 transactions.
ShowIDs: List all account numbers in the system.
Sortition: Conduct a lottery for Special accounts and display the result.
NOTES:

Default start date of the system = February 14, 2022.
You can add additional features (variables and methods) to the classes as needed.
Account balances must be integers.
Assignment Submission and Presentation:

You need to prepare a report containing the working code of the project. The report should include the Java code and a UML class diagram of the project.

For group projects, a maximum of 4 students can work together. Students working in groups should include their student numbers, names, and surnames in their reports.

Please refrain from sending emails related to the project's implementation, as all the necessary information is provided in this document. The report file should follow this structure:

General Summary: Explain the logic of how your project works.
Definitions: Describe the class/object structures, methods, and variables you've created in your project.
Output: Provide a few examples with screenshots demonstrating the operation of your project.
##########################################################################################

Every point was covered by this project.


These are the commands in English.
you can:

 1: currentAcc create
 2: ShortTermAcc create (20% annualy)(min 1000$ must have)
 3: longTemAcc create(24%)(min 1000$ must have)
 4: specialAcc create (choose%)
 5: deposit with acc ID
 6: withdraw with acc ID
 7: View all accounts with the last five transactions
 8: See all account IDs
 9: Making transactions according to the selected account ID
10: View the bank transaction date
11: Changing the bank's transaction date
12: show today's date
13: Draw between specialAcc, winner gets 10000$
14: according to the date depositing interest into accounts
15: Shutting down the system

Enter the required number for
#########################################

project development can be continued.

########################################
Examples....

-using accountCounter.txt
-using ID_to_cash.txt

-or just creating database and save all the informations there.

-create UI.
-write an English language support

