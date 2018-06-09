package matrix;

import matrix.Interfaces.IMatrix;
import matrix.MyExceptions.BadSize;
import matrix.MyExceptions.IndexOutOfRange;

import java.io.Serializable;
import java.util.Arrays;

public class MyMatrix implements IMatrix, Serializable {
    protected int size;
    protected double[] arr;
    protected boolean isDetActual;
    protected double determinant;

    public MyMatrix(int n) throws BadSize, IndexOutOfRange {
        if (size < 0) throw new BadSize("bad size : size < 0");
        size = n;
        isDetActual = false;
        determinant = 0;
        arr = new double [size * size];

        for (int i = 0; i < size * size; i++) {
            arr[i] = 0;
        }
    }

    public MyMatrix(int n, double... elements) throws BadSize {
        if (size < 0) throw new BadSize("bad size : size < 0");
        if (elements.length != n * n) throw new BadSize("length of elements isn't equalse a size");
        size = n;
        isDetActual = false;
        determinant = 0;
        arr = new double [size * size];
        for (int i = 0; i < size * size; i++) {
            arr[i] = elements[i];
        }
    }

    public MyMatrix(MyMatrix matrix) {
        this.size = matrix.size;
        this.isDetActual = matrix.isDetActual;
        this.determinant = matrix.determinant;
        this.arr = new double[size * size];
        System.arraycopy(matrix.arr, 0, this.arr, 0, size * size);
    }

    public static  double determinantMinor(MyMatrix matrix) throws IndexOutOfRange, BadSize { //need fix
        if (matrix.getSize() == 2) return matrix.getElement(0,0) * matrix.getElement(1,1) -  matrix.getElement(0,1) * matrix.getElement(1,0);
        if (matrix.getSize() == 1) return matrix.getElement(0,0);
        if (matrix.getSize() == 0) return 0;
        double result = 0;
        for (int column = 0; column < matrix.getSize(); column++) {
            if (matrix.getElement(0, column) == 0) {
                continue;
            }
            MyMatrix temp = new MyMatrix(matrix.getSize() - 1);
            for (int i = 1; i < matrix.getSize(); i++) {
                int k = 0;
                for (int j = 0; j < matrix.getSize(); j++) {
                    if (j == column) continue;
                    temp.changeElement(i - 1, k, matrix.getElement(i, j));
                    k++;
                }
            }
            if (column % 2 == 0) {
                result += matrix.getElement(0, column) * MyMatrix.determinantMinor(temp);
            } else {
                result += -1 * matrix.getElement(0, column) * MyMatrix.determinantMinor(temp);
            }
        }
        //flag = true;
        return result + 0.0;
    }

    public double determinantGauss() throws IndexOutOfRange{
        if (isDetActual) return determinant;
        MyMatrix matrix = new MyMatrix(this);
        determinant = 1;

        for (int j = 0; j < size - 1; j++) {
            for (int row = 1 + j; row < size; row++) {
                if (matrix.getElement(row, j) == 0) {
                    continue;
                }
                if (matrix.getElement(j, j) == 0) {
                    for (int f = row; f < size; f++) {
                        if (matrix.getElement(f, j) != 0) {
                            //double temp = 0;
                            for (int column = 0; column < size; column++) {
                                matrix.changeElement(j, column, (matrix.getElement(j, column) - matrix.getElement(f, column)));
                                matrix.changeElement(f, column, (matrix.getElement(j, column) + matrix.getElement(f, column)));
                                matrix.changeElement(j, column, (matrix.getElement(f, column) - matrix.getElement(j, column)));
                                /*temp = matrix.getElement(j, column);
                                matrix.changeElement(j,column, matrix.getElement(f, column));
                                matrix.changeElement(f, column, temp);*/
                            }
                            determinant *= -1;
                            break;
                        }
                    }
                }

                double coefficient = (-1 * matrix.getElement(row, j)) / (matrix.getElement(j, j)) + 0.0;
                for (int column = 0; column < size; column++) {
                    matrix.changeElement(row, column, matrix.getElement(j, column) * coefficient + matrix.getElement(row, column));
                }
            }
        }

        for (int i = 0; i < size; i++) {
            determinant *= matrix.getElement(i, i);
        }
        isDetActual = true;
        return determinant + 0.0;
    }

    public MyMatrix multiply(IMatrix obj) throws BadSize, IndexOutOfRange {
        if (obj.getSize() != size) throw new BadSize("size of matrix isn't equals");
        MyMatrix result = new MyMatrix(size);
        double temp = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temp = 0;
                for (int k = 0; k < size; k++) {
                    temp += getElement(i, k) * obj.getElement(k, j);
                }
                result.changeElement(i, j, temp);
            }
        }
        return result;
    }

    public boolean isIdentity() throws IndexOutOfRange {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    if (Math.abs(getElement(i, j) - 1) > 1e-9) {
                        return false;
                    }
                } else {
                    if (Math.abs(getElement(i, j)) > 1e-9) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void changeElement(int i, int j, double element) throws IndexOutOfRange{
        if ((i >= size || j >= size )|| (i < 0 || j < 0)) throw new IndexOutOfRange("index out of range");
        arr[j + size * i] = element;
        isDetActual = false;
    }

    public double getElement(int i, int j) throws IndexOutOfRange{
        if ((i >= size || j >= size )|| (i < 0 || j < 0)) throw new IndexOutOfRange("index out of range");
        return arr[j + size * i];
    }

    public double getDeterminant() throws IndexOutOfRange {
        if (isDetActual)
            return determinant;
        else
            return this.determinantGauss();
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyMatrix matrix = (MyMatrix) o;

        if (size != matrix.size) return false;
        if (isDetActual != matrix.isDetActual) return false;
        if (Double.compare(matrix.determinant, determinant) != 0) return false;
        return Arrays.equals(arr, matrix.arr);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = size;
        result = 31 * result + Arrays.hashCode(arr);
        result = 31 * result + (isDetActual ? 1 : 0);
        temp = Double.doubleToLongBits(determinant);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "MyMatrix{" +
                "size=" + size +
                ", arr=" + Arrays.toString(arr) +
                ", isDetActual=" + isDetActual +
                ", determinant=" + determinant +
                '}';
    }
}
