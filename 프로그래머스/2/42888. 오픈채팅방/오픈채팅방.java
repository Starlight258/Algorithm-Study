import java.util.*;

class Solution {
    public String[] solution(String[] records) {
        Map<String, String> nicknames = new HashMap<>();
        // 마지막 닉네임 저장
        for (String record:records){
            String[] split = record.split(" ");
            if (split[0].equals("Enter")){
                nicknames.put(split[1], split[2]);
            } 
            if (split[0].equals("Change")){
                nicknames.put(split[1], split[2]); 
            }
        }

        // 히스토리별 result 저장
        List<String> result = new ArrayList<>();
        for (String record:records){
            String[] split = record.split(" ");
                  String nickname = nicknames.get(split[1]);
            if (split[0].equals("Enter")){
                result.add(nickname+"님이 들어왔습니다.");
                }
            if (split[0].equals("Leave")){
                result.add(nickname+"님이 나갔습니다.");
            }
        }
        
        return result.toArray(new String[0]);
    }
}