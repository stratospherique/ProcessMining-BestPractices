package slr.master.stratospherique.domain;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 24/07/2018.
 */
@NodeEntity(label = "Filtering")
public class Filtering {
    @Id
    @GeneratedValue
    private Long graphId;

    private String fil;


    @Relationship(type = "USED_F",direction = Relationship.INCOMING)
    private List<Goal> goalList=new ArrayList<>();

    public Filtering(String fil) {
        this.fil = fil;
    }

    public Filtering() {
    }

    public Long getGraphId() {
        return graphId;
    }

    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public String getFil() {
        return fil;
    }

    public void setFil(String fil) {
        this.fil = fil;
    }

    public List<Goal> getGoalList() {
        return goalList;
    }

    public void addToGoalList(Goal goal) {
        if(this.goalList==null){
            this.goalList=new ArrayList<Goal>();
        }
        this.goalList.add(goal);
    }
}
