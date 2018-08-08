package slr.master.stratospherique.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import slr.master.stratospherique.domain.Sector;

/**
 * Created by ASUS on 30/07/2018.
 */
@Repository
public interface SectorRepository extends Neo4jRepository<Sector,Long> {

}
