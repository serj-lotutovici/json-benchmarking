package sl.benchmark.model;

import android.net.Uri;
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

  public void setName(String name) {
    this.name = name;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setBeginDate(String beginDate) {
    this.begin_date = beginDate;
  }

  public void setCareerLevel(String careerLevel) {
    this.career_level = careerLevel;
  }

  public void setCompanySize(String companySize) {
    this.company_size = companySize;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setEndDate(String endDate) {
    this.end_date = endDate;
  }

  public void setFormOfEmployment(String formOfEmployment) {
    this.form_of_employment = formOfEmployment;
  }

  public void setIndustries(List<Industry> industries) {
    this.industries = industries;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setUntilNow(boolean untilNow) {
    this.until_now = untilNow;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }
}
