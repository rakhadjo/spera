/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docotel.spera.log;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author rakhadjo
 */
@Document(collection = "log_getpositions")
public class GetPositionsLogEntry extends LogEntry {
    
    /**
     *
     */
    public GetPositionsLogEntry() {}
    
}
