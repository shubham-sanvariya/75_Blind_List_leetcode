import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] nums = {{5,1},{5,2},{1,3},{1,4},{3,4}};
        int[][] arr = {{1,0}};
        canFinish(6,nums);
    }

    static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        // adding the values in graph
        int[] indegree = new int[numCourses];
        for(int[] e: prerequisites) {
            graph[e[0]].add(e[1]);
            indegree[e[1]]++;
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int c : graph[current]) {
                indegree[c]--;
                if(indegree[c] == 0)
                    queue.add(c);
            }
            numCourses--;
        }
        System.out.println(numCourses);
        return numCourses == 0;
    }
}
