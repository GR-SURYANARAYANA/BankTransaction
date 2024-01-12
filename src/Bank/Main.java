package Bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        while(true){
                Operation operation = new Operation();
                Scanner in = new Scanner(System.in);
                System.out.println("Welcome to Jogger's Bank");
                System.out.println("1.To create A new Account");
                System.out.println("2.To Change the Account Pin");
                System.out.println("3.To transact Amount ");
                System.out.println("4.Exit Bank\n Enter the choice : ");
                switch (in.nextInt()){
                    case 1 -> {
                        BankAccount account =operation.CreateAccount();
                        accounts.add(account);
                        System.out.println("Account created successfully");
                        System.out.println("Here is account Information : ");
                        System.out.println(account);
                    }
                    case 2 -> {
                        BankAccount account = operation.findAccount(accounts);
                        System.out.println(accounts);
                        if (account != null){
                            operation.confirmPin(account);
                        }else{
                            System.out.println("Entered  invalid Account Number.");
                            System.out.println("Please try again..!");
                        }
                    }
                    case 3 ->{
                        BankAccount account = operation.findAccount(accounts);
                        if (account != null){
                            account.transact();
                        }else{
                            System.out.println("Entered  invalid Account Number.");
                            System.out.println("Please try again..!");
                        }
                    }
                    case 4->{return;}
                    default -> System.out.println("Incorrect choice..!Enter valid choice ");
                }
                BankAccount.pressKey();
            }
        }
    }
