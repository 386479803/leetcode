package interview;

import java.util.Arrays;

/**
 *  我的解法是先排序，排序完之后，然后比较是否相等
 *  另外一种是把字符串的每个字符对应的Ascall码拿到，然后第一个字符串拿到Ascall码作为数组下标去加，第二个字符串拿到Ascall码作为下标去减
 *  最终查看这个数组的全部值是否为0
 */


public class CheckPermutation_1_2 {
    public boolean check(String s1,String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        String temp1 = new String(chars1);
        String temp2 = new String(chars2);
        if (temp1.equals(temp2)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CheckPermutation_1_2 c = new CheckPermutation_1_2();
        System.out.println(c.check("abc","bca"));
    }
}
