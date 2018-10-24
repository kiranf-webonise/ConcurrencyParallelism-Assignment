import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Runnable {

Lock leftFork = new ReentrantLock();
Lock rightFork = new ReentrantLock();
String name; 

public Philosopher(Lock leftFork, Lock rightFork, String name) {
    this.leftFork = leftFork;
    this.rightFork = rightFork;
    this.name = name; 
}

public void run() {

    while(true){
    think(name);
    eat(leftFork, rightFork, name); 
    }
}

private void eat(Lock leftFork, Lock rightFork, String name){
	leftFork.lock();
    rightFork.lock(); 

    System.out.println(name + " has picked left and right fork");

    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
                e.printStackTrace();
    } 
    finally{
        leftFork.unlock();
        rightFork.unlock(); 
        System.out.println(name + " has put down left and right fork");
    }
}

private void think(String name){
    System.out.println(name + " is now Thinking");

    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {
        e.printStackTrace();
    } 
}
}