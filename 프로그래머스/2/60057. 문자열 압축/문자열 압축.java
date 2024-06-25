class Solution {
    public int solution(String s) {
        int answer = s.length();
        //1. 문자열 쪼개기
        for (int i=1;i<=s.length();i++){ // 쪼갤 단어 개수
            StringBuffer result = new StringBuffer();
            String prev = s.substring(0,i);
            int count = 1;
            for (int j=i;j<s.length();j+=i){ // 인덱스
                String split = s.substring(j, Math.min(j + i, s.length()));  
                if (prev.equals(split)){
                    count++;
                } else {
                    result.append(count>1?count:"").append(prev);
                    count=1;
                    prev = split;
                }
            }
            result.append(count>1?count:"").append(prev);
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}