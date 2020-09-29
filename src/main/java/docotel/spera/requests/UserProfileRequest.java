/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docotel.spera.requests;

/**
 *
 * @author rakhadjo
 */
public class UserProfileRequest extends RequestBody {
    
    /**
     *
     */
    public String nik;

    /**
     *
     */
    public String password;
    
    /**
     *
     * @return
     */
    public org.bson.Document toJSON() {
        return super.toJSON()
                .append("nik", nik)
                .append("password", password);
    }
    
}
