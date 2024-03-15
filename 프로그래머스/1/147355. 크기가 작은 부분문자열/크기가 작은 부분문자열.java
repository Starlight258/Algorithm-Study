class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int length = p.length();
        long pNum = Long.parseLong(p);
        for (int i=0; i<=t.length()-length;i++){
            long tNum = Long.parseLong(t.substring(i, i+length));
            if (pNum >= tNum){
                answer++;
            }
        }
        return answer;
    }
}