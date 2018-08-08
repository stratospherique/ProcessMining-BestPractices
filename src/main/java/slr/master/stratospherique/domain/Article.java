package slr.master.stratospherique.domain;

import com.sun.javafx.beans.IDProperty;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 23/07/2018.
 */
@NodeEntity(label = "Article")
public class Article {
    @Id @GeneratedValue private Long graphId;
    private String title;
    private Integer year;

    @Relationship(type="DEFINE")
    private List<Goal> goalList=new ArrayList<>();

    @Relationship(type="IN_CONTEXT")
    private Context context;

    @Relationship(type="CONTRIBUTE")
    private Contribution contribution;

    public Long getGraphId() {
        return graphId;
    }

    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public Integer getYear(){
        return year;
    }
    public void setYear(Integer year){
        this.year=year;
    }

    public Article(String title, Integer year) {
        this.title = title;
        this.year = year;
    }

    public Article() {
    }
}
