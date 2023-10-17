package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/all-paths-from-source-to-target/
public class AllPathsFromSourceToTarget {

    int target;
    List<List<Integer>> ans;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        target = graph.length-1;
        traverse(graph, 0, new LinkedList<>());
        return ans;
    }

    void traverse(int[][] graph, int s, LinkedList<Integer> onPath) {
        // 经过节点 s，标记为已遍历
//        visited[s] = true;
        // 做选择：标记节点 s 在路径上
        onPath.addLast(s);
        if (s == target) {
            List<Integer> tmp = new ArrayList<>(onPath);
            ans.add(tmp);
            onPath.removeLast();
            return;
            // 可以在这直接 return，但要 removeLast 正确维护 path
            // path.removeLast();
            // return;
            // 不 return 也可以，因为图中不包含环，不会出现无限递归
        }
        for (int neighbor : graph[s]) {
            traverse(graph, neighbor, onPath);
        }
        // 撤销选择：节点 s 离开路径
        onPath.removeLast();
    }
}
