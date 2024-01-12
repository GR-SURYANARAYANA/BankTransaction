package Bank;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Operation {
    public Scanner in = new Scanner(System.in);
    BankAccount CreateAccount(){
        System.out.println("Enter the Name of the person : ");
        return BankAccount.CreateAccount(in.next());
    }
    private boolean checkBankAccPin(BankAccount account,String accNo){
        return Objects.equals(account.getAccNumber(), accNo) && account.checkPin("Change Pin");
    }

    BankAccount findAccount(ArrayList<BankAccount> accounts){
        System.out.println("Enter the Account number : ");
        String accNo = in.next();
        for (BankAccount account : accounts){
            if(checkBankAccPin(account,accNo)){
                return account;
            }
        }
        return null;
    }
    void confirmPin(BankAccount account){
        System.out.println("What's the 4 digit New Pin : ");
        int newPin = in.nextInt();
        if(newPin > 10000 ){
            System.out.println("Incorrect Pin Please Try again Later..!");
            return;
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("Please Confirm Your New Pin : ");
            if(newPin == in.nextInt()){
                System.out.println("Your pin has been successfully changed...!");
                account.setAccountPin(newPin);
                return;
            }
        }
        System.out.println("Please Retry after some Times");
    }
}
