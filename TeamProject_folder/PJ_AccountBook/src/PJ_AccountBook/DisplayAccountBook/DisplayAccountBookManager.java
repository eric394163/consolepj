package PJ_AccountBook.DisplayAccountBook;

import java.util.Scanner;

import PJ_AccountBook.AccountBook;

public class DisplayAccountBookManager implements DisplayAccountBookInterface {
    private AccountBook myAccountBook;

    private Scanner sc = new Scanner(System.in);

    public DisplayAccountBookManager(AccountBook accountBook) {
        this.myAccountBook = accountBook;
    }

    @Override
    public void DisplayAccountBookRun() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'DisplayAccountBookRun'");
    }

    

}
