
package sl.moshi.benchmark.model;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class WebProfiles {

    public List<String> qype = new ArrayList<>();
    public List<String> google_ = new ArrayList<>();
    public List<String> other = new ArrayList<>();
    public List<String> homepage = new ArrayList<>();

    @Override public String toString() {
        return "WebProfiles{" +
                "qype=" + qype +
                ", google_=" + google_ +
                ", other=" + other +
                ", homepage=" + homepage +
                '}';
    }
}