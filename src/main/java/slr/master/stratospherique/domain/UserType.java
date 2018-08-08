package slr.master.stratospherique.domain;


import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 23/07/2018.
 */
@NodeEntity(label = "UserType")
public class UserType {
    @Id
    @GeneratedValue
    private Long graphId;

    private String uType;

    @Relationship(type = "USED_BY",direction = Relationship.INCOMING)
    private List<Context> contexts=new ArrayList<>();

    public UserType(String uType) {
        this.uType = uType;
    }

    public UserType() {
    }

    public Long getGraphId() {
        return graphId;
    }

    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public String getuType() {
        return uType;
    }

    public void setuType(String uType) {
        this.uType = uType;
    }


    public List<Context> getContexts() {
        return contexts;
    }

    public void addToContexts(Context context) {
        if(this.contexts==null){
            this.contexts=new ArrayList<Context>();
        }
        this.contexts.add(context);
    }
}
