package lk.ac.mrt.cse.dbs.simpleexpensemanager.control;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.AccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.TransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistentAccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistentTransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Account;

public class PersistentExpenseManager extends ExpenseManager{
    public PersistentExpenseManager() {
        setup();
    }

    @Override
    public void setup() {
        /*** Begin generating dummy data for In-Memory implementation ***/

        AccountDAO AccountDAO = new PersistentAccountDAO();
        setAccountsDAO(AccountDAO);

        TransactionDAO TransactionDAO = new PersistentTransactionDAO();
        setTransactionsDAO(TransactionDAO);

        Account accountOne = new Account("34256A", "HNB", "Meenambika Chnadirakumar", 12321.50);
        Account accountTwo = new Account("12567B", "Commericial", "Roobini Sriharan", 80000.45);
        Account accountThree = new Account("25467C", "NSB", "Ahaana Srithar", 12320.53);
        getAccountsDAO().addAccount(accountOne);
        getAccountsDAO().addAccount(accountTwo);
        getAccountsDAO().addAccount(accountThree);
    }
}
