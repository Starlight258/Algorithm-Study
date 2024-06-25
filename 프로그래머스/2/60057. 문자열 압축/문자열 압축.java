class Solution {
    public int solution(String s) {
        int answer = s.length();
        //1. 문자열 쪼개기
        for (int i=1;i<=s.length();i++){ // 쪼갤 단어 개수
            StringBuffer result = new StringBuffer();
            String last = "";
            int plusNum = 1;
            for (int j=0;j<s.length();j+=i){ // 인덱스
                String split = "";
                if (j+i >= s.length()) split = s.substring(j);
                else split = s.substring(j, j+i);  
                // 이전 문자와 비교
                if (j==0) last = split;
                else if (last.equals(split)){
                    plusNum++;
                } else {
                    if (plusNum==1) result.append(last);
                    else{
                      result.append(plusNum + last);
                      plusNum=1;
                    } 
                    last = split;
                }
            }
            if (plusNum>=1){
                if (plusNum==1) result.append(last);
                else{
                  result.append(plusNum + last);
                  plusNum=1;
                } 
            }
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}