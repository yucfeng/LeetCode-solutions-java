package yucfeng.com;

import org.junit.Test;

import java.util.Arrays;

public class Main {

    /**
     * 快速排序方法
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] QuickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            QuickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            QuickSort(array, smallIndex + 1, end);
        return array;
    }
    /**
     * 快速排序算法——partition
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        return smallIndex;
    }

    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,8,7,1,3,5,6,4};
        System.out.println(Arrays.toString(QuickSort(nums, 0, nums.length-1)));
    }

    @Test
    public void test() {
        GetNumSequence(7);
    }

    /*
     * 假设正整数 n 能表示为 i 个连续正整数之和且其第一个数为 x，则 n = x * i + (i - 1) * i/2，其中 n, x, i
     * 都为正整数， 所以如果 x = (n - (i-1)*i/2) / i 为正整数(即分子对i取模等于0)，则 n 就能表示为i个连续正整数之和。
     * i 的取值范围为[2,1+sqrt(1+8n)/2],可通过一元二次不等式求得)或者简单地认为i的取值范围为[2,n/2+1]
     */
    public static void GetNumSequence(int n) {
        if (n == 1) {
            System.out.println(1);
        }
        for (int i = 2; (2 * i - 1) * (2 * i - 1) - 1 < 8 * n; i++)// 将求根转化为平方。例如 i<sqrt(x)-->i*i<n
        {
            if ((n - i * (i - 1) / 2) % i == 0) {
                int x = (n - i * (i - 1) / 2) / i;
                int j = 0;
                while (j < i) {
                    System.out.print(x + " ");
                    x++;
                    j++;
                }
                System.out.println("");
            }
        }
    }
}