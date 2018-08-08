package slr.master.stratospherique.domain;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 24/07/2018.
 */
@NodeEntity(label = "Tool")
public class Tool {
    @Id
    @GeneratedValue
    private Long graphId;

    private String toolU;

    @Relationship(type = "USED_T",direction = Relationship.INCOMING)
    private List<Goal> goalList=new ArrayList<>();

    public Tool(String toolU) {
        this.toolU = toolU;
    }

    public Tool() {
    }

    public Long getGraphId() {
        return graphId;
    }

    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public String getToolU() {
        return toolU;
    }

    public void setToolU(String toolU) {
        this.toolU = toolU;
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
