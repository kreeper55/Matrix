import Strings.FinanceReport;
import Strings.NegativeMeaning;
import Strings.Payment;

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

        /*Payment Max = new Payment("MMA", 27,12,1998, 10000);
        Payment Slava = new Payment("SUN", 23,11,1998, 1000);
        Payment Ilusha = new Payment("KII", 20,9,1997, 100000);
        FinanceReport object = new FinanceReport(3);
        object.setPayments(0, Max);
        object.setPayments(1, Slava);
        object.setPayments(2, Ilusha);
        object.write();*/
        FinanceReport object = new FinanceReport(3);
        object.read();
        object.toString();
        System.out.println(object.getPaymentsOfPeople('s'));
        /*String[] strings = {"",
                            "_qq_",
                            "___123_erty_11_",
                            "__firstword__sdh_gd____fh___",
                            "___fh__sdh_gd____firstword__",
                            "__oneWord__",
                            "__oneWord___",
                            "___oneWord__" };
        for (int i = 0; i < strings.length; i++) {
            StringBuilder s_buffer = new StringBuilder(strings[i].subSequence(0, strings[i].length()));
            System.out.println(StringProcessor.replaceWords(s_buffer).toString());
        }



        /*
        System.out.println();
        lineEq(0,0,0, 0,0,0);
        System.out.println();
        lineEq(0,0,1, 0,0,1);
        lineEq(0,0,1, 0,0,0);
        lineEq(0,0,0, 0,0,1);
        lineEq(1,0,10,1,0,5);
        lineEq(0,1,10,0,1,4);
        lineEq(0,0,1, 2,3,4);
        lineEq(1,2,3, 2,4,3);
        System.out.println();
        lineEq(1,1,2, 2,2,4);
        lineEq(0,0,0, 1,2,3);
        lineEq(1,0,0, 0,0,0);
        lineEq(0,0,0, 0,1,0);
        lineEq(1,1,0, 0,0,0);
        System.out.println();
        lineEq(1,2,3, 4,5,6);


        /*
        Point3D pointA = new Point3D();
        Point3D pointB = new Point3D(1, 2, 1);
        Point3D pointC = new Point3D(1, 2, 1);
        System.out.println("PointA == PointB ? " + pointA.equals(pointB));
        System.out.println("PointB == PointC ? " + pointB.equals(pointC));
        /*
        Vector3D vectorA = new Vector3D(1, 2, -1);
        Vector3D vectorB = new Vector3D(vectorA);
        System.out.println("VectorA == VectorB ? " + vectorA.equals(vectorB));
                case 17: {
        System.out.println("Vector3DProcessor");
        Vector3D vectorA = new Vector3D(1, 2, -1);
        Vector3D vectorB = new Vector3D(2, 4, -2);
        Vector3D vectorC = new Vector3D();

        vectorC = Vector3DProcessor.additionVectors(vectorA, vectorB);
        System.out.println("A + B = " + vectorC.toString());
        vectorC = new Vector3D();

        vectorC = Vector3DProcessor.substructionVectors(vectorA, vectorB);
        System.out.println("A - B = " + vectorC.toString());
        vectorC = new Vector3D();

        System.out.println("A * B = " + Vector3DProcessor.scalarMultiplicationVectors(vectorA, vectorB));

        vectorC = Vector3DProcessor.vectorMultiplicationVectors(vectorA, vectorB);
        System.out.println("|A x B| = " + vectorC.toString());

        System.out.println(" A || B ?  - " + Vector3DProcessor.equals(vectorA, vectorB));
        break;
    }
                case 18: {
        System.out.println("Vector3DArray");
        Vector3D vectorA = new Vector3D(1, 2, -1);
        Vector3D vectorB = new Vector3D(2, 4, -2);
        Vector3D vectorC = new Vector3D(1, 0, 0);

        Vector3DArray arrayVectors = new Vector3DArray(vectorA, vectorB, vectorB);
        System.out.println("максимальная длина векторов: " + arrayVectors.maxLengthOfVector3D());
        System.out.println("первое вхождение вектора: " + arrayVectors.findFirstVector(2, 4, -2));
        System.out.println("сумма векторов массива: " + arrayVectors.sumVectors());
        System.out.println("заменяем вектор (0 - выполнено) " + arrayVectors.changeElem(vectorC, 1));
        System.out.println(arrayVectors.toString());
        //for (int i = 0; i < arrayVectors.length(); i++) {
        //    arrayVectors.getArray(i).toString();
        //}
        Point3D[] pointA = new Point3D[arrayVectors.length()];
        Point3D pointB = new Point3D(1, 2, 1);
        pointA = arrayVectors.movePoint(pointB);
        for (Point3D point : pointA) {
            System.out.println(point.toString());
        }
        Vector3D LineComb = arrayVectors.lineCombination(1, -1, 0);
        System.out.println(LineComb.toString());
        /*
        final int SIZE = 5;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array:");
        int[] arr = setArray(SIZE);
        System.out.println("enter [a,b]: ");
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        System.out.println("amount numbers include [a,b]  : " + amountNumbersIncludeAB(arr, a, b));
        System.out.println("sum elem array : " + sumElemArray(arr));
        System.out.println("amount chetn number of array : " + amountChetnNumbers(arr));
        System.out.println("numbers of arrays is positive  : " + posNumbers(arr));
        System.out.println("before reverse:");
        getArray(arr);
        System.out.println("after reverse:");
        reverseArray(arr);
        getArray(arr);

        /*System.out.println();
        lineEq(0,0,0,0,0,0);
        lineEq(0,0,4,0,0,2);
        lineEq(2,0,0,0,0,7);
        lineEq(0,4,0,0,0,0);
        lineEq(0,0,1,0,0,0);

        lineEq(2,4,0,0,0,1);
        lineEq(0,0,0,0,2,256);
        lineEq(6,0,1,0,0,0);
        lineEq(0,0,0,0,0,4);
        lineEq(0,0,0,9,0,-7);

        lineEq(1,0,0,2,0,0);
        lineEq(1,1,0,2,0,0);
        lineEq(1,0,1,4,0,0);
        lineEq(1,0,1,0,0,256);
        lineEq(1,1,0,0,0,256);
        lineEq(1,6,-5,-6,-8,0);
        lineEq(1,-2,2,2,-4,4);*/

        /*while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Choose task");
            System.out.println("1 - 6 begining");
            System.out.println("10 - 12 arrays");
            System.out.println("15 - 18 Class");
            int task = scan.nextInt();

            switch (task) {
                case 1: {
                    System.out.println("Hello, World!");
                    break;
                }
                case 2: {
                    double first = scan.nextDouble();
                    double second = scan.nextDouble();
                    double third = scan.nextDouble();
                    firstTask(new double[]{first, second, third});
                    System.out.println();
                    break;
                }
                case 3: {
                    double first = scan.nextDouble();
                    double second = scan.nextDouble();
                    double third = scan.nextDouble();
                    sqrEq(first, second, third);
                    System.out.println();
                    break;
                }
                case 4: {
                    double first = scan.nextDouble();
                    double second = scan.nextDouble();
                    double third = scan.nextDouble();
                    tabSin(first, second, third);
                    System.out.println();
                    break;
                }
                case 5: {
                    System.out.println("Enter X and P : ");
                    double x = scan.nextDouble();
                    double p = scan.nextDouble();

                    System.out.println(mineExp(x, p));
                    System.out.println();
                    break;
                }
                case 6: {
                    System.out.println("lineEx -  a1 x + b1 y = c1 && a2 x + b2 y = c2");
                    System.out.println("Enter numbers(a1 b1 c1):");
                    double a1 = scan.nextDouble();
                    double b1 = scan.nextDouble();
                    double c1 = scan.nextDouble();
                    System.out.println("Enter numbers(a2 b2 c2):");
                    double a2 = scan.nextDouble();
                    double b2 = scan.nextDouble();
                    double c2 = scan.nextDouble();
                    //double[] arr = new double [2];
                /*arr = */
                /*    lineEq(a1, b1, c1, a2, b2, c2);
                    //System.out.println("x = " + arr[0] + "  y = " + arr[1]);
                    break;
                }

                case 10: {
                    final int SIZE = 4;

                    System.out.println("Enter array:");
                    int[] arr = setArray(SIZE);
                    System.out.println("before reverse:");
                    getArray(arr);
                    System.out.println("after reverse:");
                    reverseArray(arr);
                    getArray(arr);
                    System.out.println("sum elem array : " + sumElemArray(arr));
                    System.out.println("amount chetn number of array : " + amountChetnNumbers(arr));
                    System.out.println("numbers of arrays is positive  : " + posNumbers(arr));
                }
                case 11: {
                    final int SIZE = 5;
                    double[] arr = new double[SIZE];
                    System.out.print("Enter array:");
                    setArray(arr, SIZE);
                    System.out.print("Enter otrezok [a, b] :");
                    double a = scan.nextDouble();
                    double b = scan.nextDouble();
                    System.out.println("amount numbers [a,b] : " + amountNumbersIncludeAB(arr, a, b));
                    getArray(arr);
                    break;
                }
                case 12: {
                    final int SIZE = 5;
                    double[] arr = new double[SIZE];
                    System.out.print("Enter array:");
                    setArray(arr, SIZE);
                    reverseArray(arr);
                    getArray(arr);
                    break;
                }

                case 15: {
                    Point3D pointA = new Point3D();
                    Point3D pointB = new Point3D(1, 2, 1);
                    Point3D pointC = new Point3D(1, 2, 1);
                    System.out.println("PointA == PointB ? " + pointA.equals(pointB));
                    System.out.println("PointB == PointC ? " + pointB.equals(pointC));
                    break;
                }
                case 16: {
                    Vector3D vectorA = new Vector3D(1, 2, -1);
                    Vector3D vectorB = new Vector3D(vectorA);
                    System.out.println("VectorA == VectorB ? " + vectorA.equals(vectorB));
                    break;
                }
                case 17: {
                    System.out.println("Vector3DProcessor");
                    Vector3D vectorA = new Vector3D(1, 2, -1);
                    Vector3D vectorB = new Vector3D(2, 4, -2);
                    Vector3D vectorC = new Vector3D();

                    vectorC = Vector3DProcessor.additionVectors(vectorA, vectorB);
                    System.out.println("A + B = " + vectorC.toString());
                    vectorC = new Vector3D();

                    vectorC = Vector3DProcessor.substructionVectors(vectorA, vectorB);
                    System.out.println("A - B = " + vectorC.toString());
                    vectorC = new Vector3D();

                    System.out.println("A * B = " + Vector3DProcessor.scalarMultiplicationVectors(vectorA, vectorB));

                    vectorC = Vector3DProcessor.vectorMultiplicationVectors(vectorA, vectorB);
                    System.out.println("|A x B| = " + vectorC.toString());

                    System.out.println(" A || B ?  - " + Vector3DProcessor.equals(vectorA, vectorB));
                    break;
                }
                case 18: {
                    System.out.println("Vector3DArray");
                    Vector3D vectorA = new Vector3D(1, 2, -1);
                    Vector3D vectorB = new Vector3D(2, 4, -2);
                    Vector3D vectorC = new Vector3D(1, 0, 0);

                    Vector3DArray arrayVectors = new Vector3DArray(vectorA, vectorB, vectorB);
                    System.out.println("максимальная длина векторов: " + arrayVectors.maxLengthOfVector3D());
                    System.out.println("первое вхождение вектора: " + arrayVectors.findFirstVector(2, 4, -2));
                    System.out.println("сумма векторов массива: " + arrayVectors.sumVectors());
                    System.out.println("заменяем вектор (0 - выполнено) " + arrayVectors.changeElem(vectorC, 1));
                    System.out.println(arrayVectors.toString());
                    //for (int i = 0; i < arrayVectors.length(); i++) {
                    //    arrayVectors.getArray(i).toString();
                    //}
                    Point3D[] pointA = new Point3D[arrayVectors.length()];
                    Point3D pointB = new Point3D(1, 2, 1);
                    pointA = arrayVectors.movePoint(pointB);
                    for (Point3D point : pointA) {
                        System.out.println(point.toString());
                    }
                    Vector3D LineComb = arrayVectors.lineCombination(1, -1, 0);
                    System.out.println(LineComb.toString());
                    break;
                }
                default: {
                    System.out.println("такого задания нет");
                    break;
                }
            }
        }*/

    }
}
