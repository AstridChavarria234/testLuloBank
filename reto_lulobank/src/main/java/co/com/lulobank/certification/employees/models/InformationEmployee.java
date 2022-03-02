package co.com.lulobank.certification.employees.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id", "employee_name", "employee_salary", "employee_age", "profile_image"})
public class InformationEmployee implements Serializable {

  @JsonProperty("id")
  public Integer id;

  @JsonProperty("employee_name")
  public String employee_name;

  @JsonProperty("employee_salary")
  public Integer employee_salary;

  @JsonProperty("employee_age")
  public Integer employee_age;

  @JsonProperty("profile_image")
  public String profile_image;

  private static final long serialVersionUID = -5475305453283824787L;
}
