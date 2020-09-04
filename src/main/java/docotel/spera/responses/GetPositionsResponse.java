/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docotel.spera.responses;

import docotel.spera.models.Position;
import java.util.ArrayList;

/**
 *
 * @author rakhadjo
 */
public class GetPositionsResponse extends ResponseBody {
    
    public java.util.List<Position> data;
    
    public GetPositionsResponse(Result res) {
        super(res);
    }
    
    public org.bson.Document toJSON() {
        ArrayList data2 = new ArrayList();
        for (Position p : data) {
            data2.add(p.toJSON());
        }
        return super.toJSON()
                .append("data", data2)
                ;
    }
    
}
