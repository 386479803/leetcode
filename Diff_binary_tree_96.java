import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 想法是：加入以第m个为root，那么组成的二叉搜索树有m的左子树能形成的二叉搜索树乘上m的右子树能形成的二叉搜索树
 * 而m的左子树能形成的二叉搜索树又能继续分成左右子树能形成多少，不断的这样拆分，然后合并起来
 * 但是这样的时间复杂度很高，可以把以m为root能形成的二叉搜索树的个数存储起来，下一次拆分可以直接使用
 */
public class Diff_binary_tree_96 {
    static Map<String,Integer> maps=new HashMap<>();
    public static int binary_tree_count(int low,int high){
        if(low == high || (low > high)){
            return 1;
        }
        int result = 0;
        for (int i = low;i <= high;i++){
            int lresult = 0;
            if(maps.get(low+"_"+(i-1))!=null){
                lresult = maps.get(low + "_" + (i-1));
            }else{
                lresult = binary_tree_count(low,i-1);
                maps.put(low+"_"+(i-1),lresult);
            }
            int rresult = 0;
            if(maps.get((i+1)+"_"+high)!=null){
                rresult=maps.get((i+1)+"_"+high);
            }else {
                rresult = binary_tree_count(i+1,high);
                maps.put((i+1)+"_"+high,rresult);
            }
            result = result + (lresult * rresult);
        }
        return result;
    }
    public static int numTrees(int n) {
        int result = 0;
        // for (int i = 1; i <= n; i++) {
        //     int lresult = binary_tree_count(1,i-1);
        //     int rresult = binary_tree_count(i+1,n);
        //     result = result + (lresult * rresult);
        // }
        result = binary_tree_count(1,n);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
