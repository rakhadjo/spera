/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docotel.spera.log;

import docotel.spera.models.Troop;
import java.util.ArrayList;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author rakhadjo
 */
@Document(collection = "log_alltroops")
public class GetTroopsLogEntry extends LogEntry {
    
    /**
     *
     */
    public java.util.List<Troop> data;
    
    /**
     *
     */
    public GetTroopsLogEntry() {
        
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
