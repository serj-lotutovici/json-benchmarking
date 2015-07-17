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

/**
 * Simple entry point class
 *
 * @author Serj Lotutovici
 */
public class Benchmark {

    public static void main(String[] args) {
        try {
            DataProvider provider = new DataProvider("test_data.json");

            Benchmarker bindingBenchmarker = new BindingBenchmarker(1000);
            bindingBenchmarker.performBenchmark(provider);

            // Just make some space between outputs
            System.out.println();

            Benchmarker streamingBenchmarker = new StreamingBenchmarker(1000);
            streamingBenchmarker.performBenchmark(provider);

        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

}
