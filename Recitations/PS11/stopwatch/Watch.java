package myclock;

public class Watch {
	int mins;
	int secs;
	int step;

	String allStr;

	public Watch(int step) {
		mins = 0;
		secs = 0;
		this.step = step;
		allStr = " 00:00";
	}

	public void stepUp() {
		secs = secs + step;
		if (secs == 60) { 
			mins = (mins + 1) % 60;
			secs = 0;
		}
		if (mins >= 15) mins = mins - 15;
		String minsStr = String.valueOf(mins);
		String secsStr = String.valueOf(secs);

		if (mins < 10) minsStr = "0" + minsStr;
		if (secs < 10) secsStr = "0" + secsStr;

		allStr = " " + minsStr + ":" + secsStr;
		System.out.println(allStr);
	}

	public void reset() {
		mins = 0;
		secs = 0;
		allStr = " 00:00";
		System.out.println(allStr);
	}
}
