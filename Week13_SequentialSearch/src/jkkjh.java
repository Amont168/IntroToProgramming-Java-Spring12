import java.util.Scanner;
public class jkkjh {
		public static void main(String[] args){
			final int NUM_ACCOUNTS=3;
			
			BankAccount[] accounts= new BankAccount[NUM_ACCOUNTS];
			
			createAccounts(accounts);
			
			System.out.println("Here are the balances"+"of each account:");
			
			
			for (int index=0 index<account.length; index++){
				System.out.println("Account" + (index+1) + ": $" + accounts[index].getBalances());
			}
		}
			
			private static void createAccounts(BankAccount[] array){
				double balance;
				
				Scanner keyboard = new Scanner(System.in);
				
				for(int index=0; index < array.length; index++){
					System.out.print("Enter the balance for " + "account " + (index+1) + ": ");
					balance=keyboard.nextDouble();
					
					array[index] = new BankAccount(balance);
				}
			}
		}

