/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 */

/**
 *想法是从第一个位置开始作为起始位置，然后找到跟开始位置相同字母的位置，然后判断这个区间的子字符串是不是一个回文子串，
 * 如果是，那么保存下来，比较大小
 */
public class LongestPalindrome_5 {
    public boolean isPalindrome(int index,int end, char[] chars){
        while(index <= end){
            if(chars[index] == chars[end]){ //首跟尾进行比较，如果存在不相等的情况，那么就返回false，否则就说明是一个回文子串
                index++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }
    public String longPalindrome(String s){
        char subString[] = s.toCharArray();
        int index = 0;  //最长回文子串的起始位置
        int length = 1;  // 最长回文子串的长度
        for (int i = 0; i < subString.length; i++){  //从开始位置开始，作为回文子串的第一个字符
            char now = subString[i];
            for (int j = i+1; j < subString.length; j++){  //寻找与当前i位置相同的字符，然后判断中间的子字符串是否是回文字符串
                if(now == subString[j]){
                    boolean flag = isPalindrome(i,j,subString);
                    if (flag == true){
                        if(j - i + 1 > length){  //如果是回文子串，并且子串的长度比之前的最长子串的长度长，那么现在这个子串就是最长子串，记录开始位置和长度
                            index = i;
                            length = j - i + 1;
                        }
                    }
                }
            }
        }
        String longPalindrome = "";
        for (int i = 0; i < length;i++){
            longPalindrome += subString[index+i];
        }
        return longPalindrome;
    }

    public static void main(String[] args) {
        LongestPalindrome_5 longestPalindrome_5 = new LongestPalindrome_5();
        System.out.println(longestPalindrome_5.longPalindrome("bbb"));
    }
}

/*
  注：leetcode上通过，但是这个思想解决的时间复杂度很高，仅仅只是解决了问题
 */