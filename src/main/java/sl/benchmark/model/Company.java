package sl.benchmark.model;

import java.util.ArrayList;
import java.util.List;

public class Company {

  public String id;
  public String name;
  public String title;
  public String company_size;
  public String tag;
  public String url;
  public String career_level;
  public String begin_date;
  public String description;
  public String end_date;
  public String industry;
  public List<Industry> industries = new ArrayList<>();
  public String form_of_employment;
  public boolean until_now;
  public Discipline discipline;

  @Override
  public String toString() {
    return "Company{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", title='" + title + '\'' +
        ", company_size='" + company_size + '\'' +
        ", tag='" + tag + '\'' +
        ", url='" + url + '\'' +
        ", career_level='" + career_level + '\'' +
        ", begin_date='" + begin_date + '\'' +
        ", description='" + description + '\'' +
        ", end_date='" + end_date + '\'' +
        ", industry='" + industry + '\'' +
        ", industries=" + industries +
        ", form_of_employment='" + form_of_employment + '\'' +
        ", until_now=" + until_now +
        ", discipline=" + discipline +
        '}';
  }
}
