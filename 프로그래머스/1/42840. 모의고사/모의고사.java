

class Solution {
    public int[] solution(int[] answers) {
        int p1 = person1(answers);
        int p2 = person2(answers);
        int p3 = person3(answers);
        int[] ps = new int[]{p1,p2,p3};
        int max = -1;
        
        for(int p : ps){
            if(p > max){
                max = p;
            }
        }
        int count = 0;
        for(int p : ps){
            if(max == p){
                count++;
            }
        }
        int[] answer = new int[count];
        int j = 0;
        for(int i= 0;i < 3; i++){
            if(max == ps[i]){
                answer[j++] = i+1;
            }
        }
        return answer;
    }
    
    public int person1(int[] answers){
        int score = 0;
        int i=1;
        for(int answer : answers){
            if(answer == i){
                score++;
            }
            if(++i >= 6){
                i=1;
            }
        }
        return score;
    }
    
    public int person2(int[] answers){
        int score = 0;
        int i=2;
        for(int j = 0; j < answers.length; j+=2){
            // System.out.println(answers[j] + " / " + i);
            if(answers[j] == i){
                score++;
            }
        }
        i = 0;
        int[] array = new int[]{1,3,4,5};
        for(int j = 1; j<answers.length; j+=2){
            // System.out.println(answers[j] + " / " + array[i]);
            if(answers[j] == array[i]){
                score++;
            }
            if(++i >= array.length){
                i = 0;
            }
        }
        return score;
    }
    
    public int person3(int[] answers){
        int score = 0;
        int[] array = new int[]{3,3,1,1,2,2,4,4,5,5};
        int pointer = 0;
        for(int i = 0; i < answers.length; i++){
            // System.out.println(answers[i] + " / " + array[pointer]);
            if(answers[i] == array[pointer]){
                score++;
            }
            if(++pointer >= array.length){
                pointer = 0;
            }
        }
        return score;
    }
}