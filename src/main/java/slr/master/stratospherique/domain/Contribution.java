package slr.master.stratospherique.domain;

import org.neo4j.ogm.annotation.*;

/**
 * Created by ASUS on 23/07/2018.
 */
@NodeEntity(label = "Contribution")
public class Contribution {
    @Id @GeneratedValue
    private Long graphId;

    @Relationship(type = "CONTRIBUTE",direction = Relationship.INCOMING)
    private Article article;

    private String cType;
    private String objectif;

    public Contribution(String cType, String objectif) {
        this.cType = cType;
        this.objectif = objectif;
    }

    public Contribution() {
    }

    public Long getGraphId() {
        return graphId;
    }

    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public String getcType() {
        return cType;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
