package RUOmGUIMIT;

import RUOmGUIMIT.Interfaces.IInvertibleMatrix;
import RUOmGUIMIT.MyExceptions.BadSize;
import RUOmGUIMIT.MyExceptions.IndexOutOfRange;
import RUOmGUIMIT.MyExceptions.MatrixIsNotInvertibleMatrix;

public class InvertibleMatrix extends MyMatrix implements IInvertibleMatrix {
    private double det;

    public InvertibleMatrix(int size) throws BadSize, IndexOutOfRange, MatrixIsNotInvertibleMatrix {
        super(size);
        det = this.determinantGauss();
        if (det == 0) throw new MatrixIsNotInvertibleMatrix("Matrix Is Not Invertible Matrix");
    }

    public InvertibleMatrix(int n, double... elements) throws BadSize, IndexOutOfRange, MatrixIsNotInvertibleMatrix {
        super(n, elements);
        det = this.determinantGauss();
        if (det == 0) throw new MatrixIsNotInvertibleMatrix("Matrix Is Not Invertible Matrix");
    }

    public InvertibleMatrix(MyMatrix matrix) throws IndexOutOfRange, MatrixIsNotInvertibleMatrix {
        super(matrix);
        det = this.determinantGauss();
        if (det == 0) throw new MatrixIsNotInvertibleMatrix("Matrix Is Not Invertible Matrix");
    }

    public int getSize() {
        return super.getSize();
    }

    public double determinant() {
        return det;
    }

    public double getElement(int i, int j) throws IndexOutOfRange {
        return super.getElement(i, j);
    }

    public void changeElement(int i, int j, double element) throws IndexOutOfRange {
        super.changeElement(i, j, element);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public MyMatrix getInvertibleMatrix() throws IndexOutOfRange, BadSize {
        if (this.size == 1) return this;
        MyMatrix invertMatrix = new MyMatrix(this.getSize());
        MyMatrix tempMatrix = new MyMatrix(this);

        for (int j = 0; j < tempMatrix.getSize() - 1; j++) {
            for (int row = j + 1; row < tempMatrix.getSize(); row++) {

                if (tempMatrix.getElement(j, j) == 0) {
                    for (int f = row; f < size; f++) {
                        if (tempMatrix.getElement(f, j) != 0) {
                            for (int column = 0; column < size; column++) {
                                tempMatrix.changeElement(j, column, (tempMatrix.getElement(j, column) - tempMatrix.getElement(f, column)));
                                tempMatrix.changeElement(f, column, (tempMatrix.getElement(j, column) + tempMatrix.getElement(f, column)));
                                tempMatrix.changeElement(j, column, (tempMatrix.getElement(f, column) - tempMatrix.getElement(j, column)));

                                invertMatrix.changeElement(j, column, (invertMatrix.getElement(j, column) - invertMatrix.getElement(f, column)));
                                invertMatrix.changeElement(f, column, (invertMatrix.getElement(j, column) + invertMatrix.getElement(f, column)));
                                invertMatrix.changeElement(j, column, (invertMatrix.getElement(f, column) - invertMatrix.getElement(j, column)));
                            }
                            break;
                        }
                    }
                }

                double coefficient = tempMatrix.getElement(row, j) / (-1 * tempMatrix.getElement(j, j));
                for (int column = 0; column < tempMatrix.getSize(); column++) {
                    tempMatrix.changeElement(row, column,tempMatrix.getElement(j, column) * coefficient + tempMatrix.getElement(row,column));
                    invertMatrix.changeElement(row, column,invertMatrix.getElement(j, column) * coefficient + invertMatrix.getElement(row,column));
                }
            }
        }

        for (int j = tempMatrix.getSize() - 1; j > 0; j--) {
            for (int row = j - 1; row >= 0; row--) {

                if (tempMatrix.getElement(j, j) == 0) {
                    for (int f = row; f < size; f++) {
                        if (tempMatrix.getElement(f, j) != 0) {
                            for (int column = 0; column < size; column++) {
                                tempMatrix.changeElement(j, column, (tempMatrix.getElement(j, column) - tempMatrix.getElement(f, column)));
                                tempMatrix.changeElement(f, column, (tempMatrix.getElement(j, column) + tempMatrix.getElement(f, column)));
                                tempMatrix.changeElement(j, column, (tempMatrix.getElement(f, column) - tempMatrix.getElement(j, column)));

                                invertMatrix.changeElement(j, column, (invertMatrix.getElement(j, column) - invertMatrix.getElement(f, column)));
                                invertMatrix.changeElement(f, column, (invertMatrix.getElement(j, column) + invertMatrix.getElement(f, column)));
                                invertMatrix.changeElement(j, column, (invertMatrix.getElement(f, column) - invertMatrix.getElement(j, column)));
                            }
                            break;
                        }
                    }
                }

                double coefficient = tempMatrix.getElement(row, j) / (-1 * tempMatrix.getElement(j, j));
                for (int column = 0; column < tempMatrix.getSize(); column++) {
                    tempMatrix.changeElement(row, column,tempMatrix.getElement(j, column) * coefficient + tempMatrix.getElement(row,column));
                    invertMatrix.changeElement(row, column,invertMatrix.getElement(j, column) * coefficient + invertMatrix.getElement(row,column));
                }
            }
        }

        for (int row = 0; row < tempMatrix.getSize(); row++) {
            double coefficient = (1 / tempMatrix.getElement(row, row));
            for (int column = 0; column < tempMatrix.getSize(); column++) {
                tempMatrix.changeElement(row, column, tempMatrix.getElement(row, column) * coefficient);
                invertMatrix.changeElement(row, column, invertMatrix.getElement(row, column) * coefficient);
            }
        }

        return invertMatrix;
    }
}