package Bank;

import java.util.Random;
import java.util.Scanner;

public class BankAccount {
    private String holderName;
    private String accNumber = "CNRB";
    private long balance = 0;
    private int accountPin;
    Random random = new Random();
    Scanner in = new Scanner(System.in);

    public BankAccount(String holderName, long balance) {
        this.setAccNumber();
        setAccountPin();
        this.holderName = holderName;
        this.balance = balance;
    }

    public BankAccount(String holderName) {
        this.setAccNumber();
        setAccountPin();
        this.holderName = holderName;
    }
    private Boolean checkPin(){
        int chance = 3;
        System.out.println("Enter the pin to proceed Withdraw : ");
        do{
             if(in.nextInt() == this.accountPin){
                 return true;
             }
             chance--;
            System.out.println("Enter the Correct Pin");
        }while(chance != 0);
        return false;
    }

    public String withdraw(long balance){
        if(checkPin()){
            if(balance<this.balance){
                setBalance(this.balance-balance);
                return "Rs :"+balance +"Has been successfully Withdrawn,Remaining balance :Rs :" + getBalance();
            }
            return "Insufficient Balance Withdraw has been Cancelled";
        }
        return "You are out of Try please try later";
    }

    public String deposit(long balance){
        setBalance(balance+this.balance);
        return "Rs : "+balance+"Has been Successfully Credited";
    }

    public String getHolderName() {
        return holderName;
    }

    private void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getAccNumber() {
        return accNumber;
    }

    private void setAccNumber() {
        this.accNumber += random.nextInt(100000,1000000);
    }

    public long getBalance() {
        return balance;
    }

    private void setBalance(long balance) {
        this.balance += balance;
    }

    public void setAccountPin() {
        this.accountPin = random.nextInt(1000,10000);
    }

    @Override
    public String toString() {
        return "holderName='" + holderName + "'\n" +
                "accNumber='" + accNumber + "'\n" +
                "balance=" + balance + '\n'+
                "accountPin=" + accountPin;
    }
}
