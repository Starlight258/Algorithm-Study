import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int lastTime = 0;
        int[] people = new int[timetable.length];
        for (int i=0;i<timetable.length;i++){
            people[i] = toMinute(timetable[i]);
        }
        Arrays.sort(people);
        
        // 셔틀 버스 운행하기
        int start = 540;
        int pos = 0;
        int lastPeople = -1;
        for (int i=0;i<n;i++){
            start = 540 + i * t; // 버스 출발시간
            int capacity = m; // 탑승 가능 인원
            while (pos<people.length && capacity>0){
                if (start >= people[pos]){
                    capacity--;
                    pos++;
                    if (i==n-1 && capacity==0){
                        lastPeople = people[pos-1];
                    }
                } else break;
            }
        }
        // 마지막 탑승인원이 없을 경우 버스시간
        if (lastPeople==-1){
            lastTime = start;
        } else lastTime = lastPeople-1;
        // 시:분
        return toHHMM(lastTime);
    }
    public int toMinute(String time){
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
    public String toHHMM(int time){
        StringBuilder result = new StringBuilder();
        int hour = time / 60;
        int minute = time % 60;
        if (hour<10) result.append("0");
        result.append(String.valueOf(hour)).append(":");
        if (minute<10) result.append("0");
        result.append(minute);
        return result.toString();
    }
}