package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccountWithAtm extends AbstractBankAccount implements BankAccount {


    public static final int FEE_TRANSACTION = 1;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        super(balance, holder);
    }

    @Override
    protected double getFee() {
        return SimpleBankAccountWithAtm.FEE_TRANSACTION;
    }

}
