import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set set = new HashSet();
        char[] str = s.toCharArray();
        if (str.length == 0){
            return 0;
        }
        int max = 1;
        for (int i = 0; i < str.length; i++){
            set.clear();
            set.add(str[i]);
            int count = 1;
            for (int j = i + 1; j < str.length; j++){
                if (!set.contains(str[j])){
                    set.add(str[j]);
                    count++;
                }else{
                    break;
                }
            }
            if (count > max){
                max = count;
            }
        }
        return max;
    }
}
public class Max_norepeat_substring_3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(""));
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
    }
}
