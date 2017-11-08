package controller.protocolos.passoa;

import java.util.function.Consumer;

import javafx.concurrent.Task;

public class Donwload extends Task<String> {

	@Override
	protected String call() throws Exception {
		updateMessage("Establishing connection");
		DownloadHelper helper = new DownloadHelper(this::updateMessage);
		helper.performTask();
		return "MessageTest";
	}

	@Override
	protected void updateMessage(String message) {
		super.updateMessage(message);
	}
	
	private static class DownloadHelper {

		Consumer<String> updater;

		public DownloadHelper(Consumer<String> updater) {
			this.updater = updater;
		}

		public void performTask() {
			updater.accept("Helper message");
		}
	}
}


