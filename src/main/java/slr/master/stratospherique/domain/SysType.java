package slr.master.stratospherique.domain;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 23/07/2018.
 */
@NodeEntity(label = "NatSys")
public class SysType {
    @Id
    @GeneratedValue
    private Long graphId;

    private String typeSys;

    @Relationship(type = "S_KIND",direction = Relationship.INCOMING)
    private  List<Context> contexts=new ArrayList<>();

    public SysType(String typeSys) {
        this.typeSys = typeSys;
    }

    public SysType() {
    }

    public Long getGraphId() {
        return graphId;
    }

    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public String getTypeSys() {
        return typeSys;
    }

    public void setTypeSys(String typeSys) {
        this.typeSys = typeSys;
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
