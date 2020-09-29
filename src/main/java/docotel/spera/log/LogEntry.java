/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docotel.spera.log;

import java.sql.Timestamp;
import org.bson.Document;

/**
 *
 * @author rakhadjo
 */
public class LogEntry {
    
    /**
     *
     */
    public String host_ip;

    /**
     *
     */
    public String client_ip;

    /**
     *
     */
    public Document request_header;

    /**
     *
     */
    public Document request_body;

    /**
     *
     */
    public Document response_header;

    /**
     *
     */
    public Document response_body;

    /**
     *
     */
    public String nik;

    /**
     *
     */
    public Timestamp request_datetime;

    /**
     *
     */
    public Timestamp response_datetime;

    /**
     *
     */
    public long elapsed_time;

    /**
     *
     */
    public boolean is_error;
    
    /**
     *
     */
    public LogEntry() {}
    
    /**
     *
     * @return
     */
    public Document toJSON() {
        return new Document()
                .append("host_ip", host_ip)
                .append("client_ip", client_ip)
                .append("request_header", request_header)
                .append("request_body", request_body)
                .append("response_header", response_header)
                .append("response_body", response_body)
                .append("nik", nik)
                .append("request_datetime", request_datetime)
                .append("response_datetime", response_datetime)
                .append("elapsed_time", elapsed_time)
                .append("is_error", is_error)
                ;
    }
}
