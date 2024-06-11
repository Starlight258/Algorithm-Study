class Solution {
    public int getDistance(int number1, int number2){
        int y1 = (number1-1)/3;
        int x1 = (number1-1)%3;
        int y2 = (number2-1)/3;
        int x2 = (number2-1)%3;
        return Math.abs(y1-y2)+Math.abs(x1-x2);
    }
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int left = 10; int right=12;
        for (int number:numbers){
            if (number==1||number==4||number==7){
                answer.append("L");
                left = number;
            } else if (number==3||number==6||number==9){
                answer.append("R");
                right = number;
            } else {
                if (number==0) number=11;
                int leftDistance = getDistance(number, left);
                int rightDistance = getDistance(number, right);
                if (leftDistance==rightDistance){
                    if (hand.equals("right")){
                        answer.append("R");
                        right=number;
                    } else {
                        answer.append("L");
                        left = number;
                    }
                }
                else if (leftDistance>rightDistance){
                    answer.append("R");
                    right=number;
                } else {
                    answer.append("L");
                    left = number;
                }
            }
        }
        return answer.toString();
    }
}