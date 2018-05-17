package RUOmGUIMIT;

import RUOmGUIMIT.MyExceptions.BadSize;
import RUOmGUIMIT.MyExceptions.IndexOutOfRange;
import RUOmGUIMIT.MyExceptions.MatrixIsNotInvertibleMatrix;

public class App
{
    public static void main( String[] args ) throws BadSize, IndexOutOfRange, MatrixIsNotInvertibleMatrix {
/*
        InvertibleMatrix matrix = new InvertibleMatrix(3, 4,      5,      3,
                                                                        9,      24,     1.24,
                                                                        23.1,   0.35,   5       );
*/
        //MyMatrix m = new MyMatrix(3, 2,5,7,6,3,4,5,-2,-3);
        MyMatrix m = new MyMatrix(3, 0,2,6,  4,0,8,  7,2,4);
        InvertibleMatrix matrix = new InvertibleMatrix(3,1,2,3, 4,5,6, 7,8,9);

        System.out.println(matrix.determinantGauss());
        MyMatrix invert = new MyMatrix(matrix.getInvertibleMatrix());

        for (int row = 0; row < matrix.getSize(); row++) {
            for (int column = 0; column < matrix.getSize(); column++) {
                System.out.print(matrix.getElement(row, column) + "   ");;
            }
            System.out.println();
        }

        System.out.println();

        for (int row = 0; row < invert.getSize(); row++) {
            for (int column = 0; column < invert.getSize(); column++) {
                System.out.print(invert.getElement(row, column) + "   ");;
            }
            System.out.println();
        }


        System.out.println();
        System.out.println();
        //MyMatrix temp = new MyMatrix(invert.multiply(new MyMatrix(matrix.getSize())));

        MyMatrix temp = new MyMatrix(matrix.multiply(invert));

        System.out.println();
        System.out.println(temp.isIdentity());
        System.out.println();


        for (int row = 0; row < temp.getSize(); row++) {
            for (int column = 0; column < temp.getSize(); column++) {
                System.out.print(temp.getElement(row, column) + "   ");;
            }
            System.out.println();
        }

        //MyMatrix m = new MyMatrix(2, 4,5,3,9);
        //MyMatrix m = new MyMatrix(3, 1,2,3,4,5,6,7,8,9);
        //MyMatrix m = new MyMatrix(4, 0,1,-4,9,8,0,5,5,-2,11,0,-7,8,-9,1,0); ceil or floor around value
        //MyMatrix m = new MyMatrix(3, 2,0,4,6,0,8,10,0,12); // 0
        //MyMatrix m = new MyMatrix(5, 0,3,-1,2,6,2,1,0,0,3,-2,-1,0,2,5,-5,7,1,1,1,2,0,2,-2,1);  //50},
        //MyMatrix m = new MyMatrix(3, 2,-1,4,1,0.7,-5,0,3,0);  //, 42},
        /*for (int row = 0; row < m.getSize(); row++) {
            for (int column = 0; column < m.getSize(); column++) {
                System.out.print(m.getElement(row, column) + "   ");;
            }
            System.out.println();
        }*/
        //System.out.println(MyMatrix.determinantMinor(m));
        /*
        * 0   3  -1  2  6
        * 2   1  0   0  3
        * -2 -1  0   2  5
        * -5  7  1   1  1
        * 2   0  2  -2  1 */
        /*System.out.println(m.determinantMinor(m));
        System.out.println();
        for (int row = 0; row < m.getSize(); row++) {
            for (int column = 0; column < m.getSize(); column++) {
                System.out.print(m.getElement(row, column) + "   ");;
            }
            System.out.println();
        }*/

    }
}
