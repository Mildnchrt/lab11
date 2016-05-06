package tasktimer;

public class StopWatch {
	private long starttime;
	private long stoptime;
	private boolean running;
	/**
	 * create time when start
	 */
	public void start() {
		starttime = System.nanoTime();
	}
	/**
	 * create time when stop
	 */
	public void stop() {
		stoptime = System.nanoTime();
	}
	/**
	 * calculate elapse time.
	 * @return elapse time
	 */
	public double getElapsed() {
		return (stoptime - starttime)*1.0E-9;
	}
}
