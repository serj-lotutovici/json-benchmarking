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

import com.google.common.base.Stopwatch;
import com.squareup.moshi.Moshi;
import okio.BufferedSource;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

/**
 * Does the actual bench marking
 *
 * @author Serj Lotutovici
 */
public abstract class Benchmarker {

    private final String approachName;
    private final int iterate;

    protected Benchmarker(String approachName, int iterate) {
        this.approachName = approachName;
        this.iterate = iterate;
    }

    /**
     * Perform benchmarking for the implemented approach
     *
     * @param provider Data provider
     */
    public void performBenchmark(DataProvider provider) {
        log(System.out, "Start");

        double avg = 0.0d;
        for (int count = 1; count <= iterate; count++) {
            logProgress(count);

            try {
                BufferedSource dataSource = provider.getDataSource();
                Moshi moshi = provider.getMoshi();

                Stopwatch stopwatch = Stopwatch.createStarted();
                parse(dataSource, moshi);
                avg += stopwatch.stop().elapsed(TimeUnit.NANOSECONDS) / iterate;

            } catch (Exception ex) {
                log(System.err, ex.getMessage());
            } finally {
                System.gc();
            }
        }

        log(System.out, "Average time is: " + avg + " nanoseconds");
    }

    /** Perform the actual parsing. Should be implemented by every {@link Benchmarker} */
    protected abstract void parse(BufferedSource dataSource, Moshi moshi) throws Exception;

    /** Simple log */
    protected void log(PrintStream stream, String msg) {
        stream.println(String.format("\n[%s]: %s", approachName, msg));
    }

    /** Just show the progress in percents */
    private void logProgress(int progress) {
        int percentProgress = (progress * 100) / iterate;
        StringBuilder sb = new StringBuilder("\r[");
        for (int index = 1; index <= 100; index++) {
            sb.append(index <= percentProgress ? "=" : " ");
        }
        sb.append(String.format("] %d%%", percentProgress));
        System.out.print(sb.toString());
    }
}
