package slr.master.stratospherique.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import slr.master.stratospherique.command.ConGoFrom;
import slr.master.stratospherique.command.GoalMetrics;
import slr.master.stratospherique.command.GqmForm;
import slr.master.stratospherique.command.InsertionForm;
import slr.master.stratospherique.converters.ToList;
import slr.master.stratospherique.converters.ToSlrForm;
import slr.master.stratospherique.repository.*;
import slr.master.stratospherique.service.GoalService;
import slr.master.stratospherique.service.GoalServiceImp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

/**
 * Created by ASUS on 29/07/2018.
 */
@Controller
public class GoalController {

   private EFormatRepository eFormatRepository;
    private ESourceRepository eSourceRepository;
    private InputRepository inputRepository;
    private SysTypeRepository sysTypeRepository;
    private UserTypeRepository userTypeRepository;
    private GoalService goalService;
    private GoalRepository goalRepository;
    private ToolRepository toolRepository;
    private PluginRepository pluginRepository;
    private OutputRepository outputRepository;
    private ProblemRepository problemRepository;
    private FilteringRepository filteringRepository;
    public int count=0;
    @Autowired
    public void setFilteringRepository(FilteringRepository filteringRepository) {
        this.filteringRepository = filteringRepository;
    }

    @Autowired
    public void setGoalRepository(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }
    @Autowired
    public void setToolRepository(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }
    @Autowired
    public void setOutputRepository(OutputRepository outputRepository) {
        this.outputRepository = outputRepository;
    }
    @Autowired
    public void setPluginRepository(PluginRepository pluginRepository) {
        this.pluginRepository = pluginRepository;
    }
    @Autowired
    public void setProblemRepository(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    @Autowired
    public void seteSourceRepository(ESourceRepository eSourceRepository) {
        this.eSourceRepository = eSourceRepository;
    }
    @Autowired
    public void seteFormatRepository(EFormatRepository eFormatRepository) {
        this.eFormatRepository = eFormatRepository;
    }

    @Autowired
    public void setInputRepository(InputRepository inputRepository) {
        this.inputRepository = inputRepository;
    }

    @Autowired
    public void setSysTypeRepository(SysTypeRepository sysTypeRepository) {
        this.sysTypeRepository = sysTypeRepository;
    }
    @Autowired
    public void setUserTypeRepository(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    @Autowired
    public void setGoalService(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping("/goals")
    public String exploreGoals(Model model){
        model.addAttribute("outform",new ConGoFrom());
        model.addAttribute("slrform",new ConGoFrom(ToSlrForm.convertSysType(sysTypeRepository.findAll()),ToSlrForm.convertUserType(userTypeRepository.findAll()),ToSlrForm.convertEFormat(eFormatRepository.findAll()),ToSlrForm.convertESource(eSourceRepository.findAll()),ToSlrForm.convertInput(inputRepository.findAll())));
        return "/goals";
    }

   @RequestMapping(value = "/goals/search",method=RequestMethod.POST)
    public String getGoals(Model model,@RequestParam("userTypeSelect") String userType,@RequestParam("lsource") String lsource,@RequestParam("input") String input,@RequestParam(value = "format",required = false) String format,@RequestParam(value = "natsys",required = false) String natsys){
        model.addAttribute("slrform",new ConGoFrom(ToSlrForm.convertSysType(sysTypeRepository.findAll()),ToSlrForm.convertUserType(userTypeRepository.findAll()),ToSlrForm.convertEFormat(eFormatRepository.findAll()),ToSlrForm.convertESource(eSourceRepository.findAll()),ToSlrForm.convertInput(inputRepository.findAll())));
         model.addAttribute("goalList",goalService.findGoals(userType,natsys,lsource,format,input));
        return "/goals";
    }
 /* @RequestMapping(value = "/goals/search",method=RequestMethod.POST)
  public String getGoals(Model model,@ModelAttribute("outform") ConGoFrom conGoFrom){
      List<String> out=new ArrayList<String>();
      System.out.println(conGoFrom.geteFormats().get(0));
      out=ToSlrForm.displayGols(conGoFrom);
      model.addAttribute("slrform",new ConGoFrom(ToSlrForm.convertSysType(sysTypeRepository.findAll()),ToSlrForm.convertUserType(userTypeRepository.findAll()),ToSlrForm.convertEFormat(eFormatRepository.findAll()),ToSlrForm.convertESource(eSourceRepository.findAll()),ToSlrForm.convertInput(inputRepository.findAll())));
      model.addAttribute("goalList",goalService.findGoals(out.get(0),out.get(1),out.get(2),out.get(3),out.get(4)));
      return "/goals";
  } */

    @RequestMapping(value="goals/search/{id}",method = RequestMethod.GET)
    public String getFiche(@PathVariable Long id,Model model){
        model.addAttribute("gqm", new GqmForm(goalRepository.findGoalById(id),toolRepository.findTool(id),pluginRepository.findPlugin(id),outputRepository.findOutput(id),problemRepository.findProblem(id),eFormatRepository.findFormat(id),eSourceRepository.findSource(id),userTypeRepository.findUser(id),filteringRepository.findFilter(id)));
        return "/gqm"   ;
    }



    @RequestMapping("/insertion")
    public String getInsertion(Model model){
        InsertionForm insertionForm=new InsertionForm();
        insertionForm.addGoalMetrics();
        insertionForm.addGoalMetrics();
        insertionForm.addGoalMetrics();
        model.addAttribute("insForm",insertionForm);
        return "/insertion";
    }

    @RequestMapping(value = "/newInsertion",method = RequestMethod.POST)
    public String saveInsertion(@ModelAttribute InsertionForm insertionForm){

        try {
            goalService.insertSlr(ToList.convert(insertionForm));
        }catch (Exception e){e.printStackTrace();}
            return "/index";
    }

  /*  @RequestMapping(value = "addGm/{insForm}",method = RequestMethod.GET)
    public String addMetrics(Model model,@ModelAttribute InsertionForm insertionForm){

        model.addAttribute("insForm",insertionForm);
        return "/insertion";
    }

*/
}
