package ResponseModels.Singleuser;
import ResponseModels.listusers.Datum;
import ResponseModels.listusers.Support;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data",
        "support"
})
public class Singleuser {

    @JsonProperty("data")
    public Datum data;
    @JsonProperty("support")
    public Support support;

}
