# Json parsers benchmarking

This is a simple benchmark example that compares different json parsing approaches and was done for the sake
of simply doing so. It doesn't claim and/or insist on being ultimately precisest or trust worthy.
Please use(reference) this code at your onw risk.

##Benchmark cases

**Current approaches tested:**
- [Gson data binding][gson]
- [Jackson data binding][jackson]
- [Moshi data binding][moshi]
- [Moshi streaming api][moshi]

**Benchmark results:**
```
Benchmark                      Mode  Cnt    Score    Error  Units
Benchmarker.gsonReflection     avgt    5  122.125 ± 18.121  us/op
Benchmarker.jacksonReflection  avgt    5   79.761 ±  4.075  us/op
Benchmarker.moshiReflection    avgt    5  292.003 ±  8.144  us/op
Benchmarker.moshiStreaming     avgt    5  166.533 ± 10.475  us/op
```

Source for json model is taken from [XING Developers API Example][xingdev]

##Run on your machine
```
./gradlew run -Piterate=[number_of_iterations] // If 'iterate' is not provided 10 will be used as default
```
##Used tools
This code uses [JMH][jmh] for benchmarking results. Special thanks to [Jesse Wilson][jw] for introducing me to
this tool.

##License
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
    TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
    THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
    OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
    OTHER DEALINGS IN THE SOFTWARE.

[gson]: https://github.com/google/gson
[jackson]: https://github.com/FasterXML/jackson
[moshi]: https://github.com/square/moshi
[xingdev]: https://dev.xing.com/docs/resources
[jmh]: http://openjdk.java.net/projects/code-tools/jmh/
[jw]: https://github.com/swankjesse