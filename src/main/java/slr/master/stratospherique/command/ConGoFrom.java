package slr.master.stratospherique.command;

import slr.master.stratospherique.domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 29/07/2018.
 */
public class ConGoFrom {

    public ConGoFrom() {
    }

    private List<String> sysTypes;
   private List<String> userTypes;
    private List<String> eFormats;
    private List<String> eSources;

    private List<String> inputs;

    public ConGoFrom(List<String> sysTypes, List<String> userTypes, List<String> eFormats, List<String> eSources, List<String> inputs) {
        this.sysTypes = sysTypes;
        this.userTypes = userTypes;
        this.eFormats = eFormats;
        this.eSources = eSources;
        this.inputs = inputs;
    }

    public List<String> getSysTypes() {
        return sysTypes;
    }

    public List<String> getUserTypes() {
        return userTypes;
    }


    public List<String> geteFormats() {
        return eFormats;
    }

    public List<String> geteSources() {
        return eSources;
    }



    public void setSysTypes(List<String> sysTypes) {
        this.sysTypes = sysTypes;
    }

    public void setUserTypes(List<String> userTypes) {
        this.userTypes = userTypes;
    }

    public void addUserTypes(String userType) {
        if (this.userTypes==null){
        this.userTypes=new ArrayList<String>();
        }
        this.userTypes.add(userType);
    }

    public void seteFormats(List<String> eFormats) {
        this.eFormats = eFormats;
    }

    public void seteSources(List<String> eSources) {
        this.eSources = eSources;
    }

    public List<String> getInputs() {
        return inputs;
    }

    public void setInputs(List<String> inputs) {
        this.inputs = inputs;
    }
}
