
package sl.moshi.benchmark.model;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class EducationalBackground {

    public String degree;
    public School primary_school;
    public List<School> schools = new ArrayList<>();
    public List<String> qualifications = new ArrayList<>();

    @Override public String toString() {
        return "EducationalBackground{" +
                "degree='" + degree + '\'' +
                ", primary_school=" + primary_school +
                ", schools=" + schools +
                ", qualifications=" + qualifications +
                '}';
    }
}