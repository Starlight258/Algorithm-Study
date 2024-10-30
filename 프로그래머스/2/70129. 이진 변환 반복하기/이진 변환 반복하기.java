class Solution {
    public int[] solution(String s) {
        int round = 0;
        int totalCount = 0;
        int size = 0;
        int count = 0;
        while (!s.equals("1")){
            round++;
            size = s.length();
            s = s.replaceAll("0", "");
            totalCount += size-s.length();
            s = Integer.toBinaryString(s.length());
        }
        return new int[]{round, totalCount};
    }
}