package slr.master.stratospherique.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slr.master.stratospherique.command.InsertionForm;
import slr.master.stratospherique.domain.Goal;
import slr.master.stratospherique.repository.GoalRepository;

import java.util.List;

/**
 * Created by ASUS on 24/07/2018.
 */
@Service
public class GoalServiceImp implements GoalService{
    private static Logger logger= org.slf4j.LoggerFactory.getLogger(Goal.class);

    @Autowired
    private final GoalRepository goalRepository;

    public GoalServiceImp(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @Override
    public Iterable<Goal> findGoalsByTarget(String target){
        Iterable<Goal> result=goalRepository.findGoalByTarget(target);
        return  result;
    }

    @Override
    public Iterable<Goal> findGoals(String user,String systype,String lsource,String lformat,String sector){
        Iterable<Goal> result=goalRepository.findGoalByContext(user,systype,lsource,lformat,sector);
    return result;
    }

    @Override
    public void insertSlr(List<String> insertionForm){
        goalRepository.saveUseCase(insertionForm);
    }

}
