package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CanPermutePalindrome_1_4 {
    /**
     * map 比较笨
     * @param
     * @return
     */
    public boolean canPermute(String s){
        Map<String,Integer> map = new HashMap();
        for (int i = 0; i < s.length();i++){
            if (map.containsKey(String.valueOf(s.charAt(i)))){
                map.put(String.valueOf(s.charAt(i)),map.get(String.valueOf(s.charAt(i)))+1);
            }else{
                map.put(String.valueOf(s.charAt(i)),1);
            }
        }
        int count = 0;
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            if (entry.getValue() % 2 != 0){
                count++;
            }
        }
        if (count > 1){
            return false;
        }
        return true;
    }


    /**
     * 我也想过用 set，但是没想好如果有超过两个相同的字母怎么办。这个就想到了，如果set集合不存在这个字母就加入，如果存在了就移除，这样，
     * 一加一减，如果是偶数个，最后是没有这个字母的
     * @param s
     */
    public boolean canPermutePalindrome(String s) {
        if(s == null){
            return false;
        }
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c : chars){
            if(set.contains(c)){
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        return set.size() <= 1;
    }
    public static void main(String[] args) {
        CanPermutePalindrome_1_4 c = new CanPermutePalindrome_1_4();
        System.out.println(c.canPermute("tactcoa"));
    }
}
