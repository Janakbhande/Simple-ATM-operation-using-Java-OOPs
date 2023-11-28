package ATM_PACKAGE;
import java.util.*;
import java.text.*;
class Account
{
	Scanner sc= new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("'Rupee ',###,##0.00");
	private int CN; 
	private int PN;
	private double CB=2000;
	private double SB=1000;
	void setCustomerNumber(int a)
	{
		CN=a;
	}
	void setPinNumber(int b)
	{
		PN=b;	
	}
	int getCustomerNumber()
	{
		return CN;
	}
	int getPinNumber()
	{
		return PN;
	}
	double getCurrentBalance()
	{
		return CB;
	}
	double getSavingBalance()
	{
		return SB;
	}
	void getCurrentWithdrawInput()
	{
		System.out.println("Your current account balance: "+ df.format(CB));
		System.out.println("Please Enter the Amount You want to Withdraw");
		double amount =sc.nextDouble();
		
		if((CB-amount)>=0)
		{
			calcCurrentWithdraw(amount);
			System.out.println("Your new current account balance is : "+df.format(CB));
		}
		else
		{
			System.out.println("Your Balance is insufficient for this transaction");
		}
	}
	void getSavingWithdrawInput()
	{
		System.out.println("Your saving account balance: "+ df.format(SB));
		System.out.println("Please Enter the Amount You want to Withdraw");
		double amount =sc.nextDouble();
		
		if((SB-amount)>=0)
		{
			calcSavingWithdraw(amount);
			System.out.println("Your new saving account balance is : "+df.format(SB));
		}
		else
		{
			System.out.println("Your Balance is insufficient for this transaction");
		}
	}
	double calcCurrentWithdraw(double amount)
	{
		CB=CB-amount;
		return CB;
	}
	double calcSavingWithdraw(double amount)
	{
		SB=SB-amount;
		return SB;
	}
	void getCurrentDepositInput()
	{
		System.out.println("Your current account balance: "+ df.format(CB));
		System.out.println("Please Enter the Amount You want to Deposit: ");
		double amount =sc.nextDouble();
		
		if((CB+amount)>=0)
		{ 
			calcCurrentDeposit(amount);
			System.out.println("Your new current account balance is : "+df.format(CB));
		}
		else
		{
			System.out.println("Please Enter the Valid Amount.");
		}
	}
	void getSavingDepositInput()
	{
		System.out.println("Your saving account balance: "+ df.format(SB));
		System.out.println("Please Enter the Amount You want to Deposit: ");
		double amount =sc.nextDouble();
		
		if((SB+amount)>=0)
		{
			calcSavingDeposit(amount);
			System.out.println("Your new saving account balance is : "+df.format(SB));
		}
		else
		{
			System.out.println("Please Enter the Valid Amount.");
		}
	}
	double calcCurrentDeposit(double amount)
	{
		CB=CB+amount;
		return CB;
	}
	double calcSavingDeposit(double amount)
	{
		SB=SB+amount;
		return SB;
	}
}
class OptionMenu extends Account
{
	Scanner sc= new Scanner(System.in);
	HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	DecimalFormat df = new DecimalFormat("'Rupee ',###,##0.00");
	void getLogin()
	{	
		int x=1;
		do
		{
			try
			{
				hm.put(11111, 111);
				hm.put(22222, 222);
				hm.put(33333, 333);
				hm.put(44444, 444);
				hm.put(55555, 555);
				
				System.out.println("Welcome to MSBECL ATM."+ "\n");
				System.out.print("Enter your customer number : ");
				setCustomerNumber(sc.nextInt());	
				System.out.print("Enter your PIN number : ");
				setPinNumber(sc.nextInt());	
				
				int p=getCustomerNumber();
				int q=getPinNumber();
				
				if(hm.containsKey(p) && hm.get(p) ==q)
				{
					getAccountType();
				}
				else
				{
					System.out.println("\n" + "Wrong Customer Number or Pin Number." + "\n" + "Please enter with valid Account Number and Pin Number.");
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("\n"+"Please enter only Numbers."+"\n"+"Characters and Symbols are not allowed.");
				x=2;
			}
		}
		while(x==1);
	}
	void getAccountType()
	{
		System.out.println("\n" + "Select the Account Type you Want to Access:");
		System.out.println("Type 1 - Current Account");
		System.out.println("Type 2 - Saving Account");
		System.out.println("Type 3 - Exit");
		System.out.print("Enter your choice: ");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			getCurrent();
			break;
		case 2:
			getSaving();
			break;
		case 3:
			System.out.println("Thank You for Visiting."+"Visit Again.");
			getLogin();
			break;
		default:
			System.out.println("Invalid choice."+"\n"+"Please enter again your choice.");
			break;			
		}
	}
	void getCurrent()
	{
//		Current Account
		System.out.print("\n"+"Current Account:"+"\n");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.print("Enter your choice: ");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Your current account balance : "+ df.format(getCurrentBalance())+"\n");
			getAccountType();
			break;
		case 2:
			getCurrentWithdrawInput();
			getAccountType();
			break;
		case 3:
			getCurrentDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank You for Visiting."+"\n"+"Visit Again.");
			getAccountType();
			break;
		default:
			System.out.println("Invalid Input."+"\n"+"Please Enter your Choice Again.");
			break;
		}
	}
	void getSaving()
	{
//		Saving Account
		System.out.println("\n"+"Saving Account"+"\n");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.print("Enter your choice: ");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Your current account balance : "+ df.format(getSavingBalance())+"\n");
			getAccountType();
			break;
		case 2:
			getSavingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getSavingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank You for Visiting."+"\n"+"Visit Again.");
			getAccountType();
			break;
		default:
			System.out.println("Invalid Input."+"\n"+"Please Enter your Choice Again.");
			break;
		}
	}
}
public class ATM_17_10  extends OptionMenu
{
	public static void main(String[] args) 
	{
		OptionMenu om = new OptionMenu();
		om.getLogin();
	}
}