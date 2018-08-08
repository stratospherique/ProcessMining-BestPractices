package slr.master.stratospherique.domain;


import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 24/07/2018.
 */
@NodeEntity(label = "Output")
public class Output {
    @Id
    @GeneratedValue
    private Long graphId;

    private String out;

    @Relationship(type = "OBTAINED",direction = Relationship.INCOMING)
    private List<Goal> goalList=new ArrayList<>();

    public Output(String out) {
        this.out = out;
    }

    public Output() {
    }

    public Long getGraphId() {
        return graphId;
    }

    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
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
