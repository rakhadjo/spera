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
@Document(collection = "log_getgrades")
public class GetGradesLogEntry extends LogEntry {
    
}
