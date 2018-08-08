package slr.master.stratospherique.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import slr.master.stratospherique.command.InsertionForm;
import slr.master.stratospherique.domain.Goal;

import java.util.List;

/**
 * Created by ASUS on 24/07/2018.
 */
@Repository
public interface GoalRepository extends Neo4jRepository<Goal,Long> {

    @Query("match (n:Goal)" +
            "where n.target contains {target}" +
            "return n")
   Iterable<Goal> findGoalByTarget(@Param("target") String target);
        @Transactional
        @Query("match (a:Goal)-[*3]-(c) \n" +
                "where c.uType={user} and {user} is not null \n" +
                "match (a)-[*3]-(e) \n" +
                "where e.source={lsource}  and {lsource} is not null  \n" +
                "match (a)-[*3]-(h) \n" +
                "where h.input={input}  and {input} is not null  \n" +
                "optional match (a)-[*3]-(d)\n" +
                "where d.typeSys={systype}  and {systype} is not null \n" +
                "optional match (a)-[*3]-(g) \n" +
                "where g.format={lformat}  and {lformat} is not null  \n" +
                "return a")
    Iterable<Goal> findGoalByContext(@Param("user") String user, @Param("systype") String systype, @Param("lsource") String lsource, @Param("lformat") String lformat, @Param("input") String input);

    @Query("match (n:Goal)" +
            "where id(n)={id}" +
            "return n")
    Goal findGoalById(@Param("id") Long id);

    @Query("WITH {form} as form\n" +
            "with form[0] as title,\n" +
                    "toInteger(form[1]) as year, \n" +
                    "split(toUpper(form[7]),',') as sysTypes,\n" +
                    "collect(form[12]) as goal1s,\n" +
                    "form[13] as goalType1,\n" +
                    "split(toUpper(form[14]),',') as tools1,\n" +
                    "split(toUpper(form[15]),',') as plugins1,\n" +
                    "toUpper(form[16]) as type1,\n" +
                    "split(toUpper(form[18]),',') as outputs1,\n" +
                    "collect(form[19]) as problem1s,\n" +
                    "collect(form[20]) as goal2s,\n" +
                    "form[21] as goalType2,\n" +
                    "split(toUpper(form[22]),',') as tools2,\n" +
                    "split(toUpper(form[23]),',') as plugins2,\n" +
                    "toUpper(form[24]) as type2,\n" +
                    "split(toUpper(form[26]),',') as outputs2,\n" +
                    "collect(form[27]) as problem2s,\n" +
                    "collect(form[28]) as goal3s,\n" +
                    "form[29] as goalType3,\n" +
                    "split(toUpper(form[30]),',') as tools3,\n" +
                    "split(toUpper(form[31]),',') as plugins3,\n" +
                    "toUpper(form[32]) as type3,\n" +
                    "split(toUpper(form[34]),',') as outputs3, \n" +
                    "collect(form[35]) as problem3s,\n" +
                    "collect(toUpper(form[17])) as filterings1,\n" +
                    "collect(toUpper(form[25])) as filterings2,\n" +
                    "collect(toUpper(form[33])) as filterings3,\n" +
                    "collect(toUpper(form[11])) as utypes,\n" +
                    "collect(toUpper(form[8])) as lsources,\n" +
                    "split(toUpper(form[10]),',') as inputs,\n" +
                    "split(form[6],',') as lsizes,\n" +
                    "split(toUpper(form[9]),',') as lformats, \n" +
                    "split(toUpper(form[4]),',') as sysnames,\n" +
                    "form[2] as cont, \n" +
                    "split(form[5],',') as sectors,\n" +
                    "collect(form[3]) as apptypes\n" +
            "//insertion\n" +
            "create (a1:Article{title:title,year:toInteger(year)})\n" +
            "foreach (apptype in apptypes |\n" +
            "create (b:Contribution{cType:apptype,objectif:cont})\n" +
            "create unique (a1)-[:CONTRIBUTE]->(b)\n" +
            ")\n" +
            "merge (a1)-[:IN_CONTEXT]->(c1:Context)\n" +

            "//context\n" +
            "foreach (lsize in lsizes|\n" +
            "merge (c1)-[:L_SIZE]->(l1:LSize{lSize:lsize})\n" +

            "foreach(inp in inputs |\n" +
            "merge (c:Input{input:inp})\n" +
            "create unique (c1)<-[:AS_INPUT]-(c)\n" +
            ")\n" +
            "foreach (sysType in sysTypes|\n" +
            "merge (y1:NatSys{typeSys:sysType})\n" +
            "Create unique (c1)-[:S_Kind]->(y1)\n" +
            ")\n" +
            "foreach (sector in sectors|\n" +
            "merge (r1:Sector{conS1:sector})\n" +
            "create unique (c1)-[:DOMAIN]->(r1)\n" +
            ")\n" +
            "\n" +
            "foreach (sysname in sysnames|\n" +
            "merge (n1:SysName{name:sysname})\n" +
            "Create unique (c1)-[:WITH_IN]->(n1)\n" +
            ")\n" +
            "foreach (lformat in lformats|\n" +
            "merge (v1:EFormat{format:lformat})\n" +
            "create unique (c1)-[:EXT]->(v1)\n" +
            ")\n" +
            "foreach (lsource in lsources |\n" +
            "merge (w1:ESource{source:lsource})\n" +
            "create unique (c1)-[:SOURCE]->(w1)\n" +
            ")\n" +
            "foreach (utype in utypes |\n" +
            "merge (u1:UserType{uType:utype})\n" +
            "create unique (c1)-[:USED_BY]->(u1)\n" +
            "))\n" +
            "//context end\n" +
            "foreach (goal1 in goal1s |\n" +
            "create (i1:Goal{intention:goal1,target:goalType1})\n" +
            "create unique (a1)-[:DEFINE]->(i1)\n" +
            "\n" +
            "foreach (tool1 in tools1|\n" +
            "merge (t1:Tool{toolU:tool1})\n" +
            "create unique (i1)-[:USED_T]->(t1)\n" +
            ")\n" +
            "foreach (problem1 in problem1s |\n" +
            "merge (e1:Problem{unrIssue:problem1})\n" +
            "create unique (i1)-[:FAIL_TO]->(e1)\n" +
            ")\n" +
            "foreach (filtering in filterings1 |\n" +
            "merge (g1:Filtering{fil:filtering})\n" +
            "create unique (i1)-[:USED_F]->(g1)\n" +
            ")\n" +
            "foreach (plugin1 in plugins1|\n" +
            "merge (p1:Plugin{name:plugin1,category:type1})\n" +
            "create unique (i1)-[:USED_P]->(p1)\n" +
            ")\n" +
            "foreach (output1 in outputs1|\n" +
            "merge (o1:Output{out:output1})\n" +
            "create unique (i1)-[:OBTAINED]->(o1)\n" +
            "))\n" +
            "//g2\n" +
            "foreach (goal2 in goal2s |\n" +
            "create (i2:Goal{intention:goal2,target:goalType2})\n" +
            "create unique (a1)-[:DEFINE]->(i2)\n" +
            "\n" +
            "foreach (tool2 in tools2|\n" +
            "merge (t2:Tool{toolU:tool2})\n" +
            "create unique (i2)-[:USED_T]->(t2)\n" +
            ")\n" +
            "foreach (problem2 in problem2s |\n" +
            "merge (e2:Problem{unrIssue:problem2})\n" +
            "create unique (i2)-[:FAIL_TO]->(e2)\n" +
            ")\n" +
            "foreach (filtering in filterings2 |\n" +
            "merge (g2:Filtering{fil:filtering})\n" +
            "create unique (i2)-[:USED_F]->(g2)\n" +
            ")\n" +
            "foreach (plugin2 in plugins2|\n" +
            "merge (p2:Plugin{name:plugin2,category:type2})\n" +
            "create unique (i2)-[:USED_P]->(p2)\n" +
            ")\n" +
            "foreach (output2 in outputs2|\n" +
            "merge (o2:Output{out:output2})\n" +
            "create unique (i2)-[:OBTAINED]->(o2)\n" +
            "))\n" +
            "//g3\n" +
            "foreach (goal3 in goal3s |\n" +
            "create (i3:Goal{intention:goal3,target:goalType3})\n" +
            "create unique (a1)-[:DEFINE]->(i3)\n" +
            "\n" +
            "foreach (tool3 in tools3|\n" +
            "merge (t3:Tool{toolU:tool3})\n" +
            "create unique (i3)-[:USED_T]->(t3)\n" +
            ")\n" +
            "foreach (problem3 in problem3s |\n" +
            "merge (e3:Problem{unrIssue:problem3})\n" +
            "create unique (i3)-[:FAIL_TO]->(e3)\n" +
            ")\n" +
            "foreach (filtering in filterings3 |\n" +
            "merge (g3:Filtering{fil:filtering})\n" +
            "create unique (i3)-[:USED_F]->(g3)\n" +
            ")\n" +
            "foreach (plugin3 in plugins3 |\n" +
            "merge (p3:Plugin{name:plugin3,category:type3})\n" +
            "create unique (i3)-[:USED_P]->(p3)\n" +
            ")\n" +
            "foreach (output3 in outputs3 |\n" +
            "merge (o3:Output{out:output3})\n" +
            "create unique (i3)-[:OBTAINED]->(o3)\n" +
            "))")
    void saveUseCase(@Param("form") List<String> form);

}
