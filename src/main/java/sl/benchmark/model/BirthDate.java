package sl.benchmark.model;

public class BirthDate {

  public int day;
  public int month;
  public int year;

  @Override
  public String toString() {
    return "BirthDate{" +
        "day=" + day +
        ", month=" + month +
        ", year=" + year +
        '}';
  }

  public void setDay(int day) {
    this.day = day;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public void setYear(int year) {
    this.year = year;
  }
}
