package slr.master.stratospherique.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ASUS on 29/07/2018.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/help")
    public String help(){
        return "help";
    }
}
