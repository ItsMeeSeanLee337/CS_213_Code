package myclock;

public class StopWatchThread implements Runnable {

	private int delay;
	
	public boolean reset = false;
	public boolean stop = false;
	
	public long startTime; 

	private Watch w;
	
	public StopWatchThread(int step) {
		w = new Watch(step);
		delay = step*1000;  // delay in milliseconds
	}
	
	public void run() {
		
		startTime = System.currentTimeMillis();
		
		while (true) {
			
			if (stop) {
				break;
			}
			
			if (reset){
				w.reset();
				reset = false;
			}
			
			startTime += delay;
			try {
				Thread.sleep(Math.max(0, startTime - System.currentTimeMillis()));
				w.stepUp();
			} catch (InterruptedException e) { }
			
		}
	}
}

