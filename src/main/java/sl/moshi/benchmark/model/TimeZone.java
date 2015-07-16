
package sl.moshi.benchmark.model;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class TimeZone {

    public String name;
    public double utc_offset;

    @Override public String toString() {
        return "TimeZone{" +
                "name='" + name + '\'' +
                ", utc_offset=" + utc_offset +
                '}';
    }
}