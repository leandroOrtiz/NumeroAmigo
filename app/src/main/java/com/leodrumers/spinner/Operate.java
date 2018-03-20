package com.leodrumers.spinner;


public class Operate {
    public double answer;

    public double numericSystem(double a, double b){
        this.answer = a +b;

        return answer;
    }

    public boolean multiple(double a, double b){
        if(a % b == 0){
            return true;
        }else{
            return false;
        }
    }

    public double friends(double a){
        answer = 0;
        for (int i = 1; i < a; i++){
            if(a % i == 0){
                answer += i;
            }
        }
        return answer;
    }

    public double potency(double a, double b){
        this.answer = Math.pow(a,b);

        return answer;
    }

}
