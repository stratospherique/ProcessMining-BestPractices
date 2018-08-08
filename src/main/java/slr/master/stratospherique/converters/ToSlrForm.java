package slr.master.stratospherique.converters;

import slr.master.stratospherique.command.ConGoFrom;
import slr.master.stratospherique.domain.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ASUS on 30/07/2018.
 */
public abstract class ToSlrForm {
    public static List<String> convertUserType(Iterable<UserType> list){
        Iterator it=list.iterator();
        List<String> result=new ArrayList<>();
        while (it.hasNext()){
            result.add(((UserType) it.next()).getuType());
        }
        return result;
    }

    public static List<String> convertSysType(Iterable<SysType> list){
        Iterator it=list.iterator();
        List<String> result=new ArrayList<>();
        while (it.hasNext()){
            result.add(((SysType) it.next()).getTypeSys());
        }
        return result;
    }

    public static List<String> convertESource(Iterable<ESource> list){
        Iterator it=list.iterator();
        List<String> result=new ArrayList<>();
        while (it.hasNext()){
            result.add(((ESource) it.next()).getSource());

        }
        return result;
    }

    public static List<String> convertEFormat(Iterable<EFormat> list){
        Iterator it=list.iterator();
        List<String> result=new ArrayList<>();
        while (it.hasNext()){
            result.add(((EFormat) it.next()).getFormat());
        }
        return result;
    }

    public static List<String> convertInput(Iterable<Input> list){
        Iterator it=list.iterator();
        List<String> result=new ArrayList<>();
        while (it.hasNext()){
            result.add(((Input) it.next()).getInp());
        }
        return result;
    }

  /*  public static List<String> displayGols(ConGoFrom conGoFrom){
        List<String> result=new ArrayList<String>();
        if (conGoFrom.getUserTypes().get(0)==null){
            result.add(null);
        }else result.add(conGoFrom.getUserTypes().get(0));

        if (conGoFrom.getSysTypes().get(0)==null){
            result.add(null);
        }else result.add(conGoFrom.getSysTypes().get(0));

        if (conGoFrom.geteSources().get(0)==null){
            result.add(null);
        }else result.add(conGoFrom.geteSources().get(0));

        if (conGoFrom.geteFormats().get(0)==null){
            result.add(null);
        }else result.add(conGoFrom.geteFormats().get(0));

        if (conGoFrom.getInputs().get(0)==null){
            result.add(null);
        }else result.add(conGoFrom.getInputs().get(0));

        result.add(conGoFrom.getSysTypes().get(0));
        result.add(conGoFrom.geteSources().get(0));
        result.add(conGoFrom.geteFormats().get(0));
        result.add(conGoFrom.getInputs().get(0));
        return result;
    } */

}
