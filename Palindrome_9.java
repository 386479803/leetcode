import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。

 */
public class Palindrome_9 {
    public boolean isPalindrome(int x){
        if (x < 0){
            return false;
        }
        int y = 0;
        int temp = x;
        while(x > 0){
            y = y * 10 + x % 10;
            x = x / 10;
        }
        if (temp == y) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Palindrome_9 p = new Palindrome_9();
        System.out.println(p.isPalindrome(121));
    }
}



/*
    看到的一个比较精髓的比较，这样就不要比较整个整数了，只需要比较一半了
 */
//class Solution {
//    public boolean isPalindrome(int x) {
//        if (x == 0) return true;
//        if (x < 0 || x % 10 == 0) return false;
//        int reversed = 0;
//        while (x > reversed) {
//            reversed = reversed * 10 + x % 10;
//            x /= 10;
//        }
//        return x == reversed || x == reversed / 10;
//    }
//}