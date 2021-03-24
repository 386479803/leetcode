package interview;

import java.util.HashSet;
import java.util.Set;

public class SoloCharacter_1_1 {
    public boolean isUnique(String astr) {
        if (astr == null){
            return false;
        }
        char[] str = astr.toCharArray();
        Set set = new HashSet();
        for (int i = 0;i < str.length;i++){
            if (!set.contains(str[i])){
                set.add(str[i]);
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SoloCharacter_1_1 solo = new SoloCharacter_1_1();
        System.out.println(solo.isUnique(""));
    }
}
