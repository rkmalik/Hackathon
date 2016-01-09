package leetcode.prob150;

import java.awt.Container;
import java.util.Stack;

public class Solution {

    Stack<Integer> stack = new Stack<>();

    public int evalRPN(
            String[] tokens) {

        String operator = "-+/*";

        for (String s : tokens) {

            int left = 0;
            int right = 0;

            if (operator.contains(s) == false) {
                stack.push(Integer.parseInt(s));
            } else {
                int index = operator.indexOf(s);
                left = stack.pop();
                right = stack.pop();
                switch (index) {

                    
                    case '+':
                        stack.push(right + left);
                        break;

                    case '-':
                        stack.push(right - left);
                        break;

                    case '*':
                        stack.push(right * left);
                        break;

                    case '/':
                        stack.push(right / left);
                        break;

                }
            }
            
        }
        return stack.pop();
    }
}