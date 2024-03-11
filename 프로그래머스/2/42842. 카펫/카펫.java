class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i=1;i<=yellow;i++){
            if (yellow%i==0){
                int a = i; // 세로
                int b = yellow / i; // 가로
                
                int brownNum = a * 2 + b * 2 + 4;
                if (brown == brownNum){
                    answer[0] = b + 2;
                    answer[1] = a + 2;
                    break;
                }
            }
        }
        return answer;
    }
}