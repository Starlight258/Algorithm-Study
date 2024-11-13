import java.util.*;
import java.util.regex.*;

class Solution {
    private static final String REGEX = "((\\d)+,*)+";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    public int[] solution(String s) {
        // 1. 문자열 나누기
        s = s.substring(1,s.length()-1);
        Matcher matcher = PATTERN.matcher(s);
        // 2. 문자열 빈도만큼 저장하기
        Map<Integer, Integer> mp = new HashMap<>();
        while (matcher.find()){
            String[] numbers = matcher.group(0).split(",");
            for (String number:numbers){
                int n = Integer.parseInt(number);
                mp.put(n, mp.getOrDefault(n, 0)+1);
            }
        }
        // 3. 빈도수대로 key 정렬하기
        List<Integer> keys = new ArrayList<>(mp.keySet());
        keys.sort((o1, o2) -> mp.get(o2).compareTo(mp.get(o1)));
        
        return keys.stream().mapToInt(x->x).toArray();
    }
}

// 튜플 배열에 담아 반환
// [가장 자주 나타난 숫자, 그 다음 자주 나타난 숫자,..., 1번 나타난 숫자]
// Map<Integer, Integer> -> value로 key 내림차순 정렬