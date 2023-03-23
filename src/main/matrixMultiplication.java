public class matrixMultiplication {
    public static int[][] multiplyMatrix(int[][] a, int[][] b) {
        double startTime = System.currentTimeMillis();
        int[][] result;
        result = new int[a.length][b[0].length];
        for(int i=0; i<a.length; i++) {
            for (int j=0; j<b[0].length; j++) {
                for(int k=0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        double endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime));
        return result;

    }

    public static void main(String[] args) {
        int size  = 1100;
        int[][] first = new int[size][size];
        int[][] second = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                first[i][j] = (i*j);
                second[i][j] = (i+j);
            }
        }
        multiplyMatrix(first, second);
    }
}
