/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docotel.spera.responses;

/**
 *
 * @author rakhadjo
 */
public class ResponseBody {

    private String rc;
    private String message;
    private final String role = "admin";
    private final String menu = "home, troops, account";

    /**
     *
     * @param res
     */
    public ResponseBody(Result res) {
        setCodes(res);
    }

    /**
     *
     * @param res
     */
    public void setCodes(Result res) {
        switch (res) {
            case SUCCESS:
                this.rc = "00";
                this.message = "success";
                break;
            case ERROR:
                this.rc = "99";
                this.message = "internal error";
                break;
        }
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     */
    public org.bson.Document toJSON() {
        return new org.bson.Document()
                .append("rc", rc)
                .append("message", message)
                .append("role", role)
                .append("menu", menu);
                
    }

}
