class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        int n = s.length();
        for (int i=0;i<n;i++){
            char cur = s.charAt(i);
            for (int j=i+1;j<n;j++){
                if (cur != s.charAt(j)){
                    continue;
                }
                int left = i;
                int right = j;
                boolean isPalin = true;
                while (left<=right){
                    if (s.charAt(left) != s.charAt(right)){
                        isPalin = false;
                        break;
                    }
                    left++; right--;
                }
                if (isPalin){
                    answer = Math.max(answer, j-i+1);
                }
            }
        }
        return answer;
    }
    // s -> 가장 긴 팰린드롬의 길이
    // abcdcba : 7
    // abacde : 3
    // two pointer? -> O(n)
    // 같은 글자를 찾고, 그 글자를 뒤바꾸면 같으면 (reverse()) -> 팰린드롬
    // 2500 * 2500 = 9_000_000
}