package root.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public ModelAndView getIndexPage(){
        ModelAndView indexModel = new ModelAndView("index");
        return indexModel;
    }
}
