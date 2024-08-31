package com.zql;

public class quick_sort {
    public static void main(String[] args) {
        int[] nums = {0,1,5,0,7,9,2,3,4,10};
        quick_sort q = new quick_sort();
        q.quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * 首先，对原数组执行一次“哨兵划分”，得到未排序的左子数组和右子数组。
     * 然后，对左子数组和右子数组分别递归执行“哨兵划分”。
     * 持续递归，直至子数组长度为 1 时终止，从而完成整个数组的排序
     */
    void quickSort(int[] nums, int left, int right) {
        //子数组长度为1时终止递归
        if (left >= right)
            return;
        //哨兵划分
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 哨兵划分完成后，原数组被划分成三部分：左子数组、基准数、右子数组，且满足“
     * 左子数组任意元素 <=基准数<=右子数组任意元素”。因此，我们接下来只需对这两个子数组进行排序。
     * @param nums
     * @param left
     * @param right
     * @return
     */
    //哨兵划分的实质是将一个较长数组的排序问题简化为两个较短数组的排序问题。
    //1、先划分好左右数组 2、将基准数交换至两子数组的分界线
    int partition(int nums[], int left, int right) {
        // 以 nums[left] 为基准数
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= nums[left])
                j--;
            while (i < j && nums[i] <= nums[left])
                i++;
            swap(nums, i, j); // 交换这两个元素
        }
        swap(nums, i, left);  // 将基准数交换至两子数组的分界线
        return i;
    }
}
