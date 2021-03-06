package slr.master.stratospherique.domain;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 23/07/2018.
 */
@NodeEntity(label = "ESource")
public class ESource {
    @Id
    @GeneratedValue private Long graphId;

    private String source;

    @Relationship(type = "SOURCE",direction = Relationship.INCOMING)
    private List<Context> contexts=new ArrayList<>();

    public ESource(String source) {
        this.source = source;
    }

    public ESource() {
    }

    public Long getGraphId() {
        return graphId;
    }

    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
