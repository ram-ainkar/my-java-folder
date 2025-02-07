import java.util.*;
import java.util.LinkedList;
class Queue{
    static private int front, rear, capacity;
    static private int queue[];

    Queue(int c){
        front = rear = 0;
        capacity = c;
        queue = new int[capacity];

    }
    static void queueEnqueue(int data){
        if(capacity == rear){
            System.out.printf("\nQueue is full\n");
            return;
        } else{
            queue[rear] = data;
            rear++;
        }
        return;
    }
    static void queueDequeue(){
        if(front == rear){
            System.out.printf("\nQueue is empty");
            return;
        } else{
            if(rear < capacity){
                queue[rear] = 0;
            }
            rear--;
        }
        return;

    }
    static void queueDisplay(){
        int i;
        if(front == rear){
            System.out.printf("\nQueue is empty");

            return;
        }
        for(i = front; i<rear; i++){
            System.out.printf("%d <--" , queue[i]);

        }
        return;
    }
    static void queueFront(){
        if(front == rear){
            System.out.printf("\nQueue is Empty");
            return;

        }
        System.out.printf("\nFront Element is: %d", queue[front]);
        return;  
    }
}
public class Stack01{

       public static void main(String args[]){
        Queue q = new Queue(4);

        q.queueDisplay();

        q.queueEnqueue(20);
        q.queueEnqueue(30);
        q.queueEnqueue(40);
        q.queueEnqueue(50);

        q.queueDisplay();
        q.queueEnqueue( 60);
        q.queueDisplay();
        q.queueDequeue();
        q.queueDequeue();
        System.out.printf("\nAfter two node deletion\n\n");
        q.queueDisplay();
        q.queueFront();


        
       }

}

