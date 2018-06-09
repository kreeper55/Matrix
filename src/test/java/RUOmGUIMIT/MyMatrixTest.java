package RUOmGUIMIT;

import RUOmGUIMIT.MyExceptions.BadSize;
import RUOmGUIMIT.MyExceptions.IndexOutOfRange;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MyMatrixTest {
    @DataProvider
    public static Object[][] determinant() throws BadSize {
        return new Object[][] {
                {new MyMatrix(3, 1,2,3,4,5,6,7,8,9), 0},
                {new MyMatrix(3, 1,-2,3,4,0,6,-7,8,9), 204},
                {new MyMatrix(2, 11,-3,-15,-2), -67},
                {new MyMatrix(4, 0,1,-4,9,8,0,5,5,-2,11,0,-7,8,-9,1,0), 6008},
                {new MyMatrix(3, 2,0,4,6,0,8,10,0,12), 0},
                {new MyMatrix(5, 0,3,-1,2,6,2,1,0,0,3,-2,-1,0,2,5,-5,7,1,1,1,2,0,2,-2,1), 50},
                {new MyMatrix(3, 2,-1,4,1,0.7,-5,0,3,0), 42},
                {new MyMatrix(5, 1,2,4,3,5,5,3,2,1,1,1,3,2,1,4,4,2,2,1,1,1,1,3,2,2), 11},
                {new MyMatrix(1, 5), 5}
        };
    }


    @Test(dataProvider = "determinant")
    public void computeTest(MyMatrix m, double det) throws IndexOutOfRange, BadSize {
        assertTrue(Math.abs(m.determinantGauss() - det) <= 1e-9);
        assertEquals(MyMatrix.determinantMinor(m), det);
        //assertEquals(m.determinantGauss(), det);
    }
}

