package vectors;

import static vectors.Vector3DProcessor.additionVectors;

/**
 * Created by student on 20.09.17.
 */
public class Vector3DArray {
    private Vector3D[] array;

    public Vector3DArray (int size) throws BadSizeValueException {
        if (size <=0) {
            throw new BadSizeValueException();
        }
        array = new Vector3D[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Vector3D();
        }
    }

    public Vector3DArray (Vector3D ... vectors) {
        array = new Vector3D[vectors.length];
        for (int i = 0; i < vectors.length; i++) {
            array[i] = new Vector3D(vectors[i]);
        }
    }

    public int length() {
        return array.length;
    }

    public double maxLengthOfVector3D() {
        double temp = array[0].lengthVector();
        for (int i = 1; i < this.length(); i++) {
            if (array[i].lengthVector() > temp) {
                temp = array[i].lengthVector();
            }
        }
        return temp;
    }

    public int findFirstVector(double x, double y, double z) {
        if (array == null) return -2;
        int i = 0;
        while (i < this.length()) {
            if ((array[i].getX() == x) && (array[i].getY() == y) && (array[i].getZ() == z)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public Vector3D sumVectors() {
        Vector3D vector = new Vector3D();
        for (int i = 0; i < this.length(); i++) {
            vector = additionVectors(vector, array[i]);
        }
        return vector;
    }

    public void changeElem(Vector3D vector, int position) throws BadSizeValueException {
        if (position < 0 || position >= this.length()) {
            throw new BadSizeValueException("Bad index in array: " + position);
        }
        array[position] = new Vector3D(vector);
    }

    public Point3D[] movePoint(Point3D point) {
        if (array == null) return null;
        Point3D[] points = new Point3D[this.length()];
        for (int i = 0; i < this.length(); i++) {
            points[i] = new Point3D(point.getX() + array[i].getX(), point.getY() + array[i].getY(), point.getZ() + array[i].getZ());
        }
        return points;
    }

    public Vector3D lineCombination(double... args) {
        if (args.length != this.length() && this.length() == 0) throw  new IllegalArgumentException();
        Vector3D vector = new Vector3D();
        for (int i = 0; i < this.length(); i++) {
            vector = additionVectors(vector, array[i].constMultipl(args[i]));
        }
        return vector;
    }

    public String toString() {
        if (this == null) return "null";
        String str = "";
        for (int i = 0; i < this.length(); i++) {
            str += "vector[" + i + "] = " + this.array[i].toString();
        }
        return str;
    }

    public Vector3D getArray(int position) {
        return array[position];
    }

    public Vector3D[] getArray() {
        return array;
    }

    public void setArray(Vector3D[] array) {
        this.array = array;
    }

    //public void add(double x,double y,double z, int position){
    //}

}
