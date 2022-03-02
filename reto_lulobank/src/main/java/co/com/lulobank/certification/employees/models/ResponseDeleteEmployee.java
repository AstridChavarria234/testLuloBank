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
@JsonPropertyOrder({"status", "data", "message"})
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDeleteEmployee implements Serializable {

  @JsonProperty("status")
  public String status;

  @JsonProperty("data")
  public String data;

  @JsonProperty("message")
  public String message;

  private static final long serialVersionUID = -5475305453283824787L;
}
