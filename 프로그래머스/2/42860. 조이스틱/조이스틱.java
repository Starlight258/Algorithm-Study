// import java.util.*;
// class Solution {
//     public int solution(String name) {
//         int answer = 0;
//         int pos= 0;
//         int n = name.length();
//         int cnt = 0;
//         PriorityQueue<Integer> spq = new PriorityQueue<>();
//         PriorityQueue<Integer> gpq = new PriorityQueue<>(Collections.reverseOrder());
        
//         // 오른쪽 이동
//         // 바꾸어야 할 알파벳 위치 저장
//         for (int i=0;i<n;i++){
//             if (name.charAt(i) != 'A'){
//               spq.offer(i);  
//               gpq.offer(i);  
//                 cnt++;
//             } 
//         }
//         while (cnt>0){
//             // position에서 가장 가까운 것부터 이동
//             int idx = 0;
//             if (spq.isEmpty()){
//                 idx = gpq.poll();
//                 answer += Math.min(n - idx + pos, idx-pos);
//                 answer += Math.min('Z'-name.charAt(idx) +1, 26 - ('Z'-name.charAt(idx)+1));
//                 cnt--;
//                 pos = idx;
//                 continue;
//             }
//             if (gpq.isEmpty()){
//                 idx = spq.poll();
//                 answer += Math.min(n - idx + pos, idx - pos);
//                 answer += Math.min('Z'-name.charAt(idx) +1, 26 - ('Z'-name.charAt(idx)+1));
//                 cnt--;
//                 pos = idx;
//                 continue;
//             }
//             int s = Math.min(n - spq.peek() + pos ,spq.peek() - pos);
//             int g = Math.min(n - gpq.peek() + pos, gpq.peek() - pos);
//             if (s<=g) idx = spq.poll();
//             else idx = gpq.poll();
//             answer += Math.min(s, g);
//             answer += Math.min('Z'-name.charAt(idx) +1, 26 - ('Z'-name.charAt(idx)+1));
//             cnt--;
//             pos = idx;
//         }

//         return answer;
//     }
// }

class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int minMove = n - 1;

        for (int i = 0; i < n; i++) {
            // 위, 아래로 이동하는 경우
            char c = name.charAt(i);
            int diff = c - 'A';
            answer += Math.min(diff, 26 - diff);

            // 왼쪽, 오른쪽으로 이동하는 경우
            int nextIdx = i + 1;
            while (nextIdx < n && name.charAt(nextIdx) == 'A') {
                nextIdx++;
            }

            int moveLeft = i;
            int moveRight = n - nextIdx;
            minMove = Math.min(minMove, moveLeft + moveRight + Math.min(moveLeft, moveRight));
        }

        answer += minMove;
        return answer;
    }
}