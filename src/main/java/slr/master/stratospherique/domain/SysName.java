package slr.master.stratospherique.domain;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 23/07/2018.
 */
@NodeEntity(label = "SysName")
public class SysName {
    @Id
    @GeneratedValue
    private Long graphId;

    private String name;

    @Relationship(type = "WITH_IN",direction = Relationship.INCOMING)
    private List<Context> contexts=new ArrayList<>();

    public SysName(String name) {
        this.name = name;
    }

    public SysName() {
    }

    public Long getGraphId() {
        return graphId;
    }

    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
