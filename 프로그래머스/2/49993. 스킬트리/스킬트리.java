import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        //1. map에 저장
        Map<Character, Integer> mp = new HashMap<>();
        for (int i=0;i<skill.length();i++){
            mp.put(skill.charAt(i), i);
        }
        //2. 순서 확인
        for (String tree:skill_trees){
            int pos=0;
            boolean flag = false;
            for (Character c:tree.toCharArray()){
                int e = mp.getOrDefault(c, -1);
                if (e != -1){
                    if (pos== e) pos++;
                    else {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) answer++;
        }
        return answer;
    }
}