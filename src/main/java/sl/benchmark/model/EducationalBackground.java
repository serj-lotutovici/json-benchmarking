package sl.benchmark.model;

import java.util.ArrayList;
import java.util.List;

public class EducationalBackground {

  public String degree;
  public School primary_school;
  public List<School> schools = new ArrayList<>();
  public List<String> qualifications = new ArrayList<>();

  @Override
  public String toString() {
    return "EducationalBackground{" +
        "degree='" + degree + '\'' +
        ", primary_school=" + primary_school +
        ", schools=" + schools +
        ", qualifications=" + qualifications +
        '}';
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

  public void setPrimarySchool(School primarySchool) {
    this.primary_school = primarySchool;
  }

  public void setSchools(List<School> schools) {
    this.schools = schools;
  }

  public void setQualifications(List<String> qualifications) {
    this.qualifications = qualifications;
  }
}