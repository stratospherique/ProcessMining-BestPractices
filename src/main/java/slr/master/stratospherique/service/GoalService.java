package slr.master.stratospherique.service;


import slr.master.stratospherique.command.InsertionForm;
import slr.master.stratospherique.domain.Goal;

import java.util.List;

/**
 * Created by ASUS on 24/07/2018.
 */

public interface GoalService {
Iterable<Goal> findGoals(String user, String systype, String lsource, String lformat, String sector);

    Iterable<Goal> findGoalsByTarget(String target);

void insertSlr(List<String> insertionForm);
}
