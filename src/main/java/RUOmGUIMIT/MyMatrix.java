package RUOmGUIMIT;

import RUOmGUIMIT.Interfaces.IMatrix;
import RUOmGUIMIT.MyExceptions.BadSize;
import RUOmGUIMIT.MyExceptions.IndexOutOfRange;

import java.util.Arrays;

public class MyMatrix implements IMatrix {
    protected int size;
    protected double[] arr;

    public MyMatrix(int n) throws BadSize, IndexOutOfRange {
        if (size < 0) throw new BadSize("bad size : size < 0");
        this.size = n;
        arr = new double [size * size];
        for (int i = 0; i < size * size; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < size; i++) {
            this.changeElement(i,i,1);
        }
    }

    public MyMatrix(int n, double... elements) throws BadSize {
        if (size < 0) throw new BadSize("bad size : size < 0");
        if (elements.length != n * n) throw new BadSize("length of elements isn't equalse a size");
        this.size = n;
        arr = new double [size * size];
        for (int i = 0; i < size * size; i++) {
            arr[i] = elements[i];
        }
    }

    public MyMatrix(MyMatrix matrix) {
        this.size = matrix.size;
        this.arr = new double[size * size];
        System.arraycopy(matrix.arr, 0, this.arr, 0, size * size);
    }


    public void changeElement(int i, int j, double element) throws IndexOutOfRange{
        if ((i >= size || j >= size )|| (i < 0 || j < 0)) throw new IndexOutOfRange("index out of range");
        arr[j + size * i] = element;
    }

    static public double determinantMinor(MyMatrix matrix) throws IndexOutOfRange, BadSize { //need fix
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
        return result + 0.0;
    }

    public double determinantGauss() throws IndexOutOfRange{
        MyMatrix matrix = new MyMatrix(this);
        double result = 1;

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
                            result *= -1;
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
            result *= matrix.getElement(i, i);
        }

        return result + 0.0;
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
                    if (Math.abs(getElement(i, j) - 0) > 1e-9) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public double getElement(int i, int j) throws IndexOutOfRange{
        if ((i >= size || j >= size )|| (i < 0 || j < 0)) throw new IndexOutOfRange("index out of range");
        return arr[j + size * i];
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyMatrix myMatrix = (MyMatrix) o;

        if (size != myMatrix.size) return false;
        return Arrays.equals(arr, myMatrix.arr);
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }
}
