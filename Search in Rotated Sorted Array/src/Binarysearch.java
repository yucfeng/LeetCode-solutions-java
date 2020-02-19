public class Binarysearch {
    public static int binarySearch(int[] arr, int start, int end, int hkey){
        if (start > end)
            return -1;

        int mid = start + (end - start)/2;    //防止溢位
        if (arr[mid] > hkey)
            return binarySearch(arr, start, mid - 1, hkey);
        if (arr[mid] < hkey)
            return binarySearch(arr, mid + 1, end, hkey);
        return mid;

    }

    public static void main(String[] args) {
        int[] nums = {5,5,7,8,8,10};
        System.out.println(binarySearch(nums, 0, nums.length, 5));
        int[] b = new int[10];
        System.out.println(b[1]);
        char c = '9';
        System.out.println(b[Integer.parseInt(String.valueOf(c))]);
    }
}
