package interview;

public class ReplaceSpaces_1_3 {
    public String replace(String S,int length){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0;i < length;i++){
            if (S.charAt(i) == ' '){
                stringBuffer.append("%20");
            }else{
                stringBuffer.append(S.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        ReplaceSpaces_1_3 r = new ReplaceSpaces_1_3();
        System.out.println(r.replace("               ", 5));
    }
}
