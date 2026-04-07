class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message) {
        super(message);  // pass message to Exception parent
    }
}

class BankAccount {
    double balance;

    BankAccount(double balance) { this.balance = balance; }

    void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance)
            throw new InsufficientFundsException(
                    "Need " + amount + " but only have " + balance);
        balance -= amount;
        System.out.println("Withdrew: " + amount);
    }
}

public class Multi_tryCatch {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(500);
        try {
            acc.withdraw(200);
            acc.withdraw(400);  // this will throw
        } catch (InsufficientFundsException e) {
            System.out.println("Custom error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General error: " + e.getMessage());
        }
    }
}
