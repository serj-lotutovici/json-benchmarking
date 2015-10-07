package sl.benchmark.model;

public class Address {

  public String city;
  public String country;
  public String zip_code;
  public String street;
  public String phone;
  public String fax;
  public String province;
  public String email;
  public String mobile_phone;

  @Override
  public String toString() {
    return "Address{" +
        "city='" + city + '\'' +
        ", country='" + country + '\'' +
        ", zip_code='" + zip_code + '\'' +
        ", street='" + street + '\'' +
        ", phone='" + phone + '\'' +
        ", fax='" + fax + '\'' +
        ", province='" + province + '\'' +
        ", email='" + email + '\'' +
        ", mobile_phone='" + mobile_phone + '\'' +
        '}';
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobile_phone = mobilePhone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public void setZipCode(String zipCode) {
    this.zip_code = zipCode;
  }
}
