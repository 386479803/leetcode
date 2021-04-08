package interview;

import java.util.Arrays;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 */

public class SetZeroes_1_8 {
    public void setZeroes(int[][] matrix){

        int row = matrix.length;
        int column = matrix[0].length;

        boolean[][] flag = new boolean[row][column];
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix[i].length;j++){
                if (matrix[i][j] == 0) {
                    flag[i][j] = false;
                } else {
                    flag[i][j] = true;
                }
            }
        }

        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix[i].length;j++){
                if (matrix[i][j] == 0 && flag[i][j] == false) {
                    int n = 0;
                    int m = 0;
                    while (m < row){
                        matrix[m][j] = 0;
                        m++;
                    }
                    while (n < column){
                        matrix[i][n] = 0;
                        n++;
                    }
                }
            }
        }
        for (int i = 0;i < row;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void main(String[] args) {
        SetZeroes_1_8 s = new SetZeroes_1_8();
        int[][] a = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        int[][] b = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        s.setZeroes(a);
        System.out.println("===============题解的答案===========");
        s.solve(b);
        for (int i = 0;i < b.length;i++){
            System.out.println(Arrays.toString(b[i]));
        }
    }


    /**
     *  题解，可以先找到0的位置，有0的这一行和这一列都应该置0，那么最简单的想法就是把有0的这一行和这一列标记
     */
    public void solve(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rows = new int[m];
        int[] columns = new int[n];

        // 第一次遍历，找0的位置，把这有0的这一行和这一列标记
        for (int i = 0; i < m;i++){
            for (int j = 0;j < n;j++){
                if (matrix[i][j] == 0){
                    rows[i] = 1;
                    columns[j] = 1;
                }
            }
        }

        // 第二次遍历，根据记录，把有0的这一行和这一列置为0
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rows[i] == 1 || columns[j] == 1) // 如果属于有0的一行或者一列
                    matrix[i][j] = 0;
            }
        }

    }
}
