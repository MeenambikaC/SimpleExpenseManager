package lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.Constants;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.TransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Account;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.ExpenseType;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Transaction;

public class PersistentTransactionDAO implements TransactionDAO{
    SQLiteDatabase expenseManangerdb;
    java.io.File file = Constants.CONTEXT.getFilesDir();
    public PersistentTransactionDAO()
    {
        expenseManangerdb = SQLiteDatabase.openOrCreateDatabase(file.getAbsolutePath() + "/meenambika.sqlite", null);
        expenseManangerdb.execSQL("CREATE TABLE IF NOT EXISTS TransactionsInfo(accountNo VARCHAR(20),expenseType VARCHAR(20),amount NUMERIC(12,2), date_value Date);");
    }


    @Override
    public void logTransaction(Date date, String accountNo, ExpenseType expenseType, double amount) {
        expenseManangerdb.execSQL("INSERT INTO TransactionsInfo VALUES('"+accountNo+"','"+((expenseType==ExpenseType.INCOME)?"INCOME":"EXPENSE")+"','"+amount+"','"+date.toString()+"');");
    }

    @Override
    public List<Transaction> getAllTransactionLogs() {
        List<Transaction> resultList = new ArrayList<Transaction>();

        return resultList;
    }

    @Override
    public List<Transaction> getPaginatedTransactionLogs(int limit) {
        List<Transaction> resultList = new ArrayList<Transaction>();
        return resultList;
    }
}
