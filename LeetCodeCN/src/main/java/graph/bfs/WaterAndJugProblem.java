package graph.bfs;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode.cn/problems/water-and-jug-problem/?show=1
public class WaterAndJugProblem {

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity > jug1Capacity + jug2Capacity) return false;
        if (targetCapacity == jug1Capacity + jug2Capacity) return true;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(jug1Capacity);
        q.add(jug2Capacity);
        visited.add(0);
        visited.add(jug1Capacity);
        visited.add(jug2Capacity);

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Integer cur = q.poll();
                if (cur == targetCapacity) {
                    return true;
                }

                int diff = Math.abs(jug1Capacity - cur);
                if (!visited.contains(diff)) {
                    q.offer(diff);
                    visited.add(diff);
                }
                diff = Math.abs(jug2Capacity - cur);
                if (!visited.contains(diff)) {
                    q.offer(diff);
                    visited.add(diff);
                }
                int sum = jug1Capacity + cur;
                if (sum == targetCapacity) {
                    return true;
                }
                sum = jug2Capacity + cur;
                if (sum == targetCapacity) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canMeasureWater2(int jug1Capacity, int jug2Capacity, int targetCapacity) {
//        Set<Integer> q1 = new HashSet<>();
//        Set<Integer> q2 = new HashSet<>();
//        Set<Integer> visited = new HashSet<>();
//        q1.add(jug1Capacity);
//        q1.add(jug2Capacity);
//        q2.add(targetCapacity);
//
//        while (!q1.isEmpty() && !q2.isEmpty()) {
//            if (q1.size() > q2.size()) {
//                // 交换 q1 和 q2, 保证每次都选择一个较小的集合进行扩散
//                Set<Integer> temp = q1;
//                q1 = q2;
//                q2 = temp;
//            }
//
//            Set<Integer> temp = new HashSet<>();
//            for (Integer cur : q1) {
//                if (q2.contains(targetCapacity)) {
//                    return true;
//                }
//                visited.add(cur);
//
//                int diff = Math.abs(jug1Capacity - cur);
//                if (!visited.contains(diff)) {
//                    temp.add(diff);
//                }
//                diff = Math.abs(jug2Capacity - cur);
//                if (!visited.contains(diff)) {
//                    temp.add(diff);
//                }
//                int sum = jug1Capacity + cur;
//                if (sum == targetCapacity) {
//                    return true;
//                }
//                sum = jug2Capacity + cur;
//                if (sum == targetCapacity) {
//                    return true;
//                }
//            }
//            q1 = q2;
//            q2 = temp;
//        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(canMeasureWater2(4, 6, 8));
    }
}
