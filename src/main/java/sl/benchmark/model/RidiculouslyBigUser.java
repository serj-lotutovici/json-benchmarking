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

  @Override public String toString() {
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

  public void setId(String id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    this.first_name = firstName;
  }

  public void setLastName(String lastName) {
    this.last_name = lastName;
  }

  public void setDisplayName(String displayName) {
    this.display_name = displayName;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setBirthday(BirthDate birthday) {
    this.birth_date = birthday;
  }

  public void setPageName(String pageName) {
    this.page_name = pageName;
  }

  public void setPermalink(String permalink) {
    this.permalink = permalink;
  }

  public void setEmploymentStatus(String employmentStatus) {
    this.employment_status = employmentStatus;
  }

  public void setActiveEmail(String activeEmail) {
    this.active_email = activeEmail;
  }

  public void setPremiumServicesFromStringList(List<String> premiumServicesFromStringList) {
    this.premium_services = premiumServicesFromStringList;
  }

  public void setBadgesFromStringList(List<String> badgesFromStringList) {
    this.badges = badgesFromStringList;
  }

  public void setWants(String wants) {
    this.wants = wants;
  }

  public void setHaves(String haves) {
    this.haves = haves;
  }

  public void setInterests(String interests) {
    this.interests = interests;
  }

  public void setOrganisationMember(String organisationMember) {
    this.organisation_member = organisationMember;
  }

  public void setPrivateAddress(Address privateAddress) {
    this.private_address = privateAddress;
  }

  public void setBusinessAddress(Address businessAddress) {
    this.business_address = businessAddress;
  }

  public void setEducationBackground(EducationalBackground educationBackground) {
    this.educational_background = educationBackground;
  }

  public void setPhotoUrls(PhotoUrls photoUrls) {
    this.photo_urls = photoUrls;
  }

  public void setProfessionalExperience(ProfessionalExperience professionalExperience) {
    this.professional_experience = professionalExperience;
  }

  public void setTimeZone(TimeZone timeZone) {
    this.time_zone = timeZone;
  }

  public void setWebProfiels(WebProfiles webProfiels) {
    this.web_profiles = webProfiels;
  }

  public void setMessagingAccounts(InstantMessagingAccounts messagingAccounts) {
    this.instant_messaging_accounts = messagingAccounts;
  }

  public void setLanguages(Languages languages) {
    this.languages = languages;
  }
}
