package leetcode.prob225;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    
    Queue<Integer> stack1;
    Queue<Integer> stack2;
    
    public MyStack () {
        stack1 = new LinkedList<Integer> ();
        stack2 = new LinkedList<Integer> ();        
    }
    

    
    // Push element x onto stack.
    public void push(int x) {
        
        // My strategy is just keep the last element in the single queue and 
        // keep the other in the othe queue.

        if (empty()) {
            stack1.add(x);
            
        }
        
        stack2.add(x);
        
    }

    // Removes the element on top of the stack.
    public void pop() {
        
    }

    // Get the top element.
   /* public int top() {
        
    }*/

    // Return whether the stack is empty.
    public boolean empty() {
        
        if (stack1.isEmpty() && stack2.isEmpty())
            return true;
        
        return false;
        
    }
}