class Solution {
    public int[] sortArray(int[] nums) {
        MergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void MergeSort(int[] arr, int left, int right) {
        if (left == right) return;
        int mid = (left + right) / 2;
        MergeSort(arr, left, mid);
        MergeSort(arr, mid + 1, right);
        Merge(arr, left, right);
    }

    public static void Merge(int[] arr, int left, int right) {
        int len = right - left + 1;
        int[] tmp = new int[len];
        int mid = (left + right) / 2;
        for (int k = 0, i = left, j = mid + 1; k < len; k++) {
            if (i > mid) tmp[k] = arr[j++];
            else if (j > right) tmp[k] = arr[i++];
            else if (arr[i] < arr[j]) tmp[k] = arr[i++];
            else tmp[k] = arr[j++];
        }
        for (int k = 0, i = left; k < len; k++, i++) {
            arr[i] = tmp[k];
        }
    }
}