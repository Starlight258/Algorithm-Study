import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> answer = new ArrayList<>();      
        for (long l = left;l<=right;l++){
            int r = (int)(l/n);
            int c = (int)(l%n);
            int e = Math.max(r, c)+1;
            answer.add(e);
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
}

// n, left, right
// n행 n열 크기의 비어있는 2차원 배열
// 1행 1열 ~ i행 i열까지의 모든 빈 칸을 i로 채운다.
// arr[left], arr[left+1], ... , arr[right]만 남기고 나머지는 지운다.
// 1. 배열 규칙 : 인덱스의 최대값이 원소이다.
//  1 2 3 (1)  [0][0]
//  2 2 3 (2)  [0][1] [1][0] [1][1]
//  3 3 3 (3) [0][2] [1][2] [2][2] [2][0] [2][1] 
// 2. 배열 자르기 (left~right) : left : left/r 행 lefr%r 열, right : right/r 행 right%r 열
