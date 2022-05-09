package uz.ttj.springbootencodedecodedemo.service;

import org.springframework.stereotype.Service;
import uz.ttj.springbootencodedecodedemo.payload.ApiResponse;
import uz.ttj.springbootencodedecodedemo.payload.CharsetType;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class CharsetService {

    public ApiResponse encoder(CharsetType charsetType) throws UnsupportedEncodingException {

        try {
            String textDate = charsetType.getText();
            String encodeText = Base64.getEncoder().encodeToString(textDate.getBytes(Charset.forName(charsetType.getCharsetType())));
//            String encodeText = Base64.getEncoder().encodeToString(textDate.getBytes(charsetType.getCharsetType()));
            return new ApiResponse("Success", true, encodeText);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("Error", false);
        }
    }

    public ApiResponse decoder(CharsetType charsetType) {

        try {
            String encodeText = charsetType.getText();
            byte[] decodeArr = Base64.getDecoder().decode(encodeText);
            String decodeText = new String(decodeArr,charsetType.getCharsetType());
            return new ApiResponse("Success", true, decodeText);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("Error", false);
        }
    }

}
