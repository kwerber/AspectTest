package de.kwerber.aspecttest;

import io.micrometer.core.annotation.Timed;

public class Task {

	@Timed
	public void run() {
		System.out.println("Starting task...");

		innerRun();

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		innerRun();

		System.out.println("Task finished.");
	}

	@Timed
	private void innerRun() {

	}

}
