package interview;

public class IsFlipedString_1_9 {
    public boolean isFliped(String s1,String s2){
        if (s1.length() != s2.length()){
            return false;
        }

        if (s1.equals(s2)){
            return true;
        }
        char first = s1.charAt(0);
        int index = s2.indexOf(first);

        if (index < 0){
            return false;
        }

        while (index < s2.length() && index >= 0){
            int i = 1;
            int j = index + 1;
            while (i < s1.length()){
                if (s1.charAt(i) != s2.charAt(j % s2.length())){
                    break;
                }
                i++;
                j++;
            }
            if (i == s1.length()){
                return true;
            }
            index = s2.indexOf(first,index+1);
        }
        return false;
    }

    public static void main(String[] args) {
        IsFlipedString_1_9 f = new IsFlipedString_1_9();
        System.out.println(f.isFliped("aba","bab"));
    }

    /**
     * leetcode 上别人的题解
     */

    public boolean solution(String s1,String s2){
        if (s1.length()!=s2.length()) return false;
        String ss = s2+s2;
        return ss.contains(s1);
    }
}
