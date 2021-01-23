import java.util.*;
class LeetCode20 {
    public boolean isValid(String s) {
        boolean answer = false;

        String [] lst = s.split("");

        Stack<String> stack = new Stack<>();

        stack.push(lst[0]);

        for (int i = 1; i < lst.length; i++){
            if (stack.empty()){
                stack.push(lst[i]);}
            else{
                if(same(stack.peek(), lst[i])){
                    stack.pop();
                }else{
                    stack.push(lst[i]);
                }
            }
        }

        if(stack.empty()){
            answer = true;
        }

        return answer;
    }

    public boolean same(String left, String right){
        if (left.equals("(") && right.equals(")")) {return true;}

        if (left.equals("{") && right.equals("}")) {return true;}

        if (left.equals("[") && right.equals("]")) {return true;}

        else {return false;}
    }

}
/**
valid Parentheses 문제
소괄호 중괄호 대괄호로 이루어진 문자열 에서
 제대로 열리고 닫히는지 true false 반환해야 한다
 stack을 이용해서 풀면 된다
 몇번이고 에러 나고, 답 틀리고 해서 애먹었다.
**/
