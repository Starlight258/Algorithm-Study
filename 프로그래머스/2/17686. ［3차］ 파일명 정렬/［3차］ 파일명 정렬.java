import java.util.*;

class Solution {
    class File implements Comparable<File>{
        String head;
        String number;
        String tail;
        
        File(String head, String number, String tail){
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
        public int compareTo(File o){
            String ohead = o.head.toUpperCase();
            String hhead = this.head.toUpperCase();
            if (ohead.equals(hhead)){
                if (!this.number.equals(o.number)){
                    int tNumber = Integer.parseInt(this.number);
                    int oNumber = Integer.parseInt(o.number);
                    return Integer.compare(tNumber, oNumber); // 오름차순 정렬
                }
                return 0;
            }
            return hhead.compareTo(ohead); // 오름차순 정렬
        }
    }
    
    public String[] solution(String[] files) {
        List<File> comFile = new ArrayList<>();
        for (String file: files){
            int firstNumber = 0;
            int firstTail = 0;
            boolean hasNumber = false;
            for (int i=0;i<file.length();i++){
                char c = file.charAt(i);
                int numberCount = 0;
                if (!hasNumber && c>='0' && c<='9'){
                    firstNumber = i;
                    hasNumber = true;
                    continue;
                }
                if (hasNumber){
                    numberCount++;
                    if (numberCount>5){
                        firstTail = i;
                        break;
                    }
                    if (!Character.isDigit(c)){
                        firstTail = i;
                        break;
                    }
                }
            }
            String head = file.substring(0, firstNumber);
            String number;
            String tail;
            if (firstTail==0){
                number = file.substring(firstNumber);
                tail = "";
            } else {
                number = file.substring(firstNumber, firstTail);
                tail = file.substring(firstTail);
            }
            
            comFile.add(new File(head, number, tail));
        }
        Collections.sort(comFile);
        String[] answer = new String[comFile.size()];
        for (int i=0;i<comFile.size();i++){
            File f = comFile.get(i);
            answer[i] = f.head + f.number + f.tail;
        }
  
        return answer;
    }
}
//  ver-9.zip ->  ver-10.zip
// img1.png", "img2.png", "img10.png", img12.png : 숫자순으로 정렬하도록 (숫자 추출)
//  파일명에 포함된 숫자를 반영한 정렬 기능
// 영문 대소문자, 숫자, 공백(" "), 마침표("."), 빼기 부호("-")
// HEAD + NUMBER + TAIL
// 문자(한 글자 이상) + 숫자(최대5글자) + TAIL(숫자 or 아무글자)
// HEAD 순으로 정렬 -> NUMBER 순으로 정렬(앞 O 무시) -> 같으면 입력 순서 유지 
