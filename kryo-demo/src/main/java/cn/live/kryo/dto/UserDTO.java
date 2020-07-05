package cn.live.kryo.dto;

public class UserDTO {

  private String name;
  private String say;

  public UserDTO() {

  }

  public UserDTO(String name, String say) {
    this.name = name;
    this.say = say;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSay() {
    return say;
  }

  public void setSay(String say) {
    this.say = say;
  }

  public String toString() {
    return String.format("%s: %s!", name, say);
  }

}
