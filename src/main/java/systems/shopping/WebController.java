package systems.shopping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
    @RequestMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping("QRcode")
    public ModelAndView QRcode() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("QRcode");
        return modelAndView;
    }
}
