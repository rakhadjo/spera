/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docotel.spera.models;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author rakhadjo
 */
@Document(collection = "refPositions")
public class Position {

    /**
     *
     */
    public String position_id;

    /**
     *
     */
    public String position_name;

    /**
     *
     * @return
     */
    public org.bson.Document toJSON() {
        return new org.bson.Document()
                .append("position_id", position_id)
                .append("position_name", position_name);
    }

}
