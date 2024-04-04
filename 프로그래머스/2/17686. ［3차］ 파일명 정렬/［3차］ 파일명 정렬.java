import java.util.regex.*;
import java.util.*;
class File2 implements Comparable<File2>{
    String head;
    int number;
    int idx;
    String originalName;
    File2(String head, int number, String originalName, int idx){
        this.head = head.toUpperCase();
        this.number = number;
        this.originalName = originalName;
        this.idx = idx;
    }
    public int compareTo(File2 f1){
        if (this.head.equals(f1.head)){
            return this.number - f1.number;
        }
        return this.head.compareTo(f1.head);
    }

}
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        ArrayList<File2> list = new ArrayList<File2>();
        for (int i=0;i<files.length;i++){
            String[] parts = files[i].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
       
            // 문자열만큼만 split하기
            String head = parts[0];
            String num = parts[1];
            list.add(new File2(head, Integer.parseInt(num), files[i], i));
        }
        Collections.sort(list);
        for (int i=0;i<list.size();i++){
            File2 f = list.get(i);
            answer[i] = f.originalName;
        }
    
        return answer;
    }
}