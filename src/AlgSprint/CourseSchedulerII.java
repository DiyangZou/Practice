package AlgSprint;


import java.util.*;

public class CourseSchedulerII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your solution here
        int[] degree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            degree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < degree.length; i++){
            if(degree[i] == 0){
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        int count = numCourses;
        while(!queue.isEmpty()){
            int course = queue.poll();
            result.add(course);
            for(int[] require: prerequisites){
                if(require[1] == course) {
                    degree[require[0]]--;
                    if (degree[require[0]] == 0) {
                        queue.offer(require[0]);
                    }
                }
            }
            count--;
        }

        if(count != 0) return new int[0];
        int[] array = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            array[i] = result.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        CourseSchedulerII s = new CourseSchedulerII();
        int[] result = s.findOrder(4, new int[][]{{3,1}, {2,0}, {1,2}});
        System.out.print(Arrays.toString(result));
    }
}
