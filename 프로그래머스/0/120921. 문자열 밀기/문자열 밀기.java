class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        if (A.equals(B)){
            return 0;
        }
        if (A.length()==1){
            return -1;
        }
        int n = A.length();
        for (int i=1;i<A.length();i++){
            String message = A.substring(n-i) + A.substring(0, n-i);
            if (message.equals(B)){
                return i;
            }
        }
        return -1;
    }
    // "hello" 
    // A -> B
    // 100 -> 직접 구현
}