package Task3_AtmInterface;
import java.util.*;

class BankAccount {
    private double balance;

    public BankAccount(double initalBalance) {
        this.balance = initalBalance;
    }

    public void deposit(double amount) {
        if(amount > 0 ) {
            balance += amount;
            System.out.println("Deposit successful! current balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }


     public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! Current Balance: " + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
     }

        public void checkBalance() {
        System.out.println("Your Current Balance: " + balance);
    }
}

class AtmInterface {
      private BankAccount account;
      private Scanner sc;

   
    public AtmInterface(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }
    
    public void displayMenu() {
        System.out.println("\n--- ATM Menu ---");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void processChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.print("Enter amount to withdraw: ");
            try {
                double wAmount = sc.nextDouble();
                account.withdraw(wAmount);
            }  catch (Exception e ) {
                System.out.println("Invalid amount entered!");
                sc.next();
            }
            break;
            case 2:
                System.out.print("Enter amount to deposit: ");
            try {
                double dAmount = sc.nextDouble();
                account.deposit(dAmount);
            }  catch (Exception e ) {
                System.out.println("Invalid amount entered!");
                sc.next();

            }  
                break;
            case 3:
                account.checkBalance();
                break;
            case 4:
                System.out.println("Thank you for using the ATM!");
                sc.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    public static void main(String args[]) {
        BankAccount userAccount = new BankAccount(1000); 
        AtmInterface atm = new AtmInterface(userAccount);

        while (true) {
            atm.displayMenu();
            int choice ;
            try  { 
                choice = atm.sc.nextInt();
            } catch (Exception e ) {
                System.out.println("Invalid input! Please enter a number : ");
                atm.sc.next();
                continue;
            }
            atm.processChoice(choice);
        }
    }
}