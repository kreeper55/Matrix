package RUOmGUIMIT;

import RUOmGUIMIT.MyExceptions.BadSize;
import RUOmGUIMIT.MyExceptions.IndexOutOfRange;
import RUOmGUIMIT.MyExceptions.NotSizeOfMatrixInFileException;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class DemoMatrix {
    public static void writeMatrix(String filename, MyMatrix matrix) throws IndexOutOfRange, IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) {
            writer.write(matrix.getSize() + "\r\n");
            for (int i = 0; i < matrix.getSize(); i++) {
                for (int j = 0; j < matrix.getSize(); j++) {
                    writer.write(matrix.getElement(i,j) + " ");
                }
                writer.write("\r\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MyMatrix readMatrix(String filename) throws IOException, IndexOutOfRange, BadSize, NotSizeOfMatrixInFileException {
        MyMatrix matrix;
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            scanner.useLocale(Locale.ENGLISH);
            if (!scanner.hasNextInt()) {
                throw new NotSizeOfMatrixInFileException();
            }
            matrix = new MyMatrix(scanner.nextInt());
            int i = 0, j = 0;
            while (scanner.hasNextDouble()) {
                matrix.changeElement(i, j, scanner.nextDouble());
                j++;
                if (j == matrix.getSize()) {
                    j = 0;
                    i++;
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return matrix;
    }

    public static double calcSumOfElements(MyMatrix matrix) throws IndexOutOfRange {
        double sum = 0;
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                sum += matrix.getElement(i, j);
            }
        }
        return sum;
    }

    public static void serializeMatrix(String filename, MyMatrix matrix) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(matrix);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MyMatrix deserializeMatrix(String filename) throws IOException, ClassNotFoundException {
        MyMatrix matrix;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            matrix = (MyMatrix)ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return matrix;
    }
}
