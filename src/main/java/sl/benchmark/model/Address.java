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
}
