package slr.master.stratospherique.converters;

import slr.master.stratospherique.command.GoalMetrics;
import slr.master.stratospherique.command.InsertionForm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ASUS on 06/08/2018.
 */
public abstract class ToList {
    public static List<String> convert(InsertionForm insertionForm){
        List<String> result=new ArrayList<String>();
        List<String> subresult=new ArrayList<String>();
        result.add(insertionForm.getTitle());
        result.add(insertionForm.getYear());
        result.add(insertionForm.getContribution());
        result.add(insertionForm.getAppType());
        result.add(insertionForm.getSysName());
        result.add(insertionForm.getSector());
        result.add(insertionForm.getLsize());
        result.add(insertionForm.getSysType());
        result.add(insertionForm.getLsource());
        result.add(insertionForm.getFormat());
        result.add(insertionForm.getInput());
        result.add(insertionForm.getUserType());
        for(int i=0;i<3;i++){
            GoalMetrics goalMetricses=insertionForm.getGoalMetrics().get(i);
           // if(goalMetricses.getIntention()!="") {
                subresult.add(goalMetricses.getIntention());
                subresult.add(goalMetricses.getTarget());
                subresult.add(goalMetricses.getToolU());
                subresult.add(goalMetricses.getPlugin());
                subresult.add(goalMetricses.getCategory());
                subresult.add(goalMetricses.getFiltering());
                subresult.add(goalMetricses.getOutputs());
                subresult.add(goalMetricses.getProblem());
          //  }
        }
        Iterator it=subresult.iterator();
        while (it.hasNext()){
            result.add((String) it.next());
        }
        for(int i=0;i<result.size();i++){
            if (result.get(i)==""){
                result.set(i,null);
            }
        }

        return result;
    }
}
