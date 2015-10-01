package sl.benchmark.model;

public class School {

  public String id;
  public String name;
  public String degree;
  public String notes;
  public String subject;
  public String begin_date;
  public String end_date;

  @Override
  public String toString() {
    return "School{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", degree='" + degree + '\'' +
        ", notes='" + notes + '\'' +
        ", subject='" + subject + '\'' +
        ", begin_date='" + begin_date + '\'' +
        ", end_date='" + end_date + '\'' +
        '}';
  }
}