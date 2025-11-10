class Solution {
    
    private static char l = 'L';
    private static char r = 'R';
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        boolean isRight = false;
        if (hand.equals("right")){
            isRight = true;
        }
        
        // * : 10, #: 12
        int left = 10, right = 12;
        for (int number:numbers){
            if (number ==0) number = 11;
            if (number == 1 || number == 4 || number == 7){
                left = number;
                answer.append(l);
                continue;
            }
            if (number == 3 || number == 6 || number == 9){
                right = number;
                answer.append(r);
                continue;
            }
            int curY = (number-1)/3;
            int curX = (number-1)%3;
            int rightY = (right-1)/3;
            int rightX = (right-1)%3;
            int diffRight = Math.abs(curY - rightY) + Math.abs(curX - rightX);
            int leftY = (left-1)/3;
            int leftX = (left-1)%3;
            int diffLeft = Math.abs(curY - leftY) + Math.abs(curX - leftX);
            if(diffLeft==diffRight){
                if (isRight){
                    right = number;
                    answer.append(r);
                } else {
                    left = number;
                    answer.append(l);
                }
                continue;
            }
            if (diffLeft<diffRight){ // diffLeft
                left = number;
                answer.append(l);
            } else {
                 right = number;
                answer.append(r);
            }
            
        }
        return answer.toString();
    }
    // 5/3 + 5%3-1
    // 3 vs 6 : (6-3)/3 = 1
    // 6: (1,2) , 3: (0,2) : (6-1)/3, (6-1)%3
    // 10 : (3,1), 6(1,2) -> 2+1 = 3 
    // (1,2) vs ()
}