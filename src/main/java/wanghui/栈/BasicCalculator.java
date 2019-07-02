package wanghui.栈;

import java.util.Stack;

public class BasicCalculator {

    public static int calculate(String s) {
        //s = s.trim();
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i=0; i<s.length(); ++i) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                number = 10*number+(int)(c-'0');
            }else if(c=='+') {
                result+=sign*number;
                number = 0;
                sign=1;
            }else if(c=='-') {
                result+=sign*number;
                number=0;
                sign = -1;
            }else if(c=='(') {
                //push result first, then sign
                stack.push(result);
                stack.push(sign);
                //reset sign and result
                sign = 1;
                result = 0;
            }else if(c==')') {
                result+=sign*number;
                number = 0;
                result*=stack.pop();
                result+=stack.pop();
            }


        }
        if(number!=0) {
            result+=sign*number;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1 + 1"));
    }
}
