package Strings;

import java.util.Arrays;

public class Payment {
    private String fullname;
    private int day;
    private int month;
    private int year;
    private int amountOfPayment;
    private boolean leap_year;
    private int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Payment(String fullname, int day, int month, int year, int amountOfPayment) throws NegativeMeaning {
        setFullname(fullname);
        setData(day, month, year);
        setAmountOfPayment(amountOfPayment);
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setData(int day, int month, int year) throws NegativeMeaning {
        if (checkData(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    public void setAmountOfPayment(int amountOfPayment) {
        if (amountOfPayment > 0) {
            this.amountOfPayment = amountOfPayment;
        } else {
            this.amountOfPayment = 0;
        }
    }

    public boolean checkData(int day, int month, int year) throws NegativeMeaning {
        this.leap_year = (year % 4 == 0) ? true : false;
        if ((year < 1900 || year > 2017) || (month < 1 || month > 12) || (day < 1)) {
            throw new NegativeMeaning("Некорректно введенные данные");
        }
        if (day > this.daysInMonths[month-1] || (this.leap_year && (month == 2-1 ) && (day > 29))) {
            throw new NegativeMeaning("Некорректно введенные данные");
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (day != payment.day)     return false;
        if (month != payment.month) return false;
        if (year != payment.year)   return false;
        if (amountOfPayment != payment.amountOfPayment) return false;
        if (leap_year != payment.leap_year) return false;
        return fullname.equals(payment.fullname);
    }

    @Override
    public int hashCode() {
        int result = fullname.hashCode();
        result = 31 * result + day;
        result = 31 * result + month;
        result = 31 * result + year;
        result = 31 * result + amountOfPayment;
        result = 31 * result + (leap_year ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return  fullname +
                ';' + day +
                '.' + month +
                '.' + year +
                ';' + amountOfPayment +
                '|';
    }

    public String getFullname() {
        return fullname;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getAmountOfPayment() {
        return amountOfPayment;
    }
}

/*      Создайте класс Payment (платеж) с полями: ФИО человека (одна строка),
        дата платежа — число, месяц и год (целые числа), сумма платежа
        (целое число — сумма в копейках).
        Напишите необходимые конструкторы, геттеры/сеттеры, методы equals, hashCode, toString.*/