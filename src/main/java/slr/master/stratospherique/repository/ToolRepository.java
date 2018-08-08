package slr.master.stratospherique.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import slr.master.stratospherique.domain.Tool;

import java.util.List;

/**
 * Created by ASUS on 01/08/2018.
 */
@Repository
public interface ToolRepository extends Neo4jRepository<Tool,Long> {

    @Query("Match (a:Goal)--(b:Tool) \n" +
            "where id(a)={id} \n" +
            "return b")
    List<Tool> findTool(@Param("id") Long id);
}
