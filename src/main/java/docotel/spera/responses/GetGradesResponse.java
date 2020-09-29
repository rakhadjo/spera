/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docotel.spera.responses;

import docotel.spera.models.Grade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rakhadjo
 */
public class GetGradesResponse extends ResponseBody {
    
    /**
     *
     */
    public List<Grade> data;
    
    /**
     *
     * @param res
     */
    public GetGradesResponse(Result res) {
        super(res);
    }
    
    /**
     *
     * @return
     */
    public org.bson.Document toJSON() {
        ArrayList data2 = new ArrayList();
        for (Grade g : data) {
            data2.add(g.toJSON());
        }
        return super.toJSON()
                .append("data", data2)
                ;
    }
    
    
    
}
