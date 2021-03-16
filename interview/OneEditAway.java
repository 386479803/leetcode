package interview;

public class OneEditAway {
    public boolean oneEdit(String first,String second){
        if (first == null || second == null){
            return false;
        }
        if (first.equals(second)){
            return true;
        }
        int len1 = first.length();
        int len2 = second.length();
        if (len1 > len2 + 1 || len2 > len1 + 1){
            return false;
        }
        char[] one = first.toCharArray();
        char[] two = second.toCharArray();
        if (first.length() == second.length()){
            int count = 0;
            for (int i = 0; i < one.length;i++){
                if (one[i] != two[i]){
                    count++;
                }
            }
            return count <= 1;
        }
        int count = 0;
        int i = 0,j = 0;
        while(i < one.length && j < two.length){
            if (one[i]==two[j]){
                i++;
                j++;
            }else{
                count++;
                if (one.length > two.length){
                    i++;
                }else{
                    j++;
                }
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        OneEditAway oneEditAway = new OneEditAway();
        System.out.println(oneEditAway.oneEdit("teacher","teacherly"));
    }
}
