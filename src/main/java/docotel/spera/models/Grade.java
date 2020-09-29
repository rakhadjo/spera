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
@Document(collection = "refGrades")
public class Grade {
    
    /**
     *
     */
    public String grade_id;

    /**
     *
     */
    public String grade_romawi;

    /**
     *
     */
    public String grade_name;

    /**
     *
     * @return
     */
    public org.bson.Document toJSON() {
        return new org.bson.Document()
                .append("grade_id", grade_id)
                .append("grade_romawi", grade_romawi)
                .append("grade_name", grade_name);
    }

}
