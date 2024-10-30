class Solution {
    public int[] solution(String s) {
        int round = 0;
        int totalCount = 0;
        while (!s.equals("1")){
            round++;
            int count = 0;
            //1. 0의 개수 세기
            for (char c:s.toCharArray()){
                if (c=='0') count++;
            }
            totalCount += count;
            //2. 1의 개수로 이진수 만들기
            s = Integer.toBinaryString(s.length()-count);
        }
        return new int[]{round, totalCount};
    }
}