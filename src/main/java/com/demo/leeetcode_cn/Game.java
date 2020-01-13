package com.demo.leeetcode_cn;

public class Game {

    public int game(int[] guess, int[] answer) {
        if(guess.length !=3 ||answer.length !=3) {
            return  0;
        }
        int count = 0;
        for (int i =0;i<3;i++){
            if (guess[i]== answer[i]){
                count++;
            }
        }

        return count;




    }
}