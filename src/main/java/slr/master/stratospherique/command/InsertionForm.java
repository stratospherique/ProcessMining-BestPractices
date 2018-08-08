package slr.master.stratospherique.command;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 04/08/2018.
 */
public class InsertionForm  implements Serializable{

    private String title;
    private String year;
    private String contribution;
    private String appType;
    private String sysName;
    private String sysType;
    private String sector;
    private String input;
    private String format;
    private String lsize;
    private String lsource;
    private String userType;

    private List<GoalMetrics> goalMetrics;

    public InsertionForm(String title, String year, String contribution, String appType, String sysName, String sysType, String sector, String input, String format, String lsize, String lsource, String userType, List<GoalMetrics> goalMetrics) {
        this.title = title;
        this.year = year;
        this.contribution = contribution;
        this.appType = appType;
        this.sysName = sysName;
        this.sysType = sysType;
        this.sector = sector;
        this.input = input;
        this.format = format;
        this.lsize = lsize;
        this.lsource = lsource;
        this.userType = userType;
        this.goalMetrics = goalMetrics;
    }



    public InsertionForm() {
        this.goalMetrics=new ArrayList<GoalMetrics>();
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysType() {
        return sysType;
    }

    public void setSysType(String sysType) {
        this.sysType = sysType;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLsize() {
        return lsize;
    }

    public void setLsize(String lsize) {
        this.lsize = lsize;
    }

    public String getLsource() {
        return lsource;
    }

    public void setLsource(String lsource) {
        this.lsource = lsource;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<GoalMetrics> getGoalMetrics() {

        return goalMetrics;
    }

    public void setGoalMetrics(List<GoalMetrics> goalMetrics) {
        this.goalMetrics = goalMetrics;
    }



    public void addGoalMetrics(){
        this.goalMetrics.add(new GoalMetrics());
    }
}
