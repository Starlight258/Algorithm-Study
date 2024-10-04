class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        // 투포인터 사용하기
        int[] left = new int[100001], right = new int[100001];
        
        // 맨 처음에는 오른쪽에 모든 토핑 두기
        for (int i : topping){
            right[i]++;
        }
        // 전체 토핑 수 계산하기
        int ls = 0, rs = 0;
        for (int r: right){
            rs += r== 0 ? 0 : 1;
        }
        // 토핑 왼쪽으로 옮기기
        for (int i: topping){
            // 오른쪽에서 토핑 하나 제거
            right[i]--;
            if (right[i]==0) rs--;
            if (left[i]==0) ls++;
            left[i]++;
            if (ls == rs) answer++;
            if (ls>rs) break;
        }
        return answer;
    }
}

// left[i] = 왼쪽에 i 종류의 토핑 수
// right[i] = 오른쪽에 i 종류의 토핑 수