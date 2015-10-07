package sl.benchmark.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;
import java.util.ArrayList;
import java.util.List;

public class WebProfiles {
  public List<String> qype = new ArrayList<>();
  @Json(name = "google+")
  @JsonProperty("google+")
  @SerializedName("google+")
  public List<String> google = new ArrayList<>();
  public List<String> other = new ArrayList<>();
  public List<String> homepage = new ArrayList<>();

  @Override
  public String toString() {
    return "WebProfiles{" +
        "qype=" + qype +
        ", google=" + google +
        ", other=" + other +
        ", homepage=" + homepage +
        '}';
  }
}