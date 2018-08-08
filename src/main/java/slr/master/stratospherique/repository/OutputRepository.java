package slr.master.stratospherique.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import slr.master.stratospherique.domain.Output;

import java.util.List;

/**
 * Created by ASUS on 01/08/2018.
 */
@Repository
public interface OutputRepository extends Neo4jRepository<Output,Long> {
    @Query("Match (a:Goal)--(b:Output)\n " +
            "where id(a)={id}\n" +
            "return b")
    List<Output> findOutput(@Param("id") Long id);
}
