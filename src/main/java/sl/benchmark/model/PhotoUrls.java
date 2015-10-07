package sl.benchmark.model;

import android.net.Uri;

public class PhotoUrls {

  public String large;
  public String maxi_thumb;
  public String medium_thumb;
  public String mini_thumb;
  public String thumb;
  public String size_32x32;
  public String size_48x48;
  public String size_64x64;
  public String size_96x96;
  public String size_128x128;
  public String size_192x192;
  public String size_256x256;
  public String size_1024x1024;
  public String size_original;

  @Override
  public String toString() {
    return "PhotoUrls{" +
        "large='" + large + '\'' +
        ", maxi_thumb='" + maxi_thumb + '\'' +
        ", medium_thumb='" + medium_thumb + '\'' +
        ", mini_thumb='" + mini_thumb + '\'' +
        ", thumb='" + thumb + '\'' +
        ", size_32x32='" + size_32x32 + '\'' +
        ", size_48x48='" + size_48x48 + '\'' +
        ", size_64x64='" + size_64x64 + '\'' +
        ", size_96x96='" + size_96x96 + '\'' +
        ", size_128x128='" + size_128x128 + '\'' +
        ", size_192x192='" + size_192x192 + '\'' +
        ", size_256x256='" + size_256x256 + '\'' +
        ", size_1024x1024='" + size_1024x1024 + '\'' +
        ", size_original='" + size_original + '\'' +
        '}';
  }

  public void setPhotoLargeUrl(String photoLargeUrl) {
    this.large = photoLargeUrl;
  }

  public void setPhotoMaxiThumbUrl(String photoMaxiThumbUrl) {
    this.maxi_thumb = photoMaxiThumbUrl;
  }

  public void setPhotoMediumThumbUrl(String photoMediumThumbUrl) {
    this.medium_thumb = photoMediumThumbUrl;
  }

  public void setPhotoMiniThumbUrl(String photoMiniThumbUrl) {
    this.mini_thumb = photoMiniThumbUrl;
  }

  public void setPhotoThumbUrl(String photoThumbUrl) {
    this.thumb = photoThumbUrl;
  }

  public void setPhotoSize32Url(String photoSize32Url) {
    this.size_32x32 = photoSize32Url;
  }

  public void setPhotoSize48Url(String photoSize48Url) {
    this.size_48x48 = photoSize48Url;
  }

  public void setPhotoSize64Url(String photoSize64Url) {
    this.size_64x64 = photoSize64Url;
  }

  public void setPhotoSize96Url(String photoSize96Url) {
    this.size_96x96 = photoSize96Url;
  }

  public void setPhotoSize128Url(String photoSize128Url) {
    this.size_128x128 = photoSize128Url;
  }

  public void setPhotoSize192Url(String photoSize192Url) {
    this.size_192x192 = photoSize192Url;
  }

  public void setPhotoSize256Url(String photoSize256Url) {
    this.size_256x256 = photoSize256Url;
  }

  public void setPhotoSize1024Url(String photoSize1024Url) {
    this.size_1024x1024 = photoSize1024Url;
  }

  public void setPhotoSizeOriginalUrl(String photoSizeOriginalUrl) {
    this.size_original = photoSizeOriginalUrl;
  }
}