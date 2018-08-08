package slr.master.stratospherique.domain;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 23/07/2018.
 */
@NodeEntity(label = "Sector")
public class Sector {
    @Id
    @GeneratedValue
    private Long graphId;

    private String conS1;

    @Relationship(type = "DOMAIN",direction = Relationship.INCOMING)
    private List<Context> contexts=new ArrayList<>();

    public Sector(String conS1) {
        this.conS1 = conS1;
    }

    public Sector() {
    }

    public Long getGraphId() {
        return graphId;
    }

    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public String getConS1() {
        return conS1;
    }

    public void setConS1(String conS1) {
        this.conS1 = conS1;
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
