package Strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FinanceReport {
    private Payment[] payments;

    /*public FinanceReport (int[] payments, int amountPayments) throws NegativeMeaning {
        if (payments == null || amountPayments <= 0) throw new NegativeMeaning("NullPtr");
        this.payments = payments;
        this.amountPayment = amountPayments;
    }*/

    public FinanceReport (int amountPayments) throws NegativeMeaning {
        if (amountPayments <= 0) throw new NegativeMeaning("NullPtr");
        payments = new Payment[amountPayments];
    }

    public FinanceReport () {
    }

    public void read() throws IOException, FileNotFoundException {
        FileInputStream inputStream = new FileInputStream("D:\\fleshka\\java\\laba1\\keeper.txt");
        int data = inputStream.read();
        char content;
        while(data != -1) {
            content = (char) data;
            System.out.print(content);
            data = inputStream.read();
        }
        inputStream.close();
    }

    public void write() throws FileNotFoundException, IOException, NegativeMeaning {
        if (this.getAmountOfPayment() <= 0) throw new NegativeMeaning("Bad size");
        FileOutputStream outputStream = new FileOutputStream("D:\\fleshka\\java\\laba1\\keeper.txt", true);
        for (int i = 0; i < getAmountOfPayment(); i++) {
            byte[] buffer = payments[i].toString().getBytes();
            outputStream.write(buffer);
        }
        outputStream.close();
    }

    public int getAmountOfPayment() {
        return payments.length;
    }

    public void setPayments(int position, Payment object) {
        payments[position] = object;
    }

    public Payment gerPayment(int position) {
        return payments[position];
    }
}

/*
 Создайте класс FinanceReport, содержащий массив платежей.
  Методы: ввод/вывод из потока, получение количества платежей, доступ к i-му платежу (на чтение и запись).
 */