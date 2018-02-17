import Strings.FinanceReport;
import Strings.NegativeMeaning;
import Strings.Payment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import static Arrays.Arrays.*;//reverseArray;
import static simple.SimpleTasks.*;

/**
 * Created by student on 04.09.2017.
 */

public class Main {

//======================================================================================================================


    public static void main(String[] arg) throws NegativeMeaning, IOException {
        FinanceReport object = new FinanceReport(3);
        FileInputStream inputStream = new FileInputStream("..\\keeper.txt");
                //("..\\fleshka\\java\\laba1\\keeper.txt");
        object.read(inputStream);
        object.toString();
        System.out.println(object.getPaymentsOfPeople('s'));
        System.out.println(object.getPaymentsOfPeople(100000));
    }
}
