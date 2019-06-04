package wanghui.栈;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }
    public static boolean isValid(String s) {
        if(s==null || s.length()==0 || s.length()==1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chas = s.toCharArray();
        //Character[] chas = new Character[s.length()];

        //for (int i=0; i<s.length(); ++i) {
          //  chas[i] = s.charAt(i);
        //}
        boolean res = true;
        for(int i=0; i<chas.length; ++i) {
            if(isLeft(chas[i])) {
                stack.push(chas[i]);
            }else {
                if(stack.isEmpty()) {
                    res = false;
                    break;
                }else {
                    if(res = isCheck(stack.pop(), chas[i])) {
                        continue;
                    }else {
                        break;
                    }
                }
            }
        }
        if(!stack.isEmpty()) {
            res = false;
        }
        return res;
    }


    static boolean isCheck(char c1, char c2) {
        return (c1=='(' && c2==')') || (c1=='[' && c2==']') ||(c1=='{' && c2=='}');
    }

    static boolean isLeft(char c) {
        return c=='(' || c=='[' || c=='{';
    }
}
