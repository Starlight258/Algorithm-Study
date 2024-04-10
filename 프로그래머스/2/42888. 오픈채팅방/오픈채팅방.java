import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<String>();
        HashMap<String, String> hm = new HashMap<>();
        for (String rc:record){
            String[] r = rc.split(" ");
            if (r[0].equals("Enter") || r[0].equals("Change")){
                hm.put(r[1], r[2]);
            }
        }
        for (String rc:record){
            String[] r = rc.split(" ");
            if (r[0].equals("Enter")){
                answer.add(new StringBuilder(hm.get(r[1])).append("님이 들어왔습니다.").toString());
            }
            else if (r[0].equals("Leave")){
                answer.add(new StringBuilder(hm.get(r[1])).append("님이 나갔습니다.").toString());
            }
            
        }
        String[] ret = new String[answer.size()];

        return answer.toArray(ret);
    }
}