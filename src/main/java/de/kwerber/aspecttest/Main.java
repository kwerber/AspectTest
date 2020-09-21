package de.kwerber.aspecttest;

import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Timer;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// Check if -javaagent vm option exists
		RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
		List<String> arguments = runtimeMxBean.getInputArguments();
		System.out.println(arguments);

		// Setup registry & timer
		var prometheusRegistry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
		Metrics.globalRegistry.add(prometheusRegistry);

		Timer timer = Timer.builder("main-timer")
			.register(Metrics.globalRegistry);

		// Run task
		Task task = new Task();
		timer.record(task::run);

		// Print registry output
		System.out.println("Finished.\n");
		System.out.println(prometheusRegistry.scrape());
	}

}
