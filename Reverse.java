import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31，  2^31 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 * -2^31-1=2147483647,-2^31=-2147483648
 */

public class Reverse {
    //利用求余数先把x转换成数组表示，然后再组合起来
    public int reverse(int x){
        long result = 0; //用来保存取余后的值
        while(x != 0){
            result = result * 10 + x%10;
            x = x / 10;
        }
        if(result != (int)result){
            return 0;
        }else {
            return (int)result;
        }

    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        int result = reverse.reverse(-123);
        System.out.println(result);
    }
}
