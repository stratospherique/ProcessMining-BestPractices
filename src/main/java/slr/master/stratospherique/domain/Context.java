package slr.master.stratospherique.domain;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 23/07/2018.
 */
@NodeEntity(label = "Context")
public class Context {
    @Id @GeneratedValue
    private Long graphId;

    @Relationship(type="L_SIZE")
    private List<LSize> lSizes=new ArrayList<>();

    @Relationship(type="S_KIND")
    private List<SysType> sysTypes=new ArrayList<>();
    @Relationship(type="DOMAIN")
    private List<Sector> sectors=new ArrayList<>();
    @Relationship(type="WITH_IN")
    private List<SysName> sysNames=new ArrayList<>();
    @Relationship(type="EXT")
    private List<EFormat> eFormats=new ArrayList<>();
    @Relationship(type="SOURCE")
    private List<ESource> eSources=new ArrayList<>();
    @Relationship(type="USED_BY")
    private UserType userType;

    @Relationship(type="IN_CONTEXT", direction=Relationship.INCOMING)
    private Article article;

    @Relationship(type="AS_INPUT",direction = Relationship.INCOMING)
    private List<Input> inputs=new ArrayList<>();

    public Long getGraphId() {
        return graphId;
    }

    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public List<Input> getInputs() {
        return inputs;
    }

    public void addToInputList(Input input) {
        if(this.inputs==null){
            this.inputs=new ArrayList<Input>();
        }
        this.inputs.add(input);
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Context() {
    }
}
