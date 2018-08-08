package slr.master.stratospherique.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import slr.master.stratospherique.domain.EFormat;

import java.util.List;

/**
 * Created by ASUS on 30/07/2018.
 */
@Repository
public interface EFormatRepository extends Neo4jRepository<EFormat,Long> {
    @Query("match (a)-[*3]-(h:EFormat) \n" +
            "where id(a)={id}  \n" +
            "return h")
    List<EFormat> findFormat(@Param("id") Long id);
}
