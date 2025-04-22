package az.edu.turing.mvcapp.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class EntityResponse {
    @JsonProperty("message")
    private final String message;

    @JsonProperty("timestamp")
    private final LocalDateTime timestamp;

    @JsonProperty("statusCode")
    private final int statusCode;

    public EntityResponse(String message, int statusCode) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.statusCode = statusCode;
    }
}
