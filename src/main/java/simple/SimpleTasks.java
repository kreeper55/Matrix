package simple;

import java.util.Arrays;

import static java.lang.System.exit;

public class SimpleTasks {
    public static double max (double[] args)
    {
        Arrays.sort(args);
        return args[args.length - 1];
    }

    public static void firstTask (double[] args)
    {
        Arrays.sort(args);

        for (double d : args) {
            System.out.print(d + "  ");
        }
        System.out.println();

        double p = 1;
        for (double arg : args) {
            p *= arg;
        }
        System.out.println("mult " + p );

        p = 0;
        for (double arg : args) {
            p += arg;
        }
        System.out.println("average " + p / args.length);
    }

    public static void firstTaskInt (int[] args)
    {
        double p = 1;
        Arrays.sort(args);

        for (double d : args) {
            System.out.print(d + "  ");
        }
        //System.out.println();


        for (int arg : args) {
            p *= arg;
        }
        System.out.println(p);

        p = 0;
        for (int arg : args) {
            p += arg;
        }
        System.out.println( p / args.length);
    }

    public static void sqrEq (double a, double b, double c) throws NotSquareEqException, NoRealRootsException {
        if (a == 0.0) {
            throw new NotSquareEqException();
        }
        double discr = b * b - 4 * a * c;
        if (discr > 0) {
            System.out.println((-b + Math.sqrt(discr)) / (2 * a));
            System.out.println((-b - Math.sqrt(discr)) / (2 * a));
        } else if (discr == 0) {
            System.out.println( (-b) / (2 * a));
        } else {
            throw new NoRealRootsException();
        }
    }

    public static void tabSin (double a, double b, double step)
    {
        double temp;
        if (step == 0) {
            System.out.println("step == 0");
            return;
        }
        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        }
        if (step < 0) {
            step = Math.abs(step);
        }

        for (double i = a; i < b; i = i + step) {
            System.out.println("pri x = " + i + " " +  Math.sin(i));
        }
    }

    public static void lineEq (double a1, double b1, double c1, double a2, double b2, double c2)
    {
        if ((a1 == 0 && b1 == 0) && (a2 == 0 && b2 == 0) && (c1 != 0 || c2 != 0)) {
            System.out.println("коэффициенты при х1, y1 и х2, y2 равны 0 и есть хотя бы одна константа != 0 => система не имеет решения");
            return;
        }
        Double detx1 = 0.0;
        Double detx2 = 0.0;
        Double det = 0.0;
        det = a1 * b2 - a2 * b1;
        if (det == 0) {
            detx1 = (c1 * b2 - c2 * b1);
            detx2 = (a1 * c2 - a2 * c1);
            if (detx1 != 0 || detx2 != 0) {
                System.out.println("Определители при неизвестных не равны нулю, следовательно, система несовместна, то есть не имеет решений.");
                return;
            } else {
                System.out.println("Система линейных уравнений имеет бесчисленное множество решений");
                return;
            }
        } else {
            detx1 = (c1 * b2 - c2 * b1) / det;
            detx2 = (a1 * c2 - a2 * c1) / det;
            System.out.println("x1 = " + detx1 + "  x1 = " + detx2);
        }
        /* x = 0.0;
        Double y = 0.0;
        if ((a1 == 0 && b1 == 0) || (a2 == 0 && b2 == 0)) {
            if ((a1 == 0 && b1 == 0) && (a2 != 0 && b2 != 0)) {
                y = (c2 - a2) / b2;
                System.out.println("x - любое, y = " + y);
            } else if ((a1 != 0 && b1 != 0) && (a2 == 0 && b2 == 0)) {
                x = (c1 - b1) / a1;
                System.out.println("x = " + x + " y - любое");
            }
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
        }*/
    }

    public static double mineExp(double x, double p)
    {
        if (p == 0) {
            p = 1.0e-10;
        }
        if (p < 0) {
            p = Math.abs(p);
        }
        double exp = 1, temp = 1,  n = 0;
        while(Math.abs(temp) >= p)
        {
            temp *= x/(++n);
            exp += temp;
        }
        return exp;
    }

}
