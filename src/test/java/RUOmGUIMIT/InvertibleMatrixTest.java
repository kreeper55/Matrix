package RUOmGUIMIT;

import RUOmGUIMIT.MyExceptions.BadSize;
import RUOmGUIMIT.MyExceptions.IndexOutOfRange;
import RUOmGUIMIT.MyExceptions.MatrixIsNotInvertibleMatrix;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class InvertibleMatrixTest {

    @DataProvider
    public static Object[][] invertible() throws BadSize {
        return new Object[][] {
                {new MyMatrix(3, 2,5,7,  6,3,4,  5,-2,-3)},
                {new MyMatrix(3, -5,5,8,  1,-4,-4,  -2,6,6)},
                {new MyMatrix(3, 1,2,3,  3,3,2,  1,4,1)},
                {new MyMatrix(2, 1,2, 3,4)},
                {new MyMatrix(2, 1,2, 2,3)},
                {new MyMatrix(4, 9,-3,-7,4,  -2,0,5,0,  -6,3,1,-8,  -1,9,-5,2)},
                {new MyMatrix(3, -1,7,-6,  4,9,-3,  -8,-2,-5)},
                {new MyMatrix(5, 4,4,5,3,4,  9,2,5,2,3,  0,6,2,4,8,  3,0,0,3,2,  9,2,0,1,6)}
        };
    }

    @DataProvider
    public static Object[][] invertibleExcept() throws BadSize, IndexOutOfRange, MatrixIsNotInvertibleMatrix {
        return new Object[][] {
                {new InvertibleMatrix(3, 1,2,3,4,5,6,7,8,9)},
                {new InvertibleMatrix(4, 1,4,0,5,7,-9,0,1,4,4,0,7,-8,1,0,1)}
        };
    }


    @Test(dataProvider = "invertible")
    public void invertibleTest(MyMatrix blossom) throws IndexOutOfRange, MatrixIsNotInvertibleMatrix, BadSize {
        InvertibleMatrix im = new InvertibleMatrix(blossom);
        assertTrue(blossom.multiply(im.getInvertibleMatrix()).isIdentity());
    }

    @Test(dataProvider = "invertibleExcept", expectedExceptions = MatrixIsNotInvertibleMatrix.class)
    public void invertibleFail(InvertibleMatrix im) throws MatrixIsNotInvertibleMatrix, IndexOutOfRange, BadSize {
        im.getInvertibleMatrix();
        fail();
    }
}