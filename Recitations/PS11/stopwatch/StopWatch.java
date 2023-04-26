package myclock;

/**
 * Use threads to implement a stop watch that displays, 
 * once every five seconds, the minutes and seconds that 
 * have passed since it was started. The display should be 
 * in the form mm:ss for minutes and seconds. When the clock 
 * reaches 15 minutes, it should wrap back and start at 0 
 * minutes and 0 seconds. The user should be able to stop the 
 * watch at any time. Write the complete code for the application. (
 * Not the most accurate stop watch, but the model is useful for 
 * animations in which slight inaccuracies in time would not be 
 * detrimental.) 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StopWatch {

	public static int STEP=5;
	
	public static void main(String[] args) {
		
		System.out.println("Stopwatch");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Step? (secs): ");
		int step;
		try {
			step = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			step = STEP;
		}
		
		StopWatchThread s = new StopWatchThread(step);
		Thread stopWatchThread = new Thread(s);
		stopWatchThread.start();
		
		String command;
		boolean quit=false;
		
		do {
			try {
				command = br.readLine().toLowerCase();
			} catch (IOException e) {
				command = "unknown";
			}
			switch (command) {
			case ("p"):
				System.out.println("Pause");
				s.stop = true;
				stopWatchThread.interrupt();
				break;
			case ("t"):
				System.out.println("Reset");
				s.reset = true;
				stopWatchThread.interrupt();
				break;
			case ("r"):
				System.out.println("Resume");
				s.stop = false;
				stopWatchThread = new Thread(s);
				stopWatchThread.start();
				break;
			case ("q"): 
				System.out.println("Quit");
				s.stop = true;
				quit = true;
				stopWatchThread.interrupt();  
			}
		} while (!quit);		
		
		/* If the thread is in the sleep state (timed wait), the interrupts above will get it out
		 * of that state with an exception, and the watch step up will be bypassed. 
		 */
	}
}






