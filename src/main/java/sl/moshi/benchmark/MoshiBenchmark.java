/*
 * Copyright (C) 2015 Serghei (Serj) Lotutovici
 * Copyright (C) 2015 Konstantin Tarasenko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sl.moshi.benchmark;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Starts the benchmark runner
 *
 * @author Serj Lotutovici
 */
public class MoshiBenchmark {

    public static void main(String[] args) throws RunnerException {

        // Read the number of iterations per benchmark
        // By default should be 10
        int numberOfIterations = 10;
        if (args != null && args.length == 1) {
            try {
                numberOfIterations = Integer.parseInt(args[0]);
            } catch (Exception ignore) {
            }
        }

        new Runner(
                new OptionsBuilder()
                        .include(".*" + Benchmarker.class.getSimpleName() + ".*")
                        .warmupIterations(numberOfIterations)
                        .measurementIterations(numberOfIterations)
                        .forks(0)
                        .build()
        ).run();
    }
}
