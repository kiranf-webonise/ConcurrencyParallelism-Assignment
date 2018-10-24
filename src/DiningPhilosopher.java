import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosopher {

	public static void main(String[] args) {
		Lock forks[] = new ReentrantLock[5];

		for(int i = 0; i<5; i++){
			forks[i] = new ReentrantLock(); 
		}

		Thread p1 = new Thread(new Philosopher(forks[4], forks[0], "Philosopher 1 "));
		Thread p2 = new Thread(new Philosopher(forks[0], forks[1], "Philosopher 2 "));
		Thread p3 = new Thread(new Philosopher(forks[1], forks[2], "Philosopher 3 "));
		Thread p4 = new Thread(new Philosopher(forks[2], forks[3], "Philosopher 4 "));
		Thread p5 = new Thread(new Philosopher(forks[3], forks[4], "Philosopher 5 "));

		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start(); 
  }
}