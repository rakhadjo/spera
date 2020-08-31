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

    private static final String VALID_NIK_REGEX
            = "^1[0-9]{7}$";

    private static final String VALID_GRADE_ID_REGEX
            = "^[0-7]$";

    private static final String VALID_POS_ID_REGEX
            = "^[0-2]$";

    private static final String VALID_STATUS_REGEX
            = "^[0-2]$";

    private String fullname;
    private String nik;
    private String position_id;
    private String grade_id;
    private String email_docotel;
    private String mobile_phone;
    private String status;
    private String gender;

    public Troop(String fullname, String nik, String position_id, String grade_id, String email_docotel, String mobile_phone, String status, String gender) {
        if (emailValid(email_docotel) && mobileValid(mobile_phone) && nikValid(nik) && gradeValid(grade_id) && posValid(position_id) && statusValid(status)) {
            this.fullname = fullname;
            this.nik = nik;
            this.position_id = position_id;
            this.grade_id = grade_id;
            this.email_docotel = email_docotel;
            this.mobile_phone = mobile_phone;
            this.status = status;
            this.gender = gender;
        }

    }

    private static boolean emailValid(String email) {
        return Pattern.matches(VALID_EMAIL_ADDRESS_REGEX, email);
    }

    private static boolean mobileValid(String mobile_phone) {
        return Pattern.matches(VALID_MOBILE_PHONE_REGEX, mobile_phone);
    }

    private static boolean nikValid(String nik) {
        return Pattern.matches(VALID_NIK_REGEX, nik);
    }

    private static boolean gradeValid(String grade) {
        return Pattern.matches(VALID_GRADE_ID_REGEX, grade);
    }

    private static boolean posValid(String pos) {
        return Pattern.matches(VALID_POS_ID_REGEX, pos);
    }

    private static boolean statusValid(String status) {
        return Pattern.matches(VALID_STATUS_REGEX, status);
    }

    public org.bson.Document toJSON() {
        return new org.bson.Document()
                .append("fullname", this.fullname)
                .append("nik", this.nik)
                .append("position_id", this.position_id)
                .append("grade_id", this.grade_id)
                .append("email_docotel", this.email_docotel)
                .append("mobile_phone", this.mobile_phone)
                .append("status", this.status)
                .append("gender", this.gender);
    }

}