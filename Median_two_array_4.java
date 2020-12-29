/**
 * 4.寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 * 想法是：先把两个有序的数组合并成一个，然后从这一个有序数组中去算中位数，因为以前做过两个有序数组的合并
 */
public class Median_two_array_4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0){
            return 0;
        }
        if( nums1.length == 0){
            int length2 = nums2.length;
            int temp_length = length2 / 2;
            if (length2 % 2 == 0){
                return ((double)nums2[temp_length - 1] + nums2[temp_length])/2;
            }else {
                return nums2[temp_length];
            }
        }
        if( nums2.length == 0){
            int length1 = nums1.length;
            int temp_length = length1 / 2;
            if (length1 % 2 == 0){
                return ((double)nums1[temp_length - 1] + nums1[temp_length])/2;
            }else {
                return nums1[temp_length];
            }
        }
        int len1 = 0;
        int len2 = 0;
        int len = 0;
        int[] temp = new int[nums1.length + nums2.length];
        while (len1 < nums1.length && len2 < nums2.length){
            if(nums1[len1] < nums2[len2]){
                temp[len++] = nums1[len1++];
            }else {
                temp[len++] = nums2[len2++];
            }
        }
        while (len1 < nums1.length){
            temp[len++] = nums1[len1++];
        }
        while (len2 < nums2.length){
            temp[len++] = nums2[len2++];
        }
        if(len % 2 == 0){
            return ((double)temp[len/2-1] + temp[len/2]) / 2;
        }else {
            return temp[len/2];
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {0,0};
        int[] nums2 = {0,0};
        double result = findMedianSortedArrays(nums1,nums2);
        System.out.println(result);
    }
}
