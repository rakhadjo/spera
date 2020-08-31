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
public class RequestBody {
    
    public String device_id;
    
    public RequestBody() {}
    
    public org.bson.Document toJSON() {
        return new org.bson.Document()
                .append("device_id", device_id)
                ;
    }
}
