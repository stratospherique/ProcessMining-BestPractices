package slr.master.stratospherique.domain;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 23/07/2018.
 */
@NodeEntity(label = "Input")
public class Input {
    @Id
    @GeneratedValue
    private Long graphId;

    @Relationship(type = "AS_INPUT")
    private List<Context> contexts=new ArrayList<>();

    private String input;

    public Input(String inp) {
        this.input = inp;
    }

    public Input() {
    }

    public Long getGraphId() {
        return graphId;
    }

    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public String getInp() {
        return input;
    }

    public void setInp(String inp) {
        this.input = inp;
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
