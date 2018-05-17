package RUOmGUIMIT.Interfaces;

import RUOmGUIMIT.MyExceptions.BadSize;
import RUOmGUIMIT.MyExceptions.IndexOutOfRange;
import RUOmGUIMIT.MyMatrix;

public interface IInvertibleMatrix extends IMatrix {
    MyMatrix getInvertibleMatrix() throws IndexOutOfRange, BadSize;
}
