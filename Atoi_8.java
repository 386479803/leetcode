import java.util.Arrays;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−2^31) 。
 */
public class Atoi_8 {
    public int myAtoi(String s) {
        if ("".equals(s)){
            return 0;
        }
        char[] str = s.toCharArray();
        char flag = '+';  //默认转换的是一个正数

        if (!(str[0] >= '0' && str[0] <= '9' || ' ' == str[0] || '+' == str[0] || '-' == str[0])){
            return 0;
        }
        int i = 0;
        String temp = "";
        //去掉前面的空格
        while (i < str.length){
            if(' ' == str[i]){
                i++;
            }else {
                break;
            }
        }
        char[] nosapce = new char[str.length-i];
        int j = 0;
        while (j < str.length - i){
            nosapce[j] = str[j+i];
            j++;
        }
        i = 0;
        while(i < nosapce.length){
            //如果以"+"或者"-"开头记录下符号
            if('+' == nosapce[i]&& i < 1){
                i++;
                continue;
            }
            if('-' == nosapce[i] && i < 1){
                i++;
                flag = '-';
                continue;
            }
            if(nosapce[i] >= '0' && nosapce[i] <= '9'){
                temp += nosapce[i++];
            }else {
                break;
            }
        }
        if (temp == ""){
            return 0;
        }
        //先用long类型的来保存字符串转成整数的值，然后把long强转成int,这样如果超过了int大小，返回的也是int范围内的
        try {
            long nums = Long.parseLong(temp);
            int result = (int)nums;
            if (flag == '-'){
                if (nums == result){
                    return -result;
                }else{
                    return Integer.MIN_VALUE;
                }
            }else {
                if (nums == result) {
                    return result;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        } catch(Exception e){
            if (flag == '-'){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args) {
        Atoi_8 atoi_8 = new Atoi_8();
        System.out.println(atoi_8.myAtoi("20000000000000000000"));
    }
}
