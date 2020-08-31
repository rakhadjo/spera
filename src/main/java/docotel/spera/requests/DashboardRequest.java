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
public class DashboardRequest extends RequestBody {

    public String year;
    
    public org.bson.Document toJSON() {
        return super.toJSON()
                .append("year", year)
                ;
    }
}
