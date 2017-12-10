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

    public FinanceReport(Payment[] payments) {
        this.payments = payments;
    }

    public void read() throws IOException, NegativeMeaning  {
        try(FileInputStream inputStream = new FileInputStream("H:\\fleshka\\java\\laba1\\keeper.txt"))
        {
            int step = 0;
            int data;
            char content;
            StringBuilder temp = new StringBuilder();
            while((data = inputStream.read())!= -1){
                content = (char) data;
                temp.append(content);
                if (content == '|') {
                    System.out.println(temp);

                    String fullname = temp.substring(0, temp.indexOf(";"));
                    temp.delete(0, temp.indexOf(";") + 1);

                    int day = Integer.parseInt(temp.substring(0, temp.indexOf(".")));
                    temp.delete(0, temp.indexOf(".") + 1);
                    int month = Integer.parseInt(temp.substring(0, temp.indexOf(".")));
                    temp.delete(0, temp.indexOf(".") + 1);
                    int year = Integer.parseInt(temp.substring(0, temp.indexOf(";")));
                    temp.delete(0, temp.indexOf(";") + 1);

                    int amountOfPayment = Integer.parseInt(temp.substring(0, temp.length() - 1));
                    temp.delete(0, temp.length());
                    this.payments[step] = new Payment(fullname, day, month, year, amountOfPayment);
                    step++;
                }
            }
            inputStream.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void write() throws IOException, NegativeMeaning {
        if (this.getAmountOfPayment() <= 0) throw new NegativeMeaning("Bad size");
        FileOutputStream outputStream = new FileOutputStream("H:\\fleshka\\java\\laba1\\keeper.txt", true);
        for (int i = 0; i < getAmountOfPayment(); i++) {
            byte[] buffer = payments[i].toString().getBytes();
            outputStream.write(buffer);
        }
        outputStream.close();
    }

    public String getPaymentsOfPeople(char firstLetter) {
        if (payments == null) return "No data";
        String string = "";
        for (Payment payment : payments) {
            if (payment.getFullname().toLowerCase().charAt(0) == firstLetter) {
                string = string.concat(String.format(
                        "Плательщик \"%s\" дата: %02d.%02d.%d сумма: %02d руб. %d коп.",
                        payment.getFullname(), payment.getDay(), payment.getMonth(), payment.getYear(),
                        payment.getAmountOfPayment() / 100, payment.getAmountOfPayment() % 100));
                string = string.concat("\n");
            }
        }
        return string;
    }

    public String getPaymentsOfPeople(int value) {
        if (payments == null) return "No data";
        String string = "";
        for (Payment payment : payments) {
            if (payment.getAmountOfPayment() < value) {
                string = string.concat(String.format(
                        "Плательщик \"%s\" дата: %02d.%02d.%d сумма: %02d руб. %d коп.",
                        payment.getFullname(), payment.getDay(), payment.getMonth(), payment.getYear(),
                        payment.getAmountOfPayment() / 100, payment.getAmountOfPayment() % 100));
                string = string.concat("\n");
            }
        }
        return string;
    }

    public int getAmountOfPayment() {
        return payments.length;
    }

    public void setPayments(int position, Payment object) throws NegativeMeaning {
        if (position < 0 || position >= payments.length)
            throw new NegativeMeaning("Bad size");
        payments[position] = object;
    }

    public Payment getPayment(int position) throws NegativeMeaning {
        if (position < 0 || position >= payments.length)
            throw new NegativeMeaning("Bad size");
        return payments[position];
    }

    public void setPayments(Payment[] payments) {
        this.payments = payments;
    }

    public Payment[] getPayments() {
        return payments;
    }

}

/*
 Создайте класс FinanceReport, содержащий массив платежей.
  Методы: ввод/вывод из потока, получение количества платежей, доступ к i-му платежу (на чтение и запись).
 */