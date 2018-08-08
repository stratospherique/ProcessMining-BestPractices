package slr.master.stratospherique.domain;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 23/07/2018.
 */

@NodeEntity(label = "Goal")
public class Goal {
    @Id
    @GeneratedValue
    private Long id;

    private String intention;
    private String target;
    
    @Relationship(type = "USED_T")
    private List<Tool> tools=new ArrayList<>();

    @Relationship(type = "USED_F")
    private Filtering filtering;

    @Relationship(type = "USED_P")
    private List<Plugin> plugins=new ArrayList<>();

    @Relationship(type = "FAIL_TO")
    private Problem problem;

    @Relationship(type = "OBTAINED")
    private List<Output> outputs=new ArrayList<>();

    @Relationship(type="DEFINE",direction = Relationship.INCOMING)
    private Article article;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntention(){
        return intention;
    }
    public void setIntention(String intention){
        this.intention=intention;
    }
    public String getTarget(){
        return target;
    }
    public void setTarget(String target){
        this.target=target;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Goal(String intention, String target) {
        this.intention = intention;
        this.target = target;
    }

    public Goal() {
    }
}
