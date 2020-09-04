/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docotel.spera.logrepos;

import docotel.spera.log.GetDashboardLogEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author rakhadjo
 */
public interface GetDashboardLogRepo extends MongoRepository<GetDashboardLogEntry, String> {
    
}
