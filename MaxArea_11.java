/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 * 题目的意思是:选择两个点，然后以小的那个点为高度画一条水平线，算出面积大小，即（i1-i2）*min(a1,a2)，a1是对应下标为i1的值，a2是下标为i2的值
 */

public class MaxArea_11 {

    public int maxArea(int[] height){
        int area = 0;
        int len = height.length - 1;
        int begin = 0;
        while (begin < len){
            int temp = (len - begin) * Math.min(height[len],height[begin]);
            area = Math.max(temp,area);
            if (height[begin] < height[len]){
                begin++;
            }else{
                len--;
            }
        }
        return area;
    }
    public static void main(String[] args){
        MaxArea_11 max = new MaxArea_11();
        int[] height = new int[]{4,3,2,1,4};
        System.out.println("最大的值是："+max.maxArea(height));
    }
}
