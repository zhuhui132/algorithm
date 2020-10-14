package com.seven.one;



@Component(identifer = "uppder")
public class UpperCaseComponent {
    public String dowork(String input){
        if(input != null) {
            return input.toUpperCase();
        } else {
            return null;
        }
    }
}
