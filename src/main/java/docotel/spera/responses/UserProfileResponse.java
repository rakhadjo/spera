/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docotel.spera.responses;

/**
 *
 * @author rakhadjo
 */
public class UserProfileResponse extends ResponseBody {
    
    public org.bson.Document data;
    
    public UserProfileResponse(Result res) {
        super(res);
    }
    
    public org.bson.Document toJSON() {
        return super.toJSON()
                .append("data", data);
    }
    
}
