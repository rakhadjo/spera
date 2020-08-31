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

    public String fullname;
    public String nik;
    public String position_id;
    public String grade_id;
    public String email_docotel;
    public String mobile_phone;
    public String status;
    public String gender;

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

    public static boolean valid(String email, String mobile_phone, String nik, String grade, String pos, String status) {
        return emailValid(email) && mobileValid(mobile_phone) && nikValid(nik) && gradeValid(grade) && posValid(pos) && statusValid(status);
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
                .append("fullname", fullname)
                .append("nik", nik)
                .append("position_id", position_id)
                .append("grade_id", grade_id)
                .append("email_docotel", email_docotel)
                .append("mobile_phone", mobile_phone)
                .append("status", status)
                .append("gender", gender);
    }

}
