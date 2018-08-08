package slr.master.stratospherique.domain;

import org.neo4j.ogm.annotation.*;

/**
 * Created by ASUS on 23/07/2018.
 */
@NodeEntity(label = "LSize")
public class LSize {
    @Id
    @GeneratedValue
    private Long graphId;

    private String lSize;

    @Relationship(type="L_SIZE", direction=Relationship.INCOMING)
    private Context context;

    public Long getGraphId() {
        return graphId;
    }

    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public String getlSize() {
        return lSize;
    }

    public void setlSize(String lSize) {
        this.lSize = lSize;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public LSize(String lSize) {
        this.lSize = lSize;
    }

    public LSize() {
    }
}
