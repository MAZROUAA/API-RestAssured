package Requestmodels;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "email",
        "password"
})
@JsonIgnoreProperties(ignoreUnknown = true)

public class Loginrequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("email")
    public String email;
    @JsonProperty("password")
    public String password;

}
