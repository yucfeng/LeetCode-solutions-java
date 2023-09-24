package abs;

// https://leetcode.cn/problems/binary-search/
public class BinarySearch {
    /* 二分搜索模板
int binarySearch(int[] nums, int target) {
    int left = 0, right = ...;

    while(...) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            ...
        } else if (nums[mid] < target) {
            left = ...
        } else if (nums[mid] > target) {
            right = ...
        }
    }
    return ...;
}
     */

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {  //
            int mid = left + (right - left) / 2; // 防止left 和 right 太大，直接相加导致溢出的情况
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;  // 闭合区间
            } else if (nums[mid] > target) {
                right = mid - 1;  // 闭合区间
            }
        }
        return -1;
    }

    int left_bound1(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // 注意 左闭右开区间

        while (left < right) { // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        if (left < 0 || left >= nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    int left_bound2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        // 如果越界，target 肯定不存在，返回 -1
        if (left < 0 || left >= nums.length) {
            return -1;
        }
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }

    int right_bound1(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        // 判断 target 是否存在于 nums 中
        // left - 1 索引越界的话 target 肯定不存在
        if (left - 1 < 0 || left - 1 >= nums.length) {
            return -1;
        }
        // 判断一下 nums[left - 1] 是不是 target
        return nums[left - 1] == target ? (left - 1) : -1;
    }

    int right_bound2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            }
        }
        // 最后改成返回 right
        if (right < 0 || right >= nums.length) {
            return -1;
        }
        return nums[right] == target ? right : -1;
    }


}
