/**
 * Created by Student on 11.09.2017.
 */
public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(Vector3D vectorB) {
        this.x = vectorB.getX();
        this.y = vectorB.getY();
        this.z = vectorB.getZ();
    }

    public Vector3D(Point3D A, Point3D B) {
        this.x = B.getX() - A.getX();
        this.y = B.getY() - A.getY();
        this.z = B.getZ() - A.getZ();
    }

    public Vector3D() { }

    public double lengthVector() {
        return Math.sqrt(Math.pow((x),2) + Math.pow((y),2) + Math.pow((z),2));
    }

    public Vector3D constMultipl(double lyambda) {
        Vector3D vector = new Vector3D(this);
        x = x * lyambda;
        y = y * lyambda;
        z = z * lyambda;
        return vector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector3D vector3D = (Vector3D) o;

        if (Double.compare(vector3D.x + +0.0, x) != 0) return false;
        if (Double.compare(vector3D.y + +0.0, y) != 0) return false;
        return Double.compare(vector3D.z + +0.0, z) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return " Vector3D{" +
                "x = " + x +
                ", y = " + y +
                ", z = " + z +
                "}\n";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
