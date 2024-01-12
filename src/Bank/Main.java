package Bank;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BankAccount surya = new BankAccount("Surya narayana GR");
        while(true){
            System.out.println("Enter the choice to perform transaction : ");
            System.out.print("1.To get info \n2.Deposit intoAccount \n3.Withdraw from Account \n4.Exit Transaction\nEnter your Choice:");
            switch (in.nextInt()){
                case 1 -> System.out.println(surya);
                case 2 ->{
                    System.out.println("Enter the amount to deposit : ");
                    System.out.println(surya.deposit(in.nextLong()));
                }
                case 3->{
                    System.out.println("Enter the amount to withdraw : ");
                    System.out.println(surya.withdraw(in.nextLong()));
                }
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice..! Please Enter the valid choice");
            }
            System.out.println("Press Enter to continue");
            System.in.read();
        }
    }
}
