package util;

import java.util.concurrent.Executor;

public class ThreadExecutor implements Executor {
	@Override
	public void execute(Runnable run) {
		Thread t = new Thread(run);
		t.start();
	}
}