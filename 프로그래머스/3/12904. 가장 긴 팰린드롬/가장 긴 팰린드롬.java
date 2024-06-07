class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        for (int i=0;i<s.length();i++){
            // 짝수 비교
            int len1 = compare(s, i, i+1);
            
            // 홀수 비교(가운데 숫자부터 시작)
            int len2= compare(s, i, i);
            
            int len = Math.max(len1, len2);
            answer = Math.max(answer, len);
        }

        return answer;
    }
    
    public int compare(String s, int left, int right){
        int result = 1;
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            result = Math.max(result, right-left+1);
            left--;
            right++;
        }
        return result;
    }
}