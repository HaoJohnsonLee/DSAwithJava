package per.johnson.dsa.a.leetcode;

/**
 * Created by Johnson on 2018/7/8.
 */
public class MedianOfTwoSortedArrays {
    /**
     * 数组切割
     * 边界条件下 置为 MAX OR MIN
     * @param nums1 数组1
     * @param nums2 数组2
     * @return mid
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        if(m == 0) return (nums2[(n-1)/2] + nums2[n/2])/2.0;
        int L1 = 0, L2 = 0, R1 = 0, R2 = 0, c1, c2, lo = 0, hi = 2 * m +1;
        while (lo < hi) {
            c1 = (lo + hi) >> 1;
            c2 = m + n - c1;
            L1 = (c1 == 0) ? Integer.MIN_VALUE : nums1[(c1 - 1) / 2];
            L2 = (c2 == 0) ? Integer.MIN_VALUE : nums2[(c2 - 1) / 2];
            R1 = (c1 == 2 * m) ? Integer.MAX_VALUE : nums1[(c1) / 2];
            R2 = (c2 == 2 * n) ? Integer.MAX_VALUE : nums2[(c2) / 2];
            if (L1 > R2) {
                hi = c1;
            } else if (L2 > R1) {
                lo = c1 + 1;
            } else
                break;
        }
        return ((Math.max(L1, L2) + Math.min(R1, R2)))/2.0;
    }

    public static void main(String[] args) {
        int[] n1 = {1};
        int[] n2 = {2, 3};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(n1, n2));
    }
}
