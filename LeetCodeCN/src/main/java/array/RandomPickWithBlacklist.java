package array;

import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.cn/problems/random-pick-with-blacklist/
public class RandomPickWithBlacklist {

    // 将区间 [0,N) 看做一个数组，然后将 blacklist 中的元素移到数组的最末尾，同时用一个哈希表进行映射
    class Solution {

        int size;
        Map<Integer, Integer> indexMap;

        public Solution(int n, int[] blacklist) {
            size = n - blacklist.length;
            indexMap = new HashMap<>();
            for (int b : blacklist) {
                indexMap.put(b, -1);
            }

            int last = n-1;
            for (int b : blacklist) {
                if (b > size-1) {
                    continue;
                }
                while (indexMap.containsKey(last)) {
                    last--;
                }
                indexMap.put(b, last);
                last--;
            }
        }

        public int pick() {
            int index = (int) (Math.random() * size);
            if (indexMap.containsKey(index)) {
                return indexMap.get(index);
            }
            return index;
        }
    }

    class Solution2 {

        List<Integer> blacklist;

        public Solution2(int n, int[] blacklist) {
            this.blacklist = new ArrayList<>();
            List<Integer> list = Arrays.stream(blacklist).boxed().collect(Collectors.toList());
            for (int i = 0; i < n; i++) {
                if (list.contains(i)) {
                    continue;
                }
                this.blacklist.add(i);
            }
        }

        public int pick() {
            return blacklist.get((int) (Math.random() * blacklist.size()));
        }
    }
}
