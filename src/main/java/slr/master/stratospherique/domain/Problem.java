package slr.master.stratospherique.domain;

import org.neo4j.ogm.annotation.*;

/**
 * Created by ASUS on 24/07/2018.
 */
@NodeEntity(label = "Problem")
public class Problem {
    @Id
    @GeneratedValue
    private Long graphId;

    private String unrIssue;

    @Relationship(type = "FAIL_TO",direction = Relationship.INCOMING)
    private Goal goal;

    public Problem(String unrIssue) {
        this.unrIssue = unrIssue;
    }

    public Problem() {
    }

    public Long getGraphId() {
        return graphId;
    }

    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public String getUnrIssue() {
        return unrIssue;
    }

    public void setUnrIssue(String unrIssue) {
        this.unrIssue = unrIssue;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
}
