package wanghui.栈;


import java.util.Stack;

public class RemoveDuplicateLetter {
    /**
     * 贪心法
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        if(s==null || s.length()==0) {
            return "";
        }
        int[] cnt = new int[26];
        int pos = 0;
        char[] chas = s.toCharArray();
        int len = chas.length;
        for(int i=0; i<len; ++i) {
            cnt[chas[i]-'a']++;
        }
        for(int i=0; i<len; ++i) {
            if(chas[i] < chas[pos]) {
                pos = i;
            }
            if(--cnt[chas[i]-'a']==0) {
                break;
            }
        }
        return chas[pos]+removeDuplicateLetters(s.substring(pos+1).replaceAll(""+chas[pos], ""));
    }

    /**
     * 栈实现
     */
    public String removeDuplicateLetters1(String s) {
        /**
         * 有点问题，测试用例"cbacdcbc"不过，应该为"acdb"，
         */
//        if(s==null || s.length()==0) {
//            return "";
//        }
//        int[] result = new int[26];
//        char[] chas = s.toCharArray();
//        boolean[] visit = new boolean[26];
//        Stack<Character> stack = new Stack<>();
//        int len = s.length();
//        StringBuilder ans = new StringBuilder();
//        for(int i=0; i<len; ++i) {
//            result[chas[i]-'a']++;
//        }
//        for(int i=0; i<len; ++i) {
//            char c = chas[i];
//            while (!stack.isEmpty() && c<stack.peek() && !visit[i] && result[stack.peek()-'a']>0) {
//                char c1 = stack.pop();
//                result[c1-'a']--;
//                visit[c1-'a'] = false;
//            }
//            stack.push(c);
//            visit[c-'a'] = true;
//        }
//        while(!stack.isEmpty()) {
//            ans.insert(0, stack.pop());
//        }
//        return ans.toString();
        if(s==null || s.length()==0) {
            return "";
        }
        int[] result = new int[26];
        char[] chas = s.toCharArray();
        boolean[] visit = new boolean[26];
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<len; ++i) {
            result[chas[i]-'a']++;
        }
        for(int i=0; i<len; ++i) {
            char c = chas[i];
            result[c-'a']--;
            if(visit[c-'a']) {
                continue;
            }
            while (!stack.isEmpty() && c<stack.peek()  && result[stack.peek()-'a']>0) {
                char c1 = stack.pop();
                visit[c1-'a'] = false;
            }

            stack.push(c);
            visit[c-'a'] = true;

        }
        while(!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }


}
