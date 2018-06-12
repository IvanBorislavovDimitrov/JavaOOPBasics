import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Set<BankAccount> accounts = new HashSet<>();
        String line;
        while (!"End".equals(line = input.readLine())) {
            String[] lineInfo = line.split("\\s+");
            try {
                performCommand(lineInfo, accounts);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void performCommand(String[] lineInfo, Set<BankAccount> accounts) {
        String command = lineInfo[0];
        Integer id = Integer.valueOf(lineInfo[1]);
        switch (command) {
            case "Create":
                addAccount(accounts, id);
                break;
            case "Withdraw":
                double amount = Double.parseDouble(lineInfo[2]);
                withdrawMoney(accounts, id, amount);
                break;
            case "Deposit":
                amount = Double.parseDouble(lineInfo[2]);
                deposit(accounts, id, amount);
                break;
            case "Print":
                printAccount(accounts, id);
                break;
        }
    }

    private static void deposit(Set<BankAccount> accounts, Integer id, double amount) {
        BankAccount bankAccount = getAccount(accounts, id);
        if (bankAccount == null) {
            throw new IllegalArgumentException("Account does not exist");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }

        bankAccount.setBalance(bankAccount.getBalance() + amount);
    }

    private static void printAccount(Set<BankAccount> accounts, Integer id) {
        BankAccount bankAccount = getAccount(accounts, id);
        if (bankAccount == null) {
            throw new IllegalArgumentException("Account does not exist");
        }

        System.out.println(bankAccount);
    }

    private static BankAccount getAccount(Set<BankAccount> accounts, Integer id) {
        Optional<BankAccount> bankAccount = accounts.stream().filter(x -> x.getId().equals(id))
                .findFirst();
        return bankAccount.orElse(null);
    }

    private static void withdrawMoney(Set<BankAccount> accounts, Integer id, double amount) {
        BankAccount neededAccount = getAccount(accounts, id);
        if (neededAccount == null) {
            throw new IllegalArgumentException("Account does not exist");
        }

        if (neededAccount.getBalance() - amount >= 0) {
            neededAccount.setBalance(neededAccount.getBalance() - amount);
        } else {
            throw new IllegalArgumentException("Insufficient balance");
        }
    }

    private static boolean doesAccountExist(Set<BankAccount> accounts, Integer id) {
        return accounts.stream().anyMatch(x -> x.getId().equals(id));
    }

    private static void addAccount(Set<BankAccount> accounts, Integer id) {
        if (!doesAccountExist(accounts, id)) {
            BankAccount account = new BankAccount();
            account.setId(id);
            accounts.add(account);
        } else {
            throw new IllegalArgumentException("Account already exists");
        }
    }
}
