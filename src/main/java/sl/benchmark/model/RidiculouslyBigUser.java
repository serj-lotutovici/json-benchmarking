package sl.benchmark.model;

import java.util.ArrayList;
import java.util.List;

public class RidiculouslyBigUser {

  public String id;
  public String first_name;
  public String last_name;
  public String display_name;
  public String page_name;
  public String permalink;
  public String employment_status;
  public String gender;
  public BirthDate birth_date;
  public String active_email;
  public TimeZone time_zone;
  public List<String> premium_services = new ArrayList<>();
  public List<String> badges = new ArrayList<>();
  public String wants;
  public String haves;
  public String interests;
  public String organisation_member;
  public Languages languages;
  public Address private_address;
  public Address business_address;
  public WebProfiles web_profiles;
  public InstantMessagingAccounts instant_messaging_accounts;
  public ProfessionalExperience professional_experience;
  public EducationalBackground educational_background;
  public PhotoUrls photo_urls;

  @Override
  public String toString() {
    return "RidiculouslyBigUser{" +
        "id='" + id + '\'' +
        ", first_name='" + first_name + '\'' +
        ", last_name='" + last_name + '\'' +
        ", display_name='" + display_name + '\'' +
        ", page_name='" + page_name + '\'' +
        ", permalink='" + permalink + '\'' +
        ", employment_status='" + employment_status + '\'' +
        ", gender='" + gender + '\'' +
        ", birth_date=" + birth_date +
        ", active_email='" + active_email + '\'' +
        ", time_zone=" + time_zone +
        ", premium_services=" + premium_services +
        ", badges=" + badges +
        ", wants='" + wants + '\'' +
        ", haves='" + haves + '\'' +
        ", interests='" + interests + '\'' +
        ", organisation_member='" + organisation_member + '\'' +
        ", languages=" + languages +
        ", private_address=" + private_address +
        ", business_address=" + business_address +
        ", web_profiles=" + web_profiles +
        ", instant_messaging_accounts=" + instant_messaging_accounts +
        ", professional_experience=" + professional_experience +
        ", educational_background=" + educational_background +
        ", photo_urls=" + photo_urls +
        '}';
  }
}
