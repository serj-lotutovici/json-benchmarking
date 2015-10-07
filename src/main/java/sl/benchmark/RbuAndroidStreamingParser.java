package sl.benchmark;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import sl.benchmark.model.Address;
import sl.benchmark.model.Award;
import sl.benchmark.model.BirthDate;
import sl.benchmark.model.Company;
import sl.benchmark.model.EducationalBackground;
import sl.benchmark.model.Industry;
import sl.benchmark.model.InstantMessagingAccounts;
import sl.benchmark.model.Languages;
import sl.benchmark.model.PhotoUrls;
import sl.benchmark.model.ProfessionalExperience;
import sl.benchmark.model.RidiculouslyBigUser;
import sl.benchmark.model.School;
import sl.benchmark.model.TimeZone;
import sl.benchmark.model.WebProfiles;

/**
 * {@link RidiculouslyBigUser} parser implementation using android's {@link JsonReader} api.
 * The benchmark for this is not as reliable as for other parsers, because it relays on
 * an android jar to be added as a dependency.
 *
 * @author Serj Lotutovici
 */
final class RbuAndroidStreamingParser {
  public static RidiculouslyBigUser parseUser(JsonReader reader) throws IOException {
    RidiculouslyBigUser user = new RidiculouslyBigUser();
    reader.beginObject();
    while (reader.hasNext()) {
      String name = reader.nextName();
      if (isNextTokenNull(reader)) {
        reader.nextNull();
      } else {
        switch (name) {
          case "id": {
            user.setId(reader.nextString());
            break;
          }
          case "first_name": {
            user.setFirstName(reader.nextString());
            break;
          }
          case "last_name": {
            user.setLastName(reader.nextString());
            break;
          }
          case "display_name": {
            user.setDisplayName(reader.nextString());
            break;
          }
          case "gender": {
            user.setGender(reader.nextString());
            break;
          }
          case "birth_date": {
            user.setBirthday(parseBirthDate(reader));
            break;
          }
          case "page_name": {
            user.setPageName(reader.nextString());
            break;
          }
          case "permalink": {
            user.setPermalink(reader.nextString());
            break;
          }
          case "employment_status": {
            user.setEmploymentStatus(reader.nextString());
            break;
          }
          case "active_email": {
            user.setActiveEmail(reader.nextString());
            break;
          }
          case "premium_services": {
            user.setPremiumServicesFromStringList(parseStringList(reader));
            break;
          }
          case "badges": {
            user.setBadgesFromStringList(parseStringList(reader));
            break;
          }
          case "wants": {
            user.setWants(reader.nextString());
            break;
          }
          case "haves": {
            user.setHaves(reader.nextString());
            break;
          }
          case "interests": {
            user.setInterests(reader.nextString());
            break;
          }
          case "organisation_member": {
            user.setOrganisationMember(reader.nextString());
            break;
          }
          case "private_address": {
            user.setPrivateAddress(parseAddress(reader));
            break;
          }
          case "business_address": {
            user.setBusinessAddress(parseAddress(reader));
            break;
          }
          case "educational_background": {
            user.setEducationBackground(parseEducationalBackground(reader));
            break;
          }
          case "photo_urls": {
            user.setPhotoUrls(parsePhotoUrls(reader));
            break;
          }
          case "professional_experience": {
            user.setProfessionalExperience(parseProfessionalExperience(reader));
            break;
          }
          case "time_zone": {
            user.setTimeZone(parseTimeZone(reader));
            break;
          }
          case "web_profiles": {
            user.setWebProfiels(parseWebProfiles(reader));
            break;
          }
          case "instant_messaging_accounts": {
            user.setMessagingAccounts(parseMessagingAccounts(reader));
            break;
          }
          case "languages": {
            user.setLanguages(parseLanguages(reader));
            break;
          }
          default:
            reader.skipValue();
        }
      }
    }
    reader.endObject();
    return user;
  }

  private static BirthDate parseBirthDate(JsonReader reader) throws IOException {
    BirthDate birthDate = new BirthDate();
    reader.beginObject();
    while (reader.hasNext()) {
      switch (reader.nextName()) {
        case "day": {
          if (isNextTokenNull(reader)) {
            reader.nextNull();
          } else {
            birthDate.setDay(reader.nextInt());
          }
        }
        break;
        case "month": {
          if (isNextTokenNull(reader)) {
            reader.nextNull();
          } else {
            birthDate.setMonth(reader.nextInt());
          }
        }
        break;
        case "year": {
          if (isNextTokenNull(reader)) {
            reader.nextNull();
          } else {
            birthDate.setYear(reader.nextInt());
          }
        }
        break;
        default: {
          reader.skipValue();
        }
      }
    }
    reader.endObject();
    return birthDate;
  }

  private static WebProfiles parseWebProfiles(JsonReader reader) throws IOException {
    WebProfiles webProfiles = new WebProfiles();
    reader.beginObject();

    while (reader.hasNext()) {
      String name = reader.nextName();

      if (isNextTokenNull(reader)) {
        reader.nextNull();
        continue;
      }

      if ("qype".equals(name)) {
        webProfiles.qype = parseStringList(reader);
      } else if ("google+".equals(name)) {
        webProfiles.google = parseStringList(reader);
      } else if ("other".equals(name)) {
        webProfiles.other = parseStringList(reader);
      } else if ("homepage".equals(name)) {
        webProfiles.homepage = parseStringList(reader);
      } else {
        reader.skipValue();
      }
    }

    reader.endObject();
    return webProfiles;
  }

  private static InstantMessagingAccounts parseMessagingAccounts(JsonReader reader)
      throws IOException {
    InstantMessagingAccounts instantMessagingAccounts = new InstantMessagingAccounts();
    reader.beginObject();

    while (reader.hasNext()) {
      String name = reader.nextName();

      if (isNextTokenNull(reader)) {
        reader.nextNull();
        continue;
      }

      if ("skype".equals(name)) {
        instantMessagingAccounts.skype = reader.nextString();
      } else if ("googletalk".equals(name)) {
        instantMessagingAccounts.googletalk = reader.nextString();
      } else {
        reader.skipValue();
      }
    }

    reader.endObject();
    return instantMessagingAccounts;
  }

  private static Languages parseLanguages(JsonReader reader) throws IOException {
    Languages languages = new Languages();
    reader.beginObject();

    while (reader.hasNext()) {
      String name = reader.nextName();

      if (isNextTokenNull(reader)) {
        reader.nextNull();
        continue;
      }

      if ("de".equals(name)) {
        languages.de = reader.nextString();
      } else if ("en".equals(name)) {
        languages.en = reader.nextString();
      } else if ("fr".equals(name)) {
        languages.fr = reader.nextString();
      } else if ("zh".equals(name)) {
        languages.zh = reader.nextString();
      } else {
        reader.skipValue();
      }
    }

    reader.endObject();
    return languages;
  }

  private static Address parseAddress(JsonReader reader) throws IOException {
    Address address = new Address();
    reader.beginObject();
    while (reader.hasNext()) {
      switch (reader.nextName()) {
        case "email": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            address.setEmail(reader.nextString());
          }
          break;
        }
        case "city": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            address.setCity(reader.nextString());
          }
          break;
        }
        case "country": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            address.setCountry(reader.nextString());
          }
          break;
        }
        case "fax": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            String rawFax = reader.nextString();
            address.setFax(rawFax);
          }
          break;
        }
        case "mobile_phone": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            final String rawMobilePhone = reader.nextString();
            address.setMobilePhone(rawMobilePhone);
          }
          break;
        }
        case "phone": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            final String rawPhone = reader.nextString();
            address.setPhone(rawPhone);
          }
          break;
        }
        case "province": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            address.setProvince(reader.nextString());
          }
          break;
        }
        case "street": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            address.setStreet(reader.nextString());
          }
          break;
        }
        case "zip_code": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            address.setZipCode(reader.nextString());
          }
          break;
        }
        default:
          reader.skipValue();
      }
    }
    reader.endObject();
    return address;
  }

  private static Award parseAward(JsonReader reader) throws IOException {
    Award award = new Award();
    reader.beginObject();
    while (reader.hasNext()) {
      switch (reader.nextName()) {
        case "name": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            award.setName(reader.nextString());
          }
          break;
        }
        case "url": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            award.setUrl(reader.nextString());
          }
          break;
        }
        case "date_awarded": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            award.setDateAwarded(reader.nextInt());
          }
          break;
        }
        default:
          reader.skipValue();
      }
    }
    reader.endObject();
    return award;
  }

  private static List<Award> parseAwardList(JsonReader reader) throws IOException {
    List<Award> awardList = new ArrayList<>(0);
    reader.beginArray();
    while (reader.hasNext()) {
      awardList.add(parseAward(reader));
    }
    reader.endArray();
    return awardList;
  }

  private static Company parseExperienceCompany(JsonReader reader) throws IOException {
    Company company = new Company();
    reader.beginObject();
    while (reader.hasNext()) {
      switch (reader.nextName()) {
        case "name": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            company.setName(reader.nextString());
          }
          break;
        }
        case "id": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            company.setId(reader.nextString());
          }
          break;
        }
        case "begin_date": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            company.setBeginDate(reader.nextString());
          }
          break;
        }
        case "career_level": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            company.setCareerLevel(reader.nextString());
          }
          break;
        }
        case "company_size": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            company.setCompanySize(reader.nextString());
          }
          break;
        }
        case "description": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            company.setDescription(reader.nextString());
          }
          break;
        }
        case "end_date": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            company.setEndDate(reader.nextString());
          }
          break;
        }
        case "form_of_employment": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            company.setFormOfEmployment(reader.nextString());
          }
          break;
        }
        case "industries": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            company.setIndustries(parseIndustries(reader));
          }
          break;
        }
        case "title": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            company.setTitle(reader.nextString());
          }
          break;
        }
        case "until_now": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            company.setUntilNow(reader.nextBoolean());
          }
          break;
        }
        case "url": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            company.setUrl(reader.nextString());
          }
          break;
        }
        case "tag": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            company.setTag(reader.nextString());
          }
          break;
        }
        default:
          reader.skipValue();
      }
    }
    reader.endObject();
    return company;
  }

  private static List<Industry> parseIndustries(JsonReader reader) throws IOException {
    List<Industry> industries = new ArrayList<>();
    reader.beginArray();

    if (reader.peek() == JsonToken.BEGIN_OBJECT) {
      reader.beginObject();

      Industry industry = new Industry();
      reader.nextName();
      industry.id = reader.nextInt();
      reader.nextName();
      industry.localized_name = reader.nextString();
      industries.add(industry);

      reader.endObject();
    }

    reader.endArray();
    return industries;
  }

  private static List<Company> parseCompanies(JsonReader reader) throws IOException {
    List<Company> companies = new ArrayList<>();
    reader.beginArray();

    while (reader.hasNext()) {
      companies.add(parseExperienceCompany(reader));
    }

    reader.endArray();
    return companies;
  }

  private static EducationalBackground parseEducationalBackground(JsonReader reader)
      throws IOException {
    EducationalBackground background = new EducationalBackground();
    reader.beginObject();
    while (reader.hasNext()) {
      switch (reader.nextName()) {
        case "degree": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            background.setDegree(reader.nextString());
          }
          break;
        }
        case "primary_school": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            background.setPrimarySchool(parseSchool(reader));
          }
          break;
        }
        case "schools": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            background.setSchools(parseSchoolList(reader));
          }
          break;
        }
        case "qualifications": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            background.setQualifications(parseStringList(reader));
          }
          break;
        }
        default:
          reader.skipValue();
      }
    }
    reader.endObject();
    return background;
  }

  private static PhotoUrls parsePhotoUrls(JsonReader reader) throws IOException {
    PhotoUrls urls = new PhotoUrls();
    reader.beginObject();
    while (reader.hasNext()) {
      switch (reader.nextName()) {
        case "large": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            urls.setPhotoLargeUrl(reader.nextString());
          }
          break;
        }
        case "maxi_thumb": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            urls.setPhotoMaxiThumbUrl(reader.nextString());
          }
          break;
        }
        case "medium_thumb": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            urls.setPhotoMediumThumbUrl(reader.nextString());
          }
          break;
        }
        case "mini_thumb": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            urls.setPhotoMiniThumbUrl(reader.nextString());
          }
          break;
        }
        case "thumb": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            urls.setPhotoThumbUrl(reader.nextString());
          }
          break;
        }
        case "size_32x32": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            urls.setPhotoSize32Url(reader.nextString());
          }
          break;
        }
        case "size_48x48": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            urls.setPhotoSize48Url(reader.nextString());
          }
          break;
        }
        case "size_64x64": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            urls.setPhotoSize64Url(reader.nextString());
          }
          break;
        }
        case "size_96x96": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            urls.setPhotoSize96Url(reader.nextString());
          }
          break;
        }
        case "size_128x128": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            urls.setPhotoSize128Url(reader.nextString());
          }
          break;
        }
        case "size_192x192": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            urls.setPhotoSize192Url(reader.nextString());
          }
          break;
        }
        case "size_256x256": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            urls.setPhotoSize256Url(reader.nextString());
          }
          break;
        }
        case "size_1024x1024": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            urls.setPhotoSize1024Url(reader.nextString());
          }
          break;
        }
        case "size_original": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            urls.setPhotoSizeOriginalUrl(reader.nextString());
          }
          break;
        }
        default:
          reader.skipValue();
      }
    }
    reader.endObject();
    return urls;
  }

  private static ProfessionalExperience parseProfessionalExperience(JsonReader reader)
      throws IOException {
    ProfessionalExperience experience = new ProfessionalExperience();
    reader.beginObject();
    while (reader.hasNext()) {
      switch (reader.nextName()) {
        case "primary_company": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            experience.setPrimaryCompany(parseExperienceCompany(reader));
          }
          break;
        }
        case "companies": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            experience.setCompanies(parseCompanies(reader));
          }
          break;
        }
        case "awards": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            experience.setAwards(parseAwardList(reader));
          }
          break;
        }
        default:
          reader.skipValue();
      }
    }
    reader.endObject();
    return experience;
  }

  private static School parseSchool(JsonReader reader) throws IOException {
    School school = new School();
    reader.beginObject();
    while (reader.hasNext()) {
      switch (reader.nextName()) {
        case "id": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            school.setId(reader.nextString());
          }
          break;
        }
        case "name": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            school.setName(reader.nextString());
          }
          break;
        }
        case "degree": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            school.setDegree(reader.nextString());
          }
          break;
        }
        case "notes": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            school.setNotes(reader.nextString());
          }
          break;
        }
        case "subject": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            school.setSubject(reader.nextString());
          }
          break;
        }
        case "begin_date": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            school.setBeginDate(reader.nextString());
          }
          break;
        }
        case "end_date": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            school.setEndDate(reader.nextString());
          }
          break;
        }
        default:
          reader.skipValue();
      }
    }
    reader.endObject();
    return school;
  }

  private static List<School> parseSchoolList(JsonReader reader) throws IOException {
    List<School> schoolList = new ArrayList<>(0);
    reader.beginArray();
    while (reader.hasNext()) {
      schoolList.add(parseSchool(reader));
    }
    reader.endArray();
    return schoolList;
  }

  private static TimeZone parseTimeZone(JsonReader reader) throws IOException {
    TimeZone timeZone = new TimeZone();
    reader.beginObject();
    while (reader.hasNext()) {
      switch (reader.nextName()) {
        case "name": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            timeZone.setName(reader.nextString());
          }
          break;
        }
        case "utc_offset": {
          if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
          } else {
            timeZone.setUtcOffset(reader.nextDouble());
          }
          break;
        }
        default:
          reader.skipValue();
      }
    }
    reader.endObject();
    return timeZone;
  }

  private static List<String> parseStringList(JsonReader reader) throws IOException {
    List<String> stringList = new ArrayList<>(0);
    reader.beginArray();
    while (reader.hasNext()) {
      stringList.add(reader.nextString());
    }
    reader.endArray();
    return stringList;
  }

  private static boolean isNextTokenNull(JsonReader reader) throws IOException {
    return reader.peek() == JsonToken.NULL;
  }

  private RbuAndroidStreamingParser() {
    throw new AssertionError("No instances.");
  }
}
