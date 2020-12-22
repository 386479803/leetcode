import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L       C       I     R
 * E  T  O  E  S  I  I   G
 * E      D       H     N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 1 4
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L        D         R
 * E     O  E     I   I
 * E   C   I   H     N
 * T       S         G
 */

public class Zchange {
    public static String conver(String s,int numRows){
        if(numRows == 1){
            return s;
        }
        char str[] = s.toCharArray();
        List conv = new ArrayList();
        int periodNum = 2 * (numRows - 1);  // 每个周期多少个字符
        double periodCountdou = Math.ceil((double) str.length / periodNum);
        int periodCount = (int)periodCountdou;     //共有多少个周期
        for(int i = 0;i < numRows;i++){
            for (int j = 0;j < periodCount;j++){
                int k = j * (2 * (numRows) - 2) + i;     //每一行的第一个数在每个周期的位置
                if(k < str.length){   //如果没有超过边界值
                    conv.add(str[k]);
                }
                int count = 2 * (numRows - i - 1);  //一个周期内的第二次出现的位置
                if(i != 0 && i != numRows-1){        //第一行和最后一行的字符是没有第二次出现的
                    if(k + count < str.length){  //这个位置还有值
                        conv.add(str[k + count]);
                    }
                }
            }
        }
        String result = "";
        for (int i = 0;i < conv.size();i++){
            result = result + conv.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        String result = conver("Lshdhad",2);
        System.out.println(result);
    }
}
