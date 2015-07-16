
package sl.moshi.benchmark.model;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Award {

    public String name;
    public int date_awarded;
    public String url;

    @Override public String toString() {
        return "Award{" +
                "name='" + name + '\'' +
                ", date_awarded=" + date_awarded +
                ", url='" + url + '\'' +
                '}';
    }
}
