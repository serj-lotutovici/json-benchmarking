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

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import okio.BufferedSource;
import sl.moshi.benchmark.model.RidiculouslyBigUser;

/**
 * Simple entry point class
 *
 * @author Serj Lotutovici
 */
public class Benchmark {

    public static void main(String[] args) {
        // TODO Start benchmarking

        try {
            BenchmarkHelper benchmark = new BenchmarkHelper("test_data.json");
            BufferedSource dataSource = benchmark.getDataSource();
            Moshi moshi = benchmark.getMoshi();
            JsonAdapter<RidiculouslyBigUser> userJsonAdapter = moshi.adapter(RidiculouslyBigUser.class);
            userJsonAdapter.fromJson(dataSource);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}