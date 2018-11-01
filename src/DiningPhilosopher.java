import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosopher {
	private static final int PHILOSOPHERS = 5;
	public static void main(String[] args) {
		Lock forks[] = new ReentrantLock[PHILOSOPHERS];
		for(int count = 0; count<PHILOSOPHERS; count++){
			forks[count] = new ReentrantLock(); 
		}

		Thread philosopher1 = new Thread(new Philosopher(forks[4], forks[0], "Philosopher 1 "));
		Thread philosopher2 = new Thread(new Philosopher(forks[0], forks[1], "Philosopher 2 "));
		Thread philosopher3 = new Thread(new Philosopher(forks[1], forks[2], "Philosopher 3 "));
		Thread philosopher4 = new Thread(new Philosopher(forks[2], forks[3], "Philosopher 4 "));
		Thread philosopher5 = new Thread(new Philosopher(forks[3], forks[4], "Philosopher 5 "));

		philosopher1.start();
		philosopher2.start();
		philosopher3.start();
		philosopher4.start();
		philosopher5.start();
	}
}