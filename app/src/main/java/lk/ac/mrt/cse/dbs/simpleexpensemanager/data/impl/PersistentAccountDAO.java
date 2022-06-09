package lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.Constants;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.AccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.exception.InvalidAccountException;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Account;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.ExpenseType;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Transaction;

import android.database.Cursor;
import  android.database.sqlite.*;
import android.os.Environment;
import android.support.annotation.NonNull;
public class PersistentAccountDAO implements AccountDAO {
    SQLiteDatabase expenseManangerdb;
    java.io.File file = Constants.CONTEXT.getFilesDir();
    public PersistentAccountDAO()
    {
        expenseManangerdb = SQLiteDatabase.openOrCreateDatabase(file.getAbsolutePath() + "/meenambika.sqlite", null);
        expenseManangerdb.execSQL("CREATE TABLE IF NOT EXISTS AccountInfo(accountNo VARCHAR(20),bankName VARCHAR(100),accountHolderName VARCHAR(40), balance NUMERIC(12,2));");
    }

    @Override
    public List<String> getAccountNumbersList() {
        List<String> resultList = new ArrayList<String>();
        return resultList;
    }

    @Override
    public List<Account> getAccountsList() {

        List<Account> acc = new ArrayList<Account>();
        return acc;
    }

    @Override
    public Account getAccount(String accountNo) throws InvalidAccountException {
        return Account account;
    }

    @Override
    public void addAccount(Account account) {
        expenseManangerdb.execSQL("INSERT INTO AccountInfo VALUES('"+account.getAccountNo()+"','"+account.getBankName()+"','"+account.getAccountHolderName()+"','"+account.getBalance()+"');");
    }

    @Override
    public void removeAccount(String accountNo) throws InvalidAccountException {
        expenseManangerdb.execSQL("DELETE FROM AccountInfo WHERE accountNo='"+accountNo+"';");
    }

    @Override
    public void updateBalance(String accountNo, ExpenseType expenseType, double amount) throws InvalidAccountException {
        Account account = getAccount(accountNo);
        double currentbalance=account.getBalance();
        if (expenseType.equals(ExpenseType.INCOME)) {
          currentbalance =currentbalance +amount;
        } else
            currentbalance =currentbalance +amount;
        expenseManangerdb.execSQL("UPDATE AccountInfo SET balance='"+currentbalance+"' WHERE accountNo='"+accountNo+"';");
    }

}
