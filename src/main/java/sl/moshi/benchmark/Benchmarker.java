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

import com.google.gson.Gson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import okio.BufferedSource;
import okio.Okio;
import org.openjdk.jmh.annotations.*;
import sl.moshi.benchmark.model.RidiculouslyBigUser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * Benchmarks the binding api of {@link Moshi}
 *
 * @author Serj Lotutovici
 */
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class Benchmarker {

    private Moshi moshi;
    private Gson gson;

    @Setup(Level.Trial) public void setupMoshi() {
        moshi = new Moshi.Builder().build();
        gson = new Gson();
    }

    @Benchmark public RidiculouslyBigUser moshiReflection() throws IOException {
        BufferedSource dataSource = getSourceFromStream(getTestDataStream());
        JsonAdapter<RidiculouslyBigUser> userJsonAdapter = moshi.adapter(RidiculouslyBigUser.class);
        return userJsonAdapter.fromJson(dataSource);
    }

    @Benchmark public RidiculouslyBigUser moshiStreaming() throws IOException {
        BufferedSource dataSource = getSourceFromStream(getTestDataStream());
        return new RbuMoshiStreamingParser().readJsonStream(dataSource);
    }

    @Benchmark public RidiculouslyBigUser gsonReflection() throws IOException {
        // Gson doesn't apparently doesn't close the stream
        try (InputStreamReader reader = new InputStreamReader(getTestDataStream())) {
            return gson.fromJson(reader, RidiculouslyBigUser.class);
        }
    }

    /** Creates a {@link okio.BufferedSource} from provided stream */
    BufferedSource getSourceFromStream(InputStream is) throws FileNotFoundException {
        return Okio.buffer(Okio.source(is));
    }

    /** Open the test data file stream */
    private InputStream getTestDataStream() {
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResourceAsStream("test_data.json");
    }
}
