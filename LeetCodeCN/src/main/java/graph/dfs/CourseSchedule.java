package graph.dfs;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/course-schedule/
public class CourseSchedule {

    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        return !hasCycle;
    }

    private void traverse(List<Integer>[] graph, int node) {
        if (onPath[node]) {
            hasCycle = true;
            return;
        }
        if (visited[node]) return;

        onPath[node] = true;
        visited[node] = true;
        for (int n : graph[node]) {
            traverse(graph, n);
        }
        onPath[node] = false;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        // 先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1
        // 在graph中 0-->1
        for (int[] pre : prerequisites) {
            graph[pre[0]].add(pre[1]);
        }
        return graph;
    }

    @Test
    public void test() {
        System.out.println(canFinish(2, new int[][]{{0,1}}));
    }
}
