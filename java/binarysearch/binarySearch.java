package binarysearch;

/**
 * 二分查找
 */
public class binarySearch {

    /**
     * 最简单的情况就是有序数组中不存在重复元素
     * <p>
     * low、high、mid 都是指数组下标，其中 low 和 high 表示当前查找的区间范围，
     * 初始 low=0， high=n-1。mid 表示[low, high]的中间位置。我们通过对比 a[mid]与 value 的大小，
     * 来更新接下来要查找的区间范围，直到找到或者区间缩小为 0，就退出
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        // 注意是 low<=high，而不是 low<high
        while (low <= high) {
            // 实际上，mid=(low+high)/2 这种写法是有问题的。因为如果 low 和 high 比较大的话，两者之和就有可能会溢出。
            // 改进的方法是将 mid 的计算方式写成 low+(high-low)/2。
            // 更进一步，如果要将性能优化到极致的话，我们可以将这里的除以 2 操作转化成位运算 low+((high-low)>>1)。
            // 因为相比除法运算来说，计算机处理位运算要快得多。
//            int mid = (low + high) / 2;
            int mid = low + ((high - low) >> 1);
            // low=mid+1，high=mid-1。注意这里的 +1 和 -1，如果直接写成 low=mid 或者 high=mid，就可能会发生死循环。
            // 比如，当 high=3，low=3 时，如果 a[3]不等于 value，就会导致一直循环不退出
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 二分查找的递归实现
     *
     * @param a
     * @param n
     * @param val
     * @return
     */
    public int recursionbsearch(int[] a, int n, int val) {
        return bsearchInternally(a, 0, n - 1, val);
    }

    private int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid + 1, high, value);
        } else {
            return bsearchInternally(a, low, mid - 1, value);
        }
    }

}
