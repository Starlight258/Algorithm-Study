import java.util.Arrays;

class Solution {
    class Task implements Comparable<Task> {
        int begin;
        int finish;
        int reward;

        Task(int begin, int finish, int reward) {
            this.begin = begin;
            this.finish = finish;
            this.reward = reward;
        }

        public int compareTo(Task t) {
            if (this.finish == t.finish) {
                return t.reward - this.reward;
            }
            return this.finish - t.finish;
        }
    }

    public int solution(int[] begins, int[] finishes, int[] rewards) {
        Task[] tasks = new Task[begins.length];
        for (int i = 0; i < begins.length; i++) {
            tasks[i] = new Task(begins[i], finishes[i], rewards[i]);
        }

        Arrays.sort(tasks);

        int numTasks = begins.length;
        int[] maxRewards = new int[numTasks + 1];

        for (int i = 1; i <= numTasks; i++) {
            Task currentTask = tasks[i - 1];
            int prevTaskIndex = 0;

            for (int j = i - 1; j >= 1; j--) {
                if (tasks[j - 1].finish <= currentTask.begin) {
                    prevTaskIndex = j;
                    break;
                }
            }

            maxRewards[i] = Math.max(maxRewards[i - 1], maxRewards[prevTaskIndex] + currentTask.reward);
        }

        return maxRewards[numTasks];
    }
