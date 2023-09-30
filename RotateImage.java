import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotateImage.rotate(matrix);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length, col = matrix[0].length;
//        System.out.println(Arrays.deepToString(matrix));
        transposeMatrix(matrix);

        for(int[] arr : matrix){
            reverseArr(arr);
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    private void reverseArr(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j){
            int temp = arr[i];
            arr[i] =  arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    private void transposeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}
