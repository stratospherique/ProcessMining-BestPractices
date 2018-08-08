package slr.master.stratospherique.domain;

/**
 * Created by ASUS on 23/07/2018.
 */

import org.neo4j.ogm.annotation.*;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 23/07/2018.
 */
@NodeEntity(label = "EFormat")
public class EFormat {
    @Id
    @GeneratedValue private Long id;

    private String format;

    public EFormat(){}

    @Relationship(type = "EXT",direction = Relationship.INCOMING)
    private List<Context> contexts=new ArrayList<>();

    public EFormat(String format, Long id) {
        this.format = format;
        this.id = id;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public List<Context> getContexts() {
        return contexts;
    }

    public void addToContexts(Context context) {
        if(this.contexts==null){
            this.contexts=new ArrayList<Context>();
        }
        this.contexts.add(context);
    }
}
