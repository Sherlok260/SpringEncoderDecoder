package uz.ttj.springbootencodedecodedemo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse {

    private String message;
    private boolean success;
    private String yourCode;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public ApiResponse(String message, boolean success, String yourCode) {
        this.message = message;
        this.success = success;
        this.yourCode = yourCode;
    }
}
