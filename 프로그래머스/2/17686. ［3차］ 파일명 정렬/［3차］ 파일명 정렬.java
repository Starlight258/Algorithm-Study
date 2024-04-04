import java.util.*;
import java.util.regex.*;
class File implements Comparable<File>{
    String head;
    int number;
    int idx;
    File(String head, int number, int idx){
        this.head = head.toUpperCase();
        this.number = number;
        this.idx = idx;
    }
    public int compareTo(File f){
        if (this.head.equals(f.head)){
            return this.number - f.number;
        }
        return this.head.compareTo(f.head);
    }

}
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        ArrayList<File> list = new ArrayList<File>();
        Pattern pattern = Pattern.compile("\\d+");
        for (int i=0;i<files.length;i++){
            Matcher matcher = pattern.matcher(files[i]);
            String head =""; String num = "";
            if (matcher.find()){
                head = files[i].substring(0, matcher.start());
                num = files[i].substring(matcher.start(), matcher.end());
                list.add(new File(head, Integer.parseInt(num), i));
            }
        }
        Collections.sort(list);
        for (int i=0;i<list.size();i++){
            File f = list.get(i);
            answer[i] = files[f.idx];
        }
    
        return answer;
    }
}