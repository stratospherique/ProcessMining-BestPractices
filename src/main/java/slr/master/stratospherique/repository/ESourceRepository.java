package slr.master.stratospherique.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import slr.master.stratospherique.domain.ESource;

import java.util.List;

/**
 * Created by ASUS on 30/07/2018.
 */
@Repository
public interface ESourceRepository extends Neo4jRepository<ESource,Long> {
    @Query("match (a)-[*3]-(h:ESource) \n" +
            "where id(a)={id}  \n" +
            "return h")
    List<ESource> findSource(@Param("id") Long id);
}
