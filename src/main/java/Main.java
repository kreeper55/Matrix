import javax.naming.NameNotFoundException;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Created by student on 04.09.2017.
 */

public class Main {
    //Begining

    public static double max (double[] args)
    {
        Arrays.sort(args);
        return args[args.length - 1];
    }

    public static void firstTask (double[] args)
    {
        double p = 1;
        Arrays.sort(args);

        for (double d : args) {
            System.out.print(d + "  ");
        }

        for (int i = 0; i < args.length; i++) {
            p *= args[i];
        }
        System.out.println('\n' + p);

        p = 0;
        for (int i = 0; i < args.length; i++) {
            p += args[i];
        }
        System.out.println('\n' + p / args.length);
    }

    public static void sqrEq (double a, double b, double c)
    {
        double discr = b * b - 4 * a * c;
        if (discr > 0) {
            System.out.println((-b + Math.sqrt(discr)) / 2 * a);
            System.out.println((-b - Math.sqrt(discr)) / 2 * a);
        } else if (discr == 0) {
            System.out.println((-b) / 2 * a);
        } else {
            System.out.println("SORRE TUT COMPLEKSNIE");
        }
    }

    public static void tabSin (double a, double b, double step)
    {
        for (double i = a; i < b; i = i + step) {
            System.out.println("pri x = " + i + " " +  Math.sin(i));
        }
    }

    public static void lineEq (double a1, double b1, double c1, double a2, double b2, double c2)
    {
        Double x = 0.0;
        Double y = 0.0;
        if ((a1 == 0 && b1 == 0) || (a2 == 0 && b2 == 0)) {
            System.out.println("Решений нет, коэф. ур-я = 0");
        } else if ((a1 == b1) && (a2 == b2) && (c1 != c2)) {
            System.out.println("Решений нет(прямые параллельны)");
        } else if (a1 != 0){
            while (a1 != 0 && a2 != 0) {
                if (a1 > a2) {
                    a1 = a1 - a2;
                    b1 = b1 - b2;
                    c1 = c1 - c2;
                } else {
                    a2 = a2 - a1;
                    b2 = b2 - b1;
                    c2 = c2 - c1;
                }
            }
            if (a1 == 0 && b1 == 0 && c1 == 0) {
                c2 /= c2;
                System.out.println("x = " + c2 + " - y" + "  y - любое");
            } else if (a2 == 0 && b2 == 0 && c2 == 0) {
                c1 /= c1;
                System.out.println("x = " + c1 + " - y" + "  y - любое");
            } else if (a1 == 0) {
                y = c1 / b1;
                x = (c2 - b2 * y) / a2;
                System.out.println("x = " + x + "  y = " + y);
            } else {
                y = c2 / b2;
                x = (c1 - b1 * y) / a1;
                System.out.println("x = " + x + "  y = " + y);
            }
        } else {
            while (b1 != 0 &&  b2 != 0) {
                if (b1 > b2) {
                    a1 = a1 - a2;
                    b1 = b1 - b2;
                    c1 = c1 - c2;
                } else {
                    a2 = a2 - a1;
                    b2 = b2 - b1;
                    c2 = c2 - c1;
                }
            }
            if (a1 == 0 && b1 == 0 && c1 == 0) {
                c2 /= c2;
                System.out.println("x - любое " + "  y = " + c2 + " - y");
            } else if (a2 == 0 && b2 == 0 && c2 == 0) {
                c1 /= c1;
                System.out.println("x - любое " + "  y = " + c1 + " - y");
            } else if (b1 == 0) {
                x = c1 / a1;
                y = (c2 - a2 * x) / b2;
                System.out.println("x = " + x + "  y = " + y);
            } else {
                x = c2 / a2;
                y = (c1 - a1 * x) / b1;
                System.out.println("x = " + x + "  y = " + y);
            }
        }
        //double[] arr = {x,y};
        //return arr;
    }

    public static double mineExp(double x, final double p)
    {
        double exp = 1, temp = 0,  n = 1, fact = 1;
        do
        {
            temp = Math.pow(x, n) / fact;
            exp += temp;
            n++;
            fact *= n;
        } while (temp > p);
        return exp;
    }

//======================================================================================================================
    // Arrays

    public static void getArray(double[] arr) {
        for (double temp : arr) {
            System.out.print(temp + "  ");
        }
    }

    public static void setArray(double[] arr, final int SIZE) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextDouble();
        }
    }

    public static double sumElemArray(double[] arr) {
        double temp = 0;
        for (double i : arr) {
            temp += i;
        }
        return temp / arr.length;
    }

    public static int amountChetnNumbers(double[] arr) {
        int amount = 0;
        for (double i : arr) {
            if (i % 2 == 0) {
                amount++;
            }
        }
        return amount;
    }

    public static int amountNumbersIncludeAB(double[] arr, double a, double b) {
        int amount = 0;
        double temp = 0;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        for (double i : arr) {
            if (i >= a && i <= b) {
                amount++;
            }
        }
        return amount;
    }

    public static boolean posNumbers(double[] arr) {
        for (double i : arr) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }

    public static void reverseArray(double[] arr) {
        double temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    public static void main(String[] arg)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Choose task");
        System.out.print("1 - 6 begining");
        System.out.print("10 - 12 arrays");
        System.out.print("15 - 18 Class");
        int task = scan.nextInt();

        switch (task)
        {
            case 1:
            {
                System.out.println("Hello, World!");
                break;
            }
            case 2:
            {
                double first = scan.nextDouble();
                double second = scan.nextDouble();
                double third = scan.nextDouble();
                firstTask(new double[]{first, second, third});
                System.out.println();
                break;
            }
            case 3:
            {
                double first = scan.nextDouble();
                double second = scan.nextDouble();
                double third = scan.nextDouble();
                sqrEq (first, second, third);
                System.out.println();
                break;
            }
            case 4:
            {
                double first = scan.nextDouble();
                double second = scan.nextDouble();
                double third = scan.nextDouble();
                tabSin (first, second, third);
                System.out.println();
                break;
            }
            case 5:
            {
                System.out.println("Enter X and P : ");
                double x = scan.nextDouble();
                double p = scan.nextDouble();

                System.out.println(mineExp(x, p));
                System.out.println();
                break;
            }
            case 6:
            {
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
                lineEq(a1, b1, c1, a2, b2, c2);
                //System.out.println("x = " + arr[0] + "  y = " + arr[1]);
                break;
            }

            case 10:
            {
                final int SIZE = 5;
                double[] arr = new double [SIZE];
                System.out.print("Enter array:");
                setArray(arr, SIZE);
                System.out.println("sum elem array : " + sumElemArray(arr));
                System.out.println("amount chetn number of array : " + amountChetnNumbers(arr));
                System.out.println("numbers of arrays is positive  : " + posNumbers(arr));
                getArray(arr);
                break;
            }
            case 11:
            {
                final int SIZE = 5;
                double[] arr = new double [SIZE];
                System.out.print("Enter array:");
                setArray(arr, SIZE);
                System.out.print("Enter otrezok [a, b] :");
                double a = scan.nextDouble();
                double b = scan.nextDouble();
                System.out.println("amount numbers [a,b] : " + amountNumbersIncludeAB(arr, a, b));
                getArray(arr);
                break;
            }
            case 12:
            {
                final int SIZE = 5;
                double[] arr = new double [SIZE];
                System.out.print("Enter array:");
                setArray(arr, SIZE);
                reverseArray(arr);
                getArray(arr);
                break;
            }

            case 15:
            {
                Point3D pointA = new Point3D();
                Point3D pointB = new Point3D(1,2,1);
                Point3D pointC = new Point3D(1,2,1);
                System.out.println("PointA == PointB ? " + pointA.equals(pointB));
                System.out.println("PointB == PointC ? " + pointB.equals(pointC));
                break;
            }
            case 16:
            {
                Vector3D vectorA = new Vector3D(1,2,-1);
                Vector3D vectorB = new Vector3D(vectorA);
                System.out.println("VectorA == VectorB ? " + vectorA.equals(vectorB));
                break;
            }
            case 17:
            {
                System.out.println("Vector3DProcessor");
                Vector3D vectorA = new Vector3D(1,2,-1);
                Vector3D vectorB = new Vector3D(2,4,-2);
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
            default:
            {
                System.out.println("SORRY, NOT PRAVIL'NOE ZNACHENIE");
                break;
            }
        }
    }
}
