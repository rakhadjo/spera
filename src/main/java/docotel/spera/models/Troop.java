/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docotel.spera.models;

import java.util.regex.Pattern;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author rakhadjo
 */
@Document(collection = "refTroops")
public class Troop {
    
    private static final String VALID_EMAIL_ADDRESS_REGEX
            = "^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$";
    
    private static final String VALID_MOBILE_PHONE_REGEX
            = "^08[0-9]{9,}$";
    
    private String fullname;
    private String nik;
    private String position_id;
    private String grade_id;
    private String email_docotel;
    private String mobile_phone;
    private String status;
    private String gender;

    public Troop(String fullname, String nik, String position_id, String grade_id, String email_docotel, String mobile_phone, String status, String gender) {
        this.fullname = fullname;
        this.nik = nik;
        this.position_id = position_id;
        this.grade_id = grade_id;
        this.email_docotel = email_docotel;
        this.mobile_phone = mobile_phone;
        this.status = status;
        this.gender = gender;
    }

    private static boolean emailValid(String email) {
        return Pattern.matches(VALID_EMAIL_ADDRESS_REGEX, email);
    }
    
    
    
    
    
    
}
