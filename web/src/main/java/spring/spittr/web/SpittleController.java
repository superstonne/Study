package spring.spittr.web;

import spring.spittr.Spittle;
import spring.spittr.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = "0x7fffffffffffffffL";
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Model model) {
          //此处如果没有指定Key的名字，默认会是spittleList
//        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//        //model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//        return "spittles";
//    }
//    //如果不想使用Spring的Model，我们可以传入Java的集合类作为参数
//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Map model) {
//        model.put("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//        return "spittles";
//    }
//    //除此之外我们也可以不指定View的名字，直接返回spittleList, 此时View 名字默认为请求的路径名字，返回的list会包装入model
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Spittle> spittles() {
//        return spittleRepository.findSpittles(Long.MAX_VALUE, 20);
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showSpittle(@RequestParam(value = "spittle_id") long spittleId, Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }
}
