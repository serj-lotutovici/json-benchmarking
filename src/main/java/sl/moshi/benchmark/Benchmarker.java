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

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
 * Benchmarks different approaches for parsing simple json objects
 *
 * @author Serj Lotutovici
 */
@SuppressWarnings("unused")
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class Benchmarker {

    private Moshi moshi;
    private Gson gson;
    private ObjectMapper objectMapper;

    @Setup(Level.Trial) public void setup() {
        moshi = new Moshi.Builder().build();
        gson = new Gson();
        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @Benchmark public RidiculouslyBigUser moshiReflection() throws IOException {
        try (InputStream is = getTestDataStream()) {
            BufferedSource dataSource = getSourceFromStream(is);
            JsonAdapter<RidiculouslyBigUser> userJsonAdapter = moshi.adapter(RidiculouslyBigUser.class);
            return userJsonAdapter.fromJson(dataSource);
        }
    }

    @Benchmark public RidiculouslyBigUser moshiStreaming() throws IOException {
        try (InputStream is = getTestDataStream()) {
            BufferedSource dataSource = getSourceFromStream(is);
            return new RbuMoshiStreamingParser().readJsonStream(dataSource);
        }
    }

    @Benchmark public RidiculouslyBigUser gsonReflection() throws IOException {
        try (InputStreamReader reader = new InputStreamReader(getTestDataStream())) {
            return gson.fromJson(reader, RidiculouslyBigUser.class);
        }
    }

    @Benchmark public RidiculouslyBigUser jacksonReflection() throws IOException {
        try (InputStream is = getTestDataStream()) {
            return objectMapper.readValue(is, RidiculouslyBigUser.class);
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
