package slr.master.stratospherique.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import slr.master.stratospherique.domain.Problem;

import java.util.List;

/**
 * Created by ASUS on 01/08/2018.
 */
@Repository
public interface ProblemRepository extends Neo4jRepository<Problem,Long>{
    @Query("Match (a:Goal)--(b:Problem) \n" +
            "where id(a)={id} \n" +
            "return b")
    Problem findProblem(@Param("id") Long id);
}
