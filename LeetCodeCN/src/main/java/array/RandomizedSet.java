package array;

import java.util.*;


// https://leetcode.cn/problems/insert-delete-getrandom-o1/
public class RandomizedSet {

    List<Integer> list;
    Map<Integer, Integer> indexMap; // <val, index>
    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();  // ArrayList使用动态数组
        indexMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (list.contains(val)) {
            return false;
        } else {
            list.add(val);  // 万一出现扩容，时间复杂度就不是O(1)了
            indexMap.put(val, list.size() - 1);
            return true;
        }
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        } else {
            // 需要交换索引，以便从尾部删除元素。
            int index = indexMap.get(val);
            int lastNum = list.get(list.size() - 1);
            //Collections.swap(list, index, list.size() - 1);
            list.set(index, lastNum);
            indexMap.put(lastNum, index);

            list.remove(list.size() - 1);
            indexMap.remove(val);
            return true;
        }
    }

    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */