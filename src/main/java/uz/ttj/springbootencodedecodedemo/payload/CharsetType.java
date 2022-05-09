package uz.ttj.springbootencodedecodedemo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharsetType {

    private String text;
    private String charsetType;

}
