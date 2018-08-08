package slr.master.stratospherique.command;

import slr.master.stratospherique.domain.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by ASUS on 01/08/2018.
 */
public class GqmForm {

    private Goal goal;
    private List<Tool> tools;
    private List<Plugin> plugins;
    private List<Output> outputs;
    private Problem issue;
    private String viewPoint;
    private int pluginNbr;
    private int toolNbr;
    private List<EFormat> eFormats;
    private List<ESource> eSources;
    private UserType userType;
    private Filtering filtering;

    public GqmForm(Goal goal, List<Tool> tools, List<Plugin> plugins, List<Output> outputs, Problem issue, List<EFormat> eFormats, List<ESource> eSources, UserType userType,Filtering filtering) {
        this.goal = goal;
        this.tools = tools;
        this.plugins = plugins;
        this.outputs = outputs;
        this.issue = issue;
        this.eFormats = eFormats;
        this.eSources = eSources;
        this.userType = userType;
        this.pluginNbr=plugins.size();
        this.toolNbr=tools.size();
        if (this.goal.getTarget().equals("PM")){
            this.viewPoint="Process Miner View Point";
        }else this.viewPoint="Related Business Process Analyst";
        this.filtering=filtering;
    }
                                                            //setters


    public void setFiltering(Filtering filtering) {
        this.filtering = filtering;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }

    public void setPlugins(List<Plugin> plugins) {
        this.plugins = plugins;
    }

    public void setOutputs(List<Output> outputs) {
        this.outputs = outputs;
    }

    public void setIssue(Problem issue) {
        this.issue = issue;
    }

    public void setViewPoint(String viewPoint) {
        this.viewPoint = viewPoint;
    }

    public void setPluginNbr(int pluginNbr) {
        this.pluginNbr = pluginNbr;
    }

    public void setToolNbr(int toolNbr) {
        this.toolNbr = toolNbr;
    }

    public void seteFormats(List<EFormat> eFormats) {
        this.eFormats = eFormats;
    }

    public void seteSources(List<ESource> eSources) {
        this.eSources = eSources;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

                                    //getters


    public Filtering getFiltering() {
        return filtering;
    }

    public Goal getGoal() {
        return goal;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public List<Plugin> getPlugins() {
        return plugins;
    }

    public List<Output> getOutputs() {
        return outputs;
    }

    public Problem getIssue() {
        return issue;
    }

    public String getViewPoint() {
        return viewPoint;
    }

    public int getPluginNbr() {
        return pluginNbr;
    }

    public int getToolNbr() {
        return toolNbr;
    }

    public List<EFormat> geteFormats() {
        return eFormats;
    }

    public List<ESource> geteSources() {
        return eSources;
    }

    public UserType getUserType() {
        return userType;
    }
}
