package Strings;

import javax.naming.ldap.StartTlsRequest;

public class StringProcessor {
    public static String multiplyStr(String str, int n) throws NegativeMeaning{
        if (n == 0) {
            return "";
        } else if (n < 0) {
            throw new NegativeMeaning();
        } else {
            String answer = "";
            for (int i = 0; i < n; i++) {
                answer  += str;
            }
            return answer;
        }
    }

    public static int numberOfOccurrences (String mainstring, String substring) {
        if (mainstring == "" || substring == "") {
            return -1;
        }
        int currentIndex = 0;
        int count = 0;
        for (int i = 0; i < mainstring.length(); i++) {
            currentIndex = mainstring.indexOf(substring, currentIndex);
            if (currentIndex == -1) {
                return count;
            } else {
                count++;
                currentIndex += 1;
            }
        }
        return count;
    }

    public static String characterReplacement (String str) {
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                temp += "один";
            } else if (str.charAt(i) == '2') {
                temp += "два";
            } else if (str.charAt(i) == '3') {
                temp += "три";
            } else {
                temp += str.charAt(i);
            }
        }
        return temp;
    }

    public static StringBuilder deleteEvenSymbols (StringBuilder string) {
        for (int i = 1; i < string.length(); i++) {
            string.deleteCharAt(i);
        }
        return string;
    }

    public static StringBuilder replaceWords (StringBuilder string) {
        if (string.length() == 0) return new StringBuilder();
        StringBuilder firstWord = new StringBuilder();
        StringBuilder secondWord = new StringBuilder();
        int k = 0, indexForFirst = 0, indexForSecond = 0;
        boolean flag = false;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != '_') {
                flag = true;
                //firstWord.setCharAt(k, string.charAt(i));
                firstWord.append(string.charAt(i));
                //k++;
            } else {
                if (flag) {
                    indexForFirst = i;
                    break;
                }
            }
        }
        k = string.length() - 1;
        flag = false;
        for (int i = string.length() - 1; i >= 0 ; i--) {
            if (string.charAt(i) != '_') {
                flag = true;
                //secondWord.setCharAt(k, string.charAt(i));
                secondWord.append(string.charAt(i));
                //k--;
            } else {
                if (flag) {
                    indexForSecond = i + 1;
                    break;
                }
            }
        }
        secondWord.reverse();
        string = string.replace(indexForSecond, indexForSecond + secondWord.length(), firstWord.toString());
        string = string.replace(indexForFirst - firstWord.length(), indexForFirst, secondWord.toString());
        return string;
    }

    public static String hexadecimal (String string) {
        if (string.length() == 0) return new String();
        string = string.toUpperCase();

        /*int begIndex = string.indexOf("0x"), endIndex = begIndex + 10;
        StringBuilder answer = new StringBuilder();
        answer = String.valueOf(string.substring(begIndex, endIndex));
        int decimal = 0;
        for (int i = 0; i < hexadecimal.length(); i++) {
            if (((char)hexadecimal.charAt(i) > 57 && (char)hexadecimal.charAt(i) < 48) || ((char)hexadecimal.charAt(i) > 70 && (char)hexadecimal.charAt(i) < 65)) {
                return new String();
            }
        }*/
        return new String();
    }
    /*
    * Строка содержит подстроки вида 0xNNNNNNNN, где N — шестнадцатеричная цифра.
    * Постройте новую строку, в которой шестнадцатеричные числа будут заменены на десятичные эквиваленты
    * (например, строка «Васе 0x00000010 лет» должна превратиться в строку «Васе 16 лет»).
     */
}
