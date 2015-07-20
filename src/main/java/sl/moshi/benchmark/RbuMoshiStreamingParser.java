/*
 * Copyright (C) 2015 Serghei (Serj) Lotutovici
 * Copyright (C) 2015 Konstantin Tarasenko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sl.moshi.benchmark;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.Moshi;
import okio.BufferedSource;
import sl.moshi.benchmark.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link RidiculouslyBigUser} parser implementation using {@link Moshi} streaming api
 *
 * @author Serj Lotutovici
 */
public class RbuMoshiStreamingParser {

    public RidiculouslyBigUser readJsonStream(BufferedSource source) throws IOException {
        try (JsonReader reader = new JsonReader(source)) {
            return readUser(reader);
        }
    }

    private RidiculouslyBigUser readUser(JsonReader reader) throws IOException {
        RidiculouslyBigUser user = new RidiculouslyBigUser();

        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (reader.peek() == JsonReader.Token.NULL) {
                reader.nextNull();
                continue;
            }

            if ("id".equals(name)) {
                user.id = reader.nextString();
            } else if ("first_name".equals(name)) {
                user.first_name = reader.nextString();
            } else if ("last_name".equals(name)) {
                user.last_name = reader.nextString();
            } else if ("display_name".equals(name)) {
                user.display_name = reader.nextString();
            } else if ("page_name".equals(name)) {
                user.page_name = reader.nextString();
            } else if ("permalink".equals(name)) {
                user.permalink = reader.nextString();
            } else if ("employment_status".equals(name)) {
                user.employment_status = reader.nextString();
            } else if ("gender".equals(name)) {
                user.gender = reader.nextString();
            } else if ("birth_date".equals(name)) {
                user.birth_date = readBirthDate(reader);
            } else if ("active_email".equals(name)) {
                user.active_email = reader.nextString();
            } else if ("time_zone".equals(name)) {
                user.time_zone = readTimeZone(reader);
            } else if ("premium_services".equals(name)) {
                user.premium_services = readStringArray(reader);
            } else if ("badges".equals(name)) {
                user.badges = readStringArray(reader);
            } else if ("wants".equals(name)) {
                user.wants = reader.nextString();
            } else if ("haves".equals(name)) {
                user.haves = reader.nextString();
            } else if ("interests".equals(name)) {
                user.interests = reader.nextString();
            } else if ("organisation_member".equals(name)) {
                user.organisation_member = reader.nextString();
            } else if ("languages".equals(name)) {
                user.languages = readLanguages(reader);
            } else if ("private_address".equals(name)) {
                user.private_address = readAddress(reader);
            } else if ("business_address".equals(name)) {
                user.business_address = readAddress(reader);
            } else if ("web_profiles".equals(name)) {
                user.web_profiles = readWebProfiles(reader);
            } else if ("instant_messaging_accounts".equals(name)) {
                user.instant_messaging_accounts = readMessagingAccounts(reader);
            } else if ("professional_experience".equals(name)) {
                user.professional_experience = readProfessionalExperience(reader);
            } else if ("educational_background".equals(name)) {
                user.educational_background = readEducationalBackground(reader);
            } else if ("photo_urls".equals(name)) {
                user.photo_urls = readPhotoUrls(reader);
            } else {
                reader.skipValue();
            }
        }

        reader.endObject();

        return user;
    }

    private PhotoUrls readPhotoUrls(JsonReader reader) throws IOException {
        PhotoUrls photoUrls = new PhotoUrls();

        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (reader.peek() == JsonReader.Token.NULL) {
                reader.nextNull();
                continue;
            }

            if ("large".equals(name)) {
                photoUrls.large = reader.nextString();
            } else if ("maxi_thumb".equals(name)) {
                photoUrls.maxi_thumb = reader.nextString();
            } else if ("medium_thumb".equals(name)) {
                photoUrls.medium_thumb = reader.nextString();
            } else if ("mini_thumb".equals(name)) {
                photoUrls.mini_thumb = reader.nextString();
            } else if ("thumb".equals(name)) {
                photoUrls.thumb = reader.nextString();
            } else if ("size_32x32".equals(name)) {
                photoUrls.size_32x32 = reader.nextString();
            } else if ("size_48x48".equals(name)) {
                photoUrls.size_48x48 = reader.nextString();
            } else if ("size_64x64".equals(name)) {
                photoUrls.size_64x64 = reader.nextString();
            } else if ("size_96x96".equals(name)) {
                photoUrls.size_96x96 = reader.nextString();
            } else if ("size_128x128".equals(name)) {
                photoUrls.size_128x128 = reader.nextString();
            } else if ("size_192x192".equals(name)) {
                photoUrls.size_192x192 = reader.nextString();
            } else if ("size_256x256".equals(name)) {
                photoUrls.size_256x256 = reader.nextString();
            } else if ("size_1024x1024".equals(name)) {
                photoUrls.size_1024x1024 = reader.nextString();
            } else if ("size_original".equals(name)) {
                photoUrls.size_original = reader.nextString();
            } else {
                reader.skipValue();
            }
        }

        reader.endObject();

        return photoUrls;
    }

    private EducationalBackground readEducationalBackground(JsonReader reader) throws IOException {
        EducationalBackground educationalBackground = new EducationalBackground();

        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (reader.peek() == JsonReader.Token.NULL) {
                reader.nextNull();
                continue;
            }

            if ("degree".equals(name)) {
                educationalBackground.degree = reader.nextString();
            } else if ("primary_school".equals(name)) {
                educationalBackground.primary_school = readSchool(reader);
            } else if ("schools".equals(name)) {
                educationalBackground.schools = readSchoolArray(reader);
            } else if ("qualifications".equals(name)) {
                educationalBackground.qualifications = readStringArray(reader);
            } else {
                reader.skipValue();
            }
        }

        reader.endObject();

        return educationalBackground;
    }

    private List<School> readSchoolArray(JsonReader reader) throws IOException {
        List<School> array = new ArrayList<>();

        reader.beginArray();

        while (reader.hasNext()) {
            array.add(readSchool(reader));
        }

        reader.endArray();

        return array;
    }

    private School readSchool(JsonReader reader) throws IOException {
        School school = new School();

        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (reader.peek() == JsonReader.Token.NULL) {
                reader.nextNull();
                continue;
            }

            if ("id".equals(name)) {
                school.id = reader.nextString();
            } else if ("name".equals(name)) {
                school.name = reader.nextString();
            } else if ("degree".equals(name)) {
                school.degree = reader.nextString();
            } else if ("notes".equals(name)) {
                school.notes = reader.nextString();
            } else if ("subject".equals(name)) {
                school.subject = reader.nextString();
            } else if ("begin_date".equals(name)) {
                school.begin_date = reader.nextString();
            } else if ("end_date".equals(name)) {
                school.end_date = reader.nextString();
            } else {
                reader.skipValue();
            }
        }

        reader.endObject();

        return school;
    }

    private ProfessionalExperience readProfessionalExperience(JsonReader reader) throws IOException {
        ProfessionalExperience professionalExperience = new ProfessionalExperience();

        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (reader.peek() == JsonReader.Token.NULL) {
                reader.nextNull();
                continue;
            }

            if ("primary_company".equals(name)) {
                professionalExperience.primary_company = readCompany(reader);
            } else if ("companies".equals(name)) {
                professionalExperience.companies = readCompanyArray(reader);
            } else if ("awards".equals(name)) {
                professionalExperience.awards = readAwardArray(reader);
            } else {
                reader.skipValue();
            }
        }

        reader.endObject();

        return professionalExperience;
    }

    private List<Award> readAwardArray(JsonReader reader) throws IOException {
        List<Award> array = new ArrayList<>();

        reader.beginArray();

        while (reader.hasNext()) {
            array.add(readAward(reader));
        }

        reader.endArray();

        return array;
    }

    private Award readAward(JsonReader reader) throws IOException {
        Award award = new Award();

        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (reader.peek() == JsonReader.Token.NULL) {
                reader.nextNull();
                continue;
            }

            if ("name".equals(name)) {
                award.name = reader.nextString();
            } else if ("date_awarded".equals(name)) {
                award.date_awarded = reader.nextInt();
            } else if ("url".equals(name)) {
                award.url = reader.nextString();
            } else {
                reader.skipValue();
            }
        }

        reader.endObject();

        return award;
    }

    private List<Company> readCompanyArray(JsonReader reader) throws IOException {
        List<Company> array = new ArrayList<>();

        reader.beginArray();

        while (reader.hasNext()) {
            array.add(readCompany(reader));
        }

        reader.endArray();

        return array;
    }

    private Company readCompany(JsonReader reader) throws IOException {
        Company company = new Company();

        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (reader.peek() == JsonReader.Token.NULL) {
                reader.nextNull();
                continue;
            }

            if ("id".equals(name)) {
                company.id = reader.nextString();
            } else if ("name".equals(name)) {
                company.name = reader.nextString();
            } else if ("title".equals(name)) {
                company.title = reader.nextString();
            } else if ("company_size".equals(name)) {
                company.company_size = reader.nextString();
            } else if ("tag".equals(name)) {
                company.tag = reader.nextString();
            } else if ("url".equals(name)) {
                company.url = reader.nextString();
            } else if ("career_level".equals(name)) {
                company.career_level = reader.nextString();
            } else if ("begin_date".equals(name)) {
                company.begin_date = reader.nextString();
            } else if ("description".equals(name)) {
                company.description = reader.nextString();
            } else if ("end_date".equals(name)) {
                company.end_date = reader.nextString();
            } else if ("industry".equals(name)) {
                company.industry = reader.nextString();
            } else if ("industries".equals(name)) {
                company.industries = readIndustriesArray(reader);
            } else if ("form_of_employment".equals(name)) {
                company.form_of_employment = reader.nextString();
            } else if ("until_now".equals(name)) {
                company.until_now = reader.nextBoolean();
            } else if ("discipline".equals(name)) {
                company.discipline = readDiscipline(reader);
            } else {
                reader.skipValue();
            }
        }

        reader.endObject();

        return company;
    }

    private Discipline readDiscipline(JsonReader reader) throws IOException {
        Discipline discipline = new Discipline();

        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (reader.peek() == JsonReader.Token.NULL) {
                reader.nextNull();
                continue;
            }

            if ("id".equals(name)) {
                discipline.id = reader.nextString();
            } else if ("key".equals(name)) {
                discipline.key = reader.nextString();
            } else {
                reader.skipValue();
            }
        }

        reader.endObject();

        return discipline;
    }

    private List<Industry> readIndustriesArray(JsonReader reader) throws IOException {
        List<Industry> array = new ArrayList<>();

        reader.beginArray();

        while (reader.hasNext()) {
            array.add(readIndustry(reader));
        }

        reader.endArray();

        return array;
    }

    private Industry readIndustry(JsonReader reader) throws IOException {
        Industry industry = new Industry();

        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (reader.peek() == JsonReader.Token.NULL) {
                reader.nextNull();
                continue;
            }

            if ("id".equals(name)) {
                industry.id = reader.nextInt();
            } else if ("localized_name".equals(name)) {
                industry.localized_name = reader.nextString();
            } else {
                reader.skipValue();
            }
        }

        reader.endObject();

        return industry;
    }

    private InstantMessagingAccounts readMessagingAccounts(JsonReader reader) throws IOException {
        InstantMessagingAccounts instantMessagingAccounts = new InstantMessagingAccounts();

        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (reader.peek() == JsonReader.Token.NULL) {
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

    private WebProfiles readWebProfiles(JsonReader reader) throws IOException {
        WebProfiles webProfiles = new WebProfiles();

        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (reader.peek() == JsonReader.Token.NULL) {
                reader.nextNull();
                continue;
            }

            if ("qype".equals(name)) {
                webProfiles.qype = readStringArray(reader);
            } else if ("google".equals(name)) {
                webProfiles.google = readStringArray(reader);
            } else if ("other".equals(name)) {
                webProfiles.other = readStringArray(reader);
            } else if ("homepage".equals(name)) {
                webProfiles.homepage = readStringArray(reader);
            } else {
                reader.skipValue();
            }
        }

        reader.endObject();

        return webProfiles;
    }

    private Address readAddress(JsonReader reader) throws IOException {
        Address address = new Address();

        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (reader.peek() == JsonReader.Token.NULL) {
                reader.nextNull();
                continue;
            }

            if ("city".equals(name)) {
                address.city = reader.nextString();
            } else if ("country".equals(name)) {
                address.country = reader.nextString();
            } else if ("zip_code".equals(name)) {
                address.zip_code = reader.nextString();
            } else if ("street".equals(name)) {
                address.street = reader.nextString();
            } else if ("phone".equals(name)) {
                address.phone = reader.nextString();
            } else if ("fax".equals(name)) {
                address.fax = reader.nextString();
            } else if ("province".equals(name)) {
                address.province = reader.nextString();
            } else if ("email".equals(name)) {
                address.email = reader.nextString();
            } else if ("mobile_phone".equals(name)) {
                address.mobile_phone = reader.nextString();
            } else {
                reader.skipValue();
            }
        }

        reader.endObject();

        return address;
    }

    private Languages readLanguages(JsonReader reader) throws IOException {
        Languages languages = new Languages();

        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (reader.peek() == JsonReader.Token.NULL) {
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

    private List<String> readStringArray(JsonReader reader) throws IOException {
        List<String> array = new ArrayList<>();

        reader.beginArray();

        while (reader.hasNext()) {
            array.add(reader.nextString());
        }

        reader.endArray();

        return array;
    }

    private TimeZone readTimeZone(JsonReader reader) throws IOException {
        TimeZone timeZone = new TimeZone();

        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (reader.peek() == JsonReader.Token.NULL) {
                reader.nextNull();
                continue;
            }

            if ("name".equals(name)) {
                timeZone.name = reader.nextString();
            } else if ("utc_offset".equals(name)) {
                timeZone.utc_offset = reader.nextDouble();
            } else {
                reader.skipValue();
            }
        }

        reader.endObject();

        return timeZone;
    }

    private BirthDate readBirthDate(JsonReader reader) throws IOException {
        BirthDate birthDate = new BirthDate();

        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (reader.peek() == JsonReader.Token.NULL) {
                reader.nextNull();
                continue;
            }

            if ("day".equals(name)) {
                birthDate.day = reader.nextInt();
            } else if ("month".equals(name)) {
                birthDate.month = reader.nextInt();
            } else if ("year".equals(name)) {
                birthDate.year = reader.nextInt();
            } else {
                reader.skipValue();
            }
        }

        reader.endObject();

        return birthDate;
    }

}
