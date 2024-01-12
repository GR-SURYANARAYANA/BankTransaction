package Bank;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class BankAccount {
    private String holderName;
    private String accNumber = "CNRB";
    private long balance = 0;
    private int accountPin;
    Random random = new Random();
    Scanner in = new Scanner(System.in);

    private BankAccount(String holderName) {
        this.setAccNumber();
        setAccountPin();
        this.holderName = holderName;
    }

    /**
     * The overall Transaction will be played by this method
     * @throws Exception
     */
    protected void transact() throws Exception{
        while(true){
            System.out.println("Enter the choice to perform transaction : ");
            System.out.print("1.To get info \n2.Deposit intoAccount \n3.Withdraw from Account \n4.Exit Transaction\nEnter your Choice:");
            switch (in.nextInt()){
                case 1 -> System.out.println(this);
                case 2 ->{
                    System.out.println("Enter the amount to deposit : ");
                    System.out.println(this.deposit(in.nextLong()));
                }
                case 3->{
                    System.out.println("Enter the amount to withdraw : ");
                    System.out.println(this.withdraw(in.nextLong()));
                }
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice..! Please Enter the valid choice");
            }
            pressKey();
        }
    }

    public static void pressKey() throws IOException {
        System.out.println("Press Enter to continue");
        System.in.read();
    }

    /**
     * This method is used to check whether user entered pin is correct or not
     * @param msg
     * @return
     */
    protected Boolean checkPin(String msg){
        int chance = 3;
        System.out.println("Enter Present Pin to "+msg+" :");
        do{
             if(in.nextInt() == this.accountPin){
                 return true;
             }
             chance--;
            System.out.println("Invalid Pin..! Please Enter the Valid Pin");
        }while(chance != 0);
        return false;
    }

    /**
     * The balance of account will be withdrawn and it recalls confirm pin to withdraw the money
     * @param balance
     * @return
     */
    public String withdraw(long balance){
        if(checkPin("Withdraw Amount")){
            if(balance<this.balance){
                setBalance(this.balance-balance);
                return "Rs :"+balance +" Has been successfully Withdrawn,Remaining balance :Rs :" + getBalance();
            }
            return "Insufficient Balance Withdraw has been Cancelled";
        }
        return "You are out of Try please try later";
    }

    /**
     * Deposit method to deposit amount into the account
     * @param balance
     * @return
     */
    public String deposit(long balance){
        setBalance(balance+this.balance);
        return "Rs : "+balance+" Has been Successfully Credited";
    }

    /**
     * The Factory Method which helps to invoke the constructor to hide duplicates
     * @param name
     * @return
     */
    public static BankAccount CreateAccount(String name){
        return new BankAccount(name);
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
        this.balance = balance;
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

    public void setAccountPin(int newPin) {
     this.accountPin = newPin;
    }
}
