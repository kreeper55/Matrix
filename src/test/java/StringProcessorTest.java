import Strings.NegativeMeaning;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Strings.StringProcessor.*;
import static org.testng.Assert.*;

public class StringProcessorTest {
    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {"N", 3, "NNN"},
                {"qwe", 3, "qweqweqwe"},
                {"", 3, ""},
                {"", 0, ""}
        };
    }

    @DataProvider
    public static Object[][] countData() {
        return new Object[][]{
                {"a", "a", 1},
                {"aa", "a", 2},
                {"aaa", "aa", 2},
                {"", "aaa", -1},
                //                {"", "", 0}
                {"asdf", "", -1},
                {"aaaa", "vvv", 0},
                {"aeqra facwda", "a", 4}
        };
    }

    @DataProvider
    public static Object[][] onetwothreeData() {
        return new Object[][]{
                {"", ""},
                {"567890", "567890"},
                {"  1 ", "  один "},
                {" 2", " два"},
                {"1 2 3", "один два три"}
        };
    }

    @DataProvider
    public static Object[][] changeWords() {
        return new Object[][]{
                {"", ""},
                {"_qq_", "_qq_"},
                {"___123_erty_11_", "___11_erty_123_"},
                {"__firstword__sdh_gd____fh___", "__fh__sdh_gd____firstword___"},
                {"___fh__sdh_gd____firstword__", "___firstword__sdh_gd____fh__"},
                {"__oneWord__", "__oneWord__"},
                {"__oneWord___", "__oneWord___"},
                {"___oneWord__", "___oneWord__"}
        };
    }

    @DataProvider
    public static Object[][] changeAge() {
        return new Object[][]{
                {"Васе 0x00000010 лет", "Васе 16 лет"},
                {"Васе 0x00000010 лет, Андрею 0x00000011 лет", "Васе 16 лет, Андрею 17 лет"},
                {"Васе 16 лет", "Васе 16 лет"}
        };
    }

    @Test(dataProvider = "data")
    public void testCopy(String str, int N, String expected) throws NegativeMeaning {
        assertEquals(multiplyStr(str, N), expected);
    }

    @Test(expectedExceptions = {NegativeMeaning.class})
    public void testCopyExc() throws NegativeMeaning {
        multiplyStr("qwe", -6);
        fail();
    }

    @Test(dataProvider = "countData")
    public void testFindSub (String mainString, String subString, int expected) {
        assertEquals(numberOfOccurrences(mainString, subString), expected);
    }

    @Test(dataProvider = "onetwothreeData")
    public void testChange(String source, String expected) {
        assertEquals(characterReplacement(source), expected);
    }

    @Test
    public void testChange2() {
        StringBuilder  stringBuffer = new StringBuilder("1234567");
        StringBuilder temp = deleteEvenSymbols(stringBuffer);
        assertEquals(temp.toString(), "1357");
        temp = deleteEvenSymbols(stringBuffer);
        assertEquals(temp.toString(), "15");
        temp = deleteEvenSymbols(stringBuffer);
        assertEquals(temp.toString(), "1");
        temp = deleteEvenSymbols(stringBuffer);
        assertEquals(temp.toString(), "1");
    }

    @Test(dataProvider = "changeWords")
    public void testChange3(String source, String expected) {
        StringBuilder s_buffer = new StringBuilder(source.subSequence(0, source.length()));
        System.out.println(s_buffer);
        assertEquals(replaceWords(s_buffer).toString(), expected);
    }

    @Test(dataProvider = "changeAge")
    public void testChange4(String source, String expected) {
        assertEquals(hexadecimal(source), expected);
    }

}