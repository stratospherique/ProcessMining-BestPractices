package slr.master.stratospherique.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import slr.master.stratospherique.domain.Filtering;

import java.util.List;

/**
 * Created by ASUS on 01/08/2018.
 */
@Repository
public interface FilteringRepository extends Neo4jRepository<Filtering,Long> {
    @Query("match (a)--(h:Filtering) \n" +
            "where id(a)={id}  \n" +
            "return h")
    Filtering findFilter(@Param("id") Long id);
}
