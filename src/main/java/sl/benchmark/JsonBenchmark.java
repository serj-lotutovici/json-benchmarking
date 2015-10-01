package sl.benchmark;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/** Starts the benchmark runner. */
public class JsonBenchmark {
  public static void main(String[] args) throws RunnerException {
    int numberOfWarmups = 10;
    int numberOfIterations = numberOfWarmups;
    int numberOfForks = 1;

    try {
      numberOfIterations = Integer.parseInt(args[0]);
    } catch (Exception ignore) {
    }

    try {
      numberOfForks = Integer.parseInt(args[1]);
    } catch (Exception ignore) {
    }

    new Runner(
        new OptionsBuilder()
            .include(".*" + Benchmarker.class.getSimpleName() + ".*")
            .warmupIterations(numberOfWarmups)
            .measurementIterations(numberOfIterations)
            .forks(numberOfForks)
            .build()
    ).run();
  }
}
