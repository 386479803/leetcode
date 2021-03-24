package interview;

public class Rotate_1_7 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int temp[][] = new int[len][len];
        int row = 0;
        while (row < len){
            int column = 0;
            while (column < len){
                temp[column][len-row-1] = matrix[row][column];
                column++;
            }
            row++;
        }
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix.length;j++){
                matrix[i][j] = temp[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Rotate_1_7 r = new Rotate_1_7();
        int matrix[][] = {{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix.length;j++){
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("旋转后");
        r.rotate(matrix);
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix.length;j++){
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
