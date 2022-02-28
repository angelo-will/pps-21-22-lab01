import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountWithAtmTest extends AbstractBankAccountTest {

    @Override
    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testDeposit() {
        int initialAmount = 100;
        bankAccount.deposit(accountHolder.getId(), initialAmount);
        assertEquals(initialAmount, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        int initialAmountDeposited = 100;
        int secondAmountDeposited = 50;
        int wrongUserID = 2;
        bankAccount.deposit(accountHolder.getId(), initialAmountDeposited);
        bankAccount.deposit(wrongUserID, secondAmountDeposited);
        assertEquals(initialAmountDeposited, bankAccount.getBalance());
    }

    @Test
    void testDepositWithAtm() {
        int amountDeposited = 100;
        int transactionFee = 1;
        bankAccount.depositWithAtm(accountHolder.getId(), amountDeposited);
        assertEquals(amountDeposited - transactionFee, bankAccount.getBalance());
    }

    @Test
    void testWrongDepositWithAtm() {
        int initialAmountDeposited = 100;
        int secondAmountDeposited = 50;
        int wrongUserID = 2;
        int transactionFee = 1;
        bankAccount.depositWithAtm(accountHolder.getId(), initialAmountDeposited);
        bankAccount.depositWithAtm(wrongUserID, secondAmountDeposited);
        assertEquals(initialAmountDeposited-transactionFee, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(30, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(2, 70);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithAtm() {
        int initialAmountDeposited = 100;
        int amountWithdrawn = 70;
        int transactionsMade = 2;
        int transactionFee = 1;
        bankAccount.depositWithAtm(accountHolder.getId(), initialAmountDeposited);
        bankAccount.withdrawWithAtm(accountHolder.getId(), amountWithdrawn);
        assertEquals(initialAmountDeposited - amountWithdrawn - transactionFee * transactionsMade, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdrawAtm() {
        int initialAmountDeposited = 100;
        int amountWithdrawn = 70;
        int transactionsMade = 2;
        int transactionFee = 1;
        int wrongUserID = 2;
        bankAccount.depositWithAtm(accountHolder.getId(), initialAmountDeposited);
        bankAccount.withdrawWithAtm(accountHolder.getId(), amountWithdrawn);
        bankAccount.withdrawWithAtm(wrongUserID, amountWithdrawn);
        assertEquals(initialAmountDeposited - amountWithdrawn - transactionFee * transactionsMade, bankAccount.getBalance());
    }
}
