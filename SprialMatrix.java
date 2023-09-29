import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SprialMatrix {
    public static void main(String[] args) {
        SprialMatrix sprialMatrix = new SprialMatrix();
        int[][] matrix =    {{1,2,3,4,5},
                            {6,7,8,9,10},
                            {11,12,13,14,15},
                            {16,17,18,19,20},
                            {21,22,23,24,25}};
        sprialMatrix.spiralOrder(matrix);

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, down = m - 1;

        //Define result arr
        Integer[] res = new Integer[m * n];
        int index = 0;

        while(index < res.length){
            //Traverse right
            for(int i = left; i <= right && index < res.length; i++){
                res[index++] = matrix[top][i];
            }
            top++;
            //Traverse down
            for(int i = top; i <= down && index < res.length; i++){
                res[index++] = matrix[i][right];
            }
            right--;
            //Traverse left
            for(int i = right; i >= left && index < res.length; i--){
                res[index++] = matrix[down][i];
            }
            down--;
            //Traverse top
            for(int i = down; i >= top && index < res.length; i--){
                res[index++] = matrix[i][left];
            }
            left++;
        }
        System.out.println(Arrays.toString(res));
        return Arrays.asList(res);
    }
}
