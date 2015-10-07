package sl.benchmark.model;

public class Award {

  public String name;
  public int date_awarded;
  public String url;

  @Override
  public String toString() {
    return "Award{" +
        "name='" + name + '\'' +
        ", date_awarded=" + date_awarded +
        ", url='" + url + '\'' +
        '}';
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setDateAwarded(int dateAwarded) {
    this.date_awarded = dateAwarded;
  }
}
