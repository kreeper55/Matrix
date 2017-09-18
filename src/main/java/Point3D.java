/**
 * Created by Student on 11.09.2017.
 */
public class Point3D {
    private double x;
    private double y;
    private double z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point3D)) return false;

        Point3D point3D = (Point3D) o;

        if (Double.compare(point3D.x, x) != 0) return false;
        if (Double.compare(point3D.y, y) != 0) return false;
        return Double.compare(point3D.z, z) == 0;
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

    public void outputPoint() {
        System.out.println("x " + this.x + "y " + this.y + "z " + this.z);
    }

   /* public boolean checkEquality(double x1, double y1, double z1, double x2, double y2, double z2) {
        if ((x1 == x2) && (y1 == y2) && (z1 == z2)) {
            return true;
        } else {
            return false;
        }
    }*/

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
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

}
