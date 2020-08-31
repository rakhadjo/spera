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
public class DashboardResponse extends ResponseBody {
    
    public org.bson.Document data;
    
    public DashboardResponse(Result res) {
        super(res);
        data = new org.bson.Document()
                .append("total_troops", 73)
                .append("placement", 
                        new org.bson.Document()
                        .append("jakarta", 30)
                        .append("yogyakarta", 40)
                        .append("internship", 3)
                )
                .append("position", 
                        new org.bson.Document()
                        .append("software-engineer", 40)
                        .append("android-mobile-developer", 10)
                        .append("ios-mobile-developer", 10)
                        .append("system-analyst", 13)
                )
                .append("turnover", 
                        new org.bson.Document()
                        .append("jan", 10)
                        .append("feb", 2)
                        .append("mar",5)
                        .append("apr",6)
                        .append("may",1)
                        .append("jun",0)
                        .append("jul",0)
                        .append("aug",0)
                        .append("sep",0)
                        .append("oct",0)
                        .append("nov",0)
                        .append("dec",0)
                );
    }
    
    public void setData(org.bson.Document data) {
        this.data = data;
    }
    
    public org.bson.Document toJSON() {
        return super.toJSON()
                .append("data", data);
    }
    
}
