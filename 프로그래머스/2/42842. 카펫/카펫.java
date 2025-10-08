class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = (brown + 4) / 2; // x+y
        for (int y=2;y<sum;y++){
            int x = sum - y;
            if ((y-2) * (x-2) == yellow){
                return new int[]{x,y};
            }
        }
        
        return answer;
    }
    // 가로, 세로 : x, y
    // (b-2) * (y-2)
    // brown : x+x+y+y-4 = 2x + 2y -4
    // yellow = (x-2) * (y-2) 
}