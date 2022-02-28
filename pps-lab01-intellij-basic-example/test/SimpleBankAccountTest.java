import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends AbstractBankAccountTest {

    @Override
    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, 0);
    }

    @Test
    void testDeposit() {
        int initialAmount = 100;
        bankAccount.deposit(accountHolder.getId(), initialAmount);
        assertEquals(initialAmount, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        int initialAmount = 100;
        int amountDeposited = 50;
        int wrongUserID = 2;
        bankAccount.deposit(accountHolder.getId(), initialAmount);
        bankAccount.deposit(wrongUserID, amountDeposited);
        assertEquals(initialAmount, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        int initialAmount = 100;
        int amountWithdrawn = 70;
        bankAccount.deposit(accountHolder.getId(), initialAmount);
        bankAccount.withdraw(accountHolder.getId(), amountWithdrawn);
        assertEquals(initialAmount-amountWithdrawn, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        int initialAmount = 100;
        bankAccount.deposit(accountHolder.getId(), initialAmount);
        int amountWithdrawn = 70;
        int wrongUserID = 2;
        bankAccount.withdraw(wrongUserID, amountWithdrawn);
        assertEquals(initialAmount, bankAccount.getBalance());
    }
}
