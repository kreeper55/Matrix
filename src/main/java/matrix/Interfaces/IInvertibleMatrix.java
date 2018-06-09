package matrix.Interfaces;

import matrix.MyExceptions.BadSize;
import matrix.MyExceptions.IndexOutOfRange;
import matrix.MyExceptions.MatrixIsNotInvertibleMatrix;
import matrix.MyMatrix;

public interface IInvertibleMatrix extends IMatrix {
    IInvertibleMatrix getInvertibleMatrix() throws IndexOutOfRange, BadSize, MatrixIsNotInvertibleMatrix;
}
