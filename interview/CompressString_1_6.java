package interview;

public class CompressString_1_6 {
    public String compress(String S){
        int i = 0;
        int j = 0;
        StringBuffer temp = new StringBuffer();
        while (i < S.length()){
            char c = S.charAt(i);
            if (i == S.length()-1){
                temp.append(S.charAt(i));
                temp.append('1');
                break;
            }
            int count = 1;
            j = i + 1;
            while (j < S.length()){
                if (S.charAt(j) == c){
                    count++;
                    j++;
                }else{
                    break;
                }
            }
            temp.append(c);
            temp.append(count);
            i = j;
        }
        if (temp.toString().length() >= S.length()){
            return S;
        }
        return temp.toString();

    }

    /**
     *  一层循环就能解决，还是看了题解才想到这个思路，遇到不相等的加就好了
     * @param S
     */
    public String compress1(String S){
        StringBuffer stringBuffer = new StringBuffer();
        int slow = 0;
        int fast = 0;
        while (fast <= S.length()){
            if (fast == S.length()){
                stringBuffer.append(S.charAt(slow)).append(fast-slow);
            }else if (S.charAt(slow) != S.charAt(fast)){
                stringBuffer.append(S.charAt(slow)).append(fast-slow);
                slow=fast;
            }
            fast++;
        }
        if (stringBuffer.toString().length() >= S.length()){
            return S;
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        CompressString_1_6 com = new CompressString_1_6();
        System.out.println(com.compress("abbccd"));
    }
}
