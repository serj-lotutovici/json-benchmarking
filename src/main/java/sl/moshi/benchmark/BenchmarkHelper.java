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

import com.squareup.moshi.Moshi;
import okio.BufferedSource;
import okio.Okio;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Provided methods for acquiring the data source and some additional helper methods
 *
 * @author Serj Lotutovici
 */
public class BenchmarkHelper {

    private final String fileName;
    private final Moshi moshi;

    public BenchmarkHelper(String fileName) {
        this.fileName = fileName;
        this.moshi = new Moshi.Builder().build();
    }

    /** Opens a file from the resource folder and returns it's {@link okio.Source} */
    BufferedSource getDataSource() throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream is = classLoader.getResourceAsStream(fileName);
        return Okio.buffer(Okio.source(is));
    }

    Moshi getMoshi() {
        return moshi;
    }
}
