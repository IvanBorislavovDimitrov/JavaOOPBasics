import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<BankAccount> bankAccounts = new ArrayList<>();

        String line;
        while (!"End".equals(line = input.readLine())) {
            String[] accountInfo = line.split("\\s+");
            try {
                performInformation(bankAccounts, accountInfo);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void performInformation(List<BankAccount> bankAccounts, String[] accountInfo) {
        String command = accountInfo[0];
        switch (command) {
            case "Create":
                System.out.println(addAccount(bankAccounts));
                break;
            case "Deposit":
                int id = Integer.parseInt(accountInfo[1]);
                double amount = Double.parseDouble(accountInfo[2]);
                System.out.println(deposit(bankAccounts, id, amount));
                break;
            case "GetInterest":
                id = Integer.parseInt(accountInfo[1]);
                int years = Integer.parseInt(accountInfo[2]);
                System.out.println(getInterest(bankAccounts, id, years));
                break;
            case "SetInterest":
                double interestRate = Double.parseDouble(accountInfo[1]);
                BankAccount.setInterestRate(interestRate);
                break;
        }
    }

    private static String getInterest(List<BankAccount> bankAccounts, int id, int years) {
        BankAccount account = getAccount(bankAccounts, id);
        if (account == null) {
            throw new IllegalArgumentException("Account does not exist");
        }

        return String.format("%.2f", account.getInterest(years));
    }

    private static String deposit(List<BankAccount> bankAccounts, int id, double amount) {
        BankAccount account = getAccount(bankAccounts, id);
        if (account == null) {
            throw new IllegalArgumentException("Account does not exist");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }

        account.addAmount(amount);
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");

        return String.format("Deposited %s to ID%d", decimalFormat.format(amount), account.getId());
    }

    private static BankAccount getAccount(List<BankAccount> bankAccounts, int id) {
        Optional<BankAccount> bankAccount =  bankAccounts.stream().filter(x -> x.getId() == id).findFirst();

        return bankAccount.orElse(null);
    }

    private static boolean doesAccountExist(List<BankAccount> bankAccounts, int id) {
        return bankAccounts.stream().anyMatch(x -> x.getId() == id);
    }

    private static String addAccount(List<BankAccount> bankAccounts) {
        BankAccount bankAccount = new BankAccount();
        bankAccounts.add(bankAccount);

        return String.format("Account ID%d created", bankAccount.getId());
    }
}
