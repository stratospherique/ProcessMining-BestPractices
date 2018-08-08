package slr.master.stratospherique.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import slr.master.stratospherique.domain.UserType;

import java.util.List;

/**
 * Created by ASUS on 30/07/2018.
 */

@Repository
public interface UserTypeRepository extends Neo4jRepository<UserType,Long> {
    @Query("match (a)-[*3]-(h:UserType) \n" +
            "where id(a)={id}  \n" +
            "return h")
    UserType findUser(@Param("id") Long id);
}
