/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docotel.spera.responses;

import docotel.spera.models.Troop;
import java.util.ArrayList;

/**
 *
 * @author rakhadjo
 */
public class GetTroopsResponse extends ResponseBody {
    
    /**
     *
     */
    public java.util.List<Troop> data;
    
    /**
     *
     * @param res
     */
    public GetTroopsResponse(Result res) {
        super(res);
    }
    
    /**
     *
     * @return
     */
    public org.bson.Document toJSON() {
        ArrayList data2 = new ArrayList();
        for (Troop t : data) {
            data2.add(t.toJSON());
        }
        return super.toJSON()
                .append("data", data2)
                ;
    }
    
}
