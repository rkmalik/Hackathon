package algorithms.ds.queue;

import java.util.Random;

public class UnitTestListBased {
    
    public static void main (String args []) {
        
        Random randGenerator = new Random();
        BaseQueue<Integer> queue = new QueueListBased<Integer>();
        
        for (int i = 0; i < 20 ; i++) {
            
            int data = randGenerator.nextInt(100);
            int operation = randGenerator.nextInt(10);
            
            // enqueue Operation
            if (operation%2 == 0) {
                System.out.println("Added " + data);
                queue.enQueue(data);
                // Invokes the dequeue operation
            } else {
                System.out.println("Deleted " + queue.deQueue());
                
            }
        }
        
        System.out.println(queue);
        
    }
}
