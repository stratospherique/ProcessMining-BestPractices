package slr.master.stratospherique.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import slr.master.stratospherique.domain.Input;

import java.util.List;

/**
 * Created by ASUS on 31/07/2018.
 */
@Repository
public interface InputRepository extends Neo4jRepository<Input,Long> {
    @Query("match (a)-[*3]-(h:Input) \n" +
            "where id(a)={id}  \n" +
            "return h")
    List<Input> findInput(@Param("id") Long id);
}
