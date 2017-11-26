package vectors;
public class Vector3DProcessor {
    // A + B
    public static Vector3D additionVectors(Vector3D vectorA, Vector3D vectorB) {
        Vector3D vectorAB = new Vector3D();
        vectorAB.setX(vectorA.getX() + vectorB.getX());
        vectorAB.setY(vectorA.getY() + vectorB.getY());
        vectorAB.setZ(vectorA.getZ() + vectorB.getZ());
        return vectorAB;
    }

    // A - B
    public static Vector3D substructionVectors(Vector3D vectorA, Vector3D vectorB) {
        Vector3D vectorAB = new Vector3D();
        vectorAB.setX(vectorA.getX() - vectorB.getX());
        vectorAB.setY(vectorA.getY() - vectorB.getY());
        vectorAB.setZ(vectorA.getZ() - vectorB.getZ());
        return vectorAB;
    }

    // A * B
    public static double scalarMultiplicationVectors(Vector3D vectorA, Vector3D vectorB) {
        return vectorA.getX() * vectorB.getX() + vectorA.getY() * vectorB.getY() + vectorA.getZ() * vectorB.getZ();
    }

    // |A * B|
    public static Vector3D vectorMultiplicationVectors(Vector3D vectorA, Vector3D vectorB) {
        Vector3D vectorAB = new Vector3D();
        vectorAB.setX(vectorA.getY() * vectorB.getZ() - vectorA.getZ() * vectorB.getY());
        vectorAB.setY(-(vectorA.getX() * vectorB.getZ() - vectorA.getZ() * vectorB.getX()));
        vectorAB.setZ(vectorA.getX() * vectorB.getY() - vectorA.getY() * vectorB.getX());
        return vectorAB;
    }

    public static boolean equals(Vector3D vectorA, Vector3D vectorB) {
        Vector3D vectorC = new Vector3D();
        if (vectorC.equals(Vector3DProcessor.vectorMultiplicationVectors(vectorA, vectorB))) {
            return true;
        } else {
            return false;
        }
        /*final double EPSILON = 0.00000001;
        // A || B
        boolean flag1 = (((Math.abs(vectorA.getX() / vectorB.getX() - vectorA.getY() / vectorB.getY()) < EPSILON) && (Math.abs(vectorA.getZ() / vectorB.getZ() - vectorA.getY() / vectorB.getY()) < EPSILON)) && (Math.abs(vectorA.getX() / vectorB.getX() - vectorA.getZ() / vectorB.getZ()) < EPSILON));
        // A == B
        boolean flag2 = vectorA.equals(vectorB);
        //vectorB.constMultipl(-1);
        // A == -B
        boolean flag3 = vectorA.equals(vectorB.constMultipl(-1));
        if (flag1 || flag2 || flag3) {
            return true;
        }
        else {
            return false;
        }*/
    }
}
