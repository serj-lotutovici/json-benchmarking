package sl.benchmark.model;

public class TimeZone {

  public String name;
  public double utc_offset;

  @Override
  public String toString() {
    return "TimeZone{" +
        "name='" + name + '\'' +
        ", utc_offset=" + utc_offset +
        '}';
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setUtcOffset(double utcOffset) {
    this.utc_offset = utcOffset;
  }
}