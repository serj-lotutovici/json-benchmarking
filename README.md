###Simple java application that benchmarks different json parsing approaches.

**Current approaches tested:**
- [Gson](https://github.com/google/gson)
- [Jackson](https://github.com/FasterXML/jackson)
- [Moshi](https://github.com/square/moshi)
- [Moshi Streaming Api](https://github.com/square/moshi)

**Benchmark results:**
```
Benchmark                      Mode  Cnt    Score    Error  Units
Benchmarker.gsonReflection     avgt    5  122.125 ± 18.121  us/op
Benchmarker.jacksonReflection  avgt    5   79.761 ±  4.075  us/op
Benchmarker.moshiReflection    avgt    5  292.003 ±  8.144  us/op
Benchmarker.moshiStreaming     avgt    5  166.533 ± 10.475  us/op
```

**To run the application simply call:**
```
./gradlew run -Piterate=[number_of_iterations] // If 'iterate' is not provided 10 will be used as default
```