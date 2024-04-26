class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer> adj[] = new List[n];
        int indegree[] = new int[n];
        List<Integer> answer = new ArrayList<>();
        for (int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }

        for (int[] pair:prerequisites){
            int course = pair[0];
            int prerequisite = pair[1];
            adj[prerequisite].add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<n;i++){
            if (indegree[i]==0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int current = queue.poll();
            answer.add(current);

            if (adj[current].size()!=0){
                for (int next:adj[current]){
                    indegree[next]--;
                    if (indegree[next]==0){
                        queue.offer(next);
                    }
                }
            }
        }

        return answer.size() == n;
    }
}
