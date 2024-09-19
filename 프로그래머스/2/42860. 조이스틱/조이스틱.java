class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int leftRight = n-1;
        for (int i=0;i<n;i++){
            char goal = name.charAt(i);
            answer += Math.min(goal-'A', 'Z'-goal+1);
            int next = i+1;
            while (next<n && name.charAt(next) == 'A'){
                next++;
            }
            leftRight = Math.min(leftRight, i + n - next + Math.min(i, n - next));
        }
        return answer + leftRight;
    }
}