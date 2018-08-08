package slr.master.stratospherique.command;

import java.io.Serializable;

/**
 * Created by ASUS on 04/08/2018.
 */
public class GoalMetrics implements Serializable{
    private String intention;
    private String target;
    private String toolU;
    private String plugin;
    private String category;
    private String filtering;
    private String outputs;
    private String problem;

    public GoalMetrics(String intention, String target, String toolUs, String plugins, String category, String filtering, String outputs, String problem) {
        this.intention = intention;
        this.target = target;
        this.toolU = toolUs;
        this.plugin = plugins;
        this.category = category;
        this.filtering = filtering;
        this.outputs = outputs;
        this.problem = problem;
    }

    public GoalMetrics() {
    }

    public String getIntention() {
        return intention;
    }

    public String getTarget() {
        return target;
    }

    public String getToolU() {
        return toolU;
    }

    public String getPlugin() {
        return plugin;
    }

    public String getCategory() {
        return category;
    }

    public String getFiltering() {
        return filtering;
    }

    public String getOutputs() {
        return outputs;
    }

    public String getProblem() {
        return problem;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setToolU(String toolU) {
        this.toolU = toolU;
    }

    public void setPlugin(String plugin) {
        this.plugin = plugin;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setFiltering(String filtering) {
        this.filtering = filtering;
    }

    public void setOutputs(String outputs) {
        this.outputs = outputs;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
}
