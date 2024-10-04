class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        // d^2 / k^2
        long sum = (long)((Math.pow(d, 2) / Math.pow(k, 2)));
        int maxAB = (int) Math.sqrt(sum);
        for (int a=0;a<=maxAB;a++){
            int maxB = (int) Math.sqrt(sum - Math.pow(a, 2));
            answer += maxB+1;
        }
        return answer;
    }
    private boolean checkDistance(int x, int y, long sum){
        long distance = (long)(Math.pow(x, 2)+ Math.pow(y, 2));
        return distance <= sum;
    }
}

// x축과 y축이 직교하는 2차원 좌표평면
// 양의 정수 k, d
// (a*k, b*k)
// 원점과 거리가 d를 넘지 않은 위치에는 점을 찍지 않음
// 거리가 d를 넘는 위치는 X
// 점이 총 몇개 찍히는지?
// 최대 k : d/a, d/b , a^2+b^2=d
// 모든 점에 대해 반복하면서 거리 구하고 개수 세기