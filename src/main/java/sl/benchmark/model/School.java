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

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public void setBeginDate(String beginDate) {
    this.begin_date = beginDate;
  }

  public void setEndDate(String endDate) {
    this.end_date = endDate;
  }
}