class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        // n진법으로 변경
        int number = 0;
        int pos = 0;
        int tube = p-1;
       for (int count=0;count<=t*m;count++){
           String radixNumber = Integer.toString(number, n).toUpperCase();
           for (int i=0;i<radixNumber.length();i++){
               if (pos==tube){
                   answer+=radixNumber.charAt(i);
                   if (answer.length() == t) return answer;
                   tube += m;
               }
               pos++;
           }
           number++;
       }
        return answer;
    }
}