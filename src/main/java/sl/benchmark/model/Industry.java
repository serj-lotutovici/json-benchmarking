package sl.benchmark.model;

public class Industry {

  public int id;
  public String localized_name;

  @Override
  public String toString() {
    return "Industry{" +
        "id=" + id +
        ", localized_name='" + localized_name + '\'' +
        '}';
  }
}