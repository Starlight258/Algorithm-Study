class Solution {
    public int solution(String s) {
        int answer = s.length();
        int size = 1;
        while (size<=s.length()/2){
            int start =0;
            StringBuilder result = new StringBuilder();
            String prev = "", cur = "";
            int count = 1;
            while (start+size<=s.length()){ // 같을 경우 정상, 커질 경우 문제
                cur = s.substring(start, start+size);
                if (prev.equals(cur)){
                    count++;
                } else {
                    if (count==1) result.append(prev);
                    else result.append(count).append(prev);
                    count = 1;
                }
                prev = cur;
                start+=size;
            }
                   
            if (start != s.length()){
                cur = s.substring(start);
                if (prev.equals(cur)){
                    result.append(count+1).append(prev);
                } else {
                    if (count==1) result.append(prev);
                    else result.append(count).append(prev);
                    count = 1;
                }
                prev = cur;
            }
            
            if (count==1) result.append(cur);
            else result.append(count).append(cur);
            prev = cur;
           
            answer = Math.min(answer, result.length());
            size++;
        }
        return answer;
    }
    // 앞에서부터 차근차근 반복되는 문자열 구하기
    // 2~n/2까지 길이 자르기 -> StringBuilder?
    // StringBuilder에 저장해서 숫자 붙이기
    // 구현
}