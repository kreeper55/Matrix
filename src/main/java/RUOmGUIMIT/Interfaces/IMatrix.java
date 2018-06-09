package RUOmGUIMIT.Interfaces;

import RUOmGUIMIT.MyExceptions.IndexOutOfRange;

public interface IMatrix {
    double getElement(int i, int j) throws IndexOutOfRange;
    void changeElement(int i, int j, double element) throws IndexOutOfRange;
    double determinantGauss() throws IndexOutOfRange;
    int getSize();
    //double determinantMinor(MyMatrix matrix) throws IndexOutOfRange, BadSize;
}
