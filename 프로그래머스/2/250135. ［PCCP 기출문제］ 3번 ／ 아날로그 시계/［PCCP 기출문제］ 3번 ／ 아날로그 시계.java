class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        // 0시~주어진시간까지 횟수를 구한 이후 빼면 됨
        int ret = getCntFromMidNight(h2, m2, s2) - getCntFromMidNight(h1, m1, s1);
        if ((h1 == 0 || h1 == 12) && m1 == 0 && s1 == 0) ret += 1; // 0시와 12시인 경우에만 예외적으로 1씩 더해줌
        return ret;
    }

    // 0시0분0초 ~ h:m:s까지 겹치는 횟수
    private int getCntFromMidNight(int h, int m, int s) {
        double hDegree = (h * 30 + m * 0.5 + s * 0.5 / 60) % 360;
        double mDegree = (m * 6 + s * 0.1) % 360;
        double sDegree = s * 6;

        int ret = -1; // 0시0분0초는 분에 한번이므로 -1로 시작

        // 마지막 분의 상태를 계산
        if (sDegree >= mDegree) ret += 1;
        if (sDegree >= hDegree) ret += 1;

        ret += (h * 60 + m) * 2; // 분당 2번씩 만난다고 계산
        ret -= h; // 59분 -> 0분일때는 분침과 만나지 않음

        if (h >= 12) ret -= 2; // 11시59분59초 -> 12시인 경우 분,초침과 만나지않고 12시에 2번이아닌 1번만 만나는걸로 처리

        return ret;
    }
}