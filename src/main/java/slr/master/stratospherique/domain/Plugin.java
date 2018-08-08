package slr.master.stratospherique.domain;


import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 24/07/2018.
 */
@NodeEntity(label = "Plugin")
public class Plugin {
    @Id
    @GeneratedValue
    private Long graphId;

    private String name;
    private String category;

    @Relationship(type = "USED_P",direction = Relationship.INCOMING)
    private List<Goal> goalList=new ArrayList<>();

    public Plugin(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Plugin() {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
