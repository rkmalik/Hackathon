package leetcode.prob232;

import java.util.Stack;

class MyQueue {
    
    Stack <Integer> popstack;
    Stack <Integer> pushstack;
    public MyQueue () {
        
        popstack = new Stack<Integer> ();
        pushstack = new Stack<Integer> ();
        
    }
    
    
    // Push element x to the back of queue.
    public void push(int x) {
        
        pushstack.push(x);
        
    }

    // Removes the element from in front of queue.
    public void pop() {
        
        if (popstack.isEmpty()) {
            
            if (empty()) {
                return;   
            }
            
            // transfer data from push stack to pop data;
            while (pushstack.isEmpty() == false) {
                
                int data = pushstack.pop();
                popstack.push(data);
            }
        }
        
        popstack.pop();
    }

    // Get the front element.
    public int peek() {
        
        if (popstack.isEmpty()) {
            
            if (empty()) {
                return -1;   
            }
            
            // transfer data from push stack to pop data;
            while (pushstack.isEmpty() == false) {
                
                int data = pushstack.pop();
                popstack.push(data);
            }
        }
        
        return popstack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if (popstack.isEmpty() && pushstack.isEmpty()) {
            return true;
        }
        
        return false;
    }
}