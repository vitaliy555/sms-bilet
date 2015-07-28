package com.springapp.mvc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping(value = "hello2",method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", getTestData());
        return "hello";
    }

    private String getTestData() {
        String resulthtml;
        try {
            Document doc = Jsoup.connect("http://auto.ria.com/search/?marka_id=6&model_id=47&state=0#power_name=1&category_id=1&marka_id[0]=6&model_id[0]=47&s_yers[0]=0&po_yers[0]=0&state[0]=0&city[0]=0&currency=1&fuelRatesType=city&countpage=10").get();
            resulthtml = doc.outerHtml();
        } catch (Exception e) {
            System.out.println(e);;
            return e.getMessage();
        }
        return resulthtml;
    }

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(ModelMap model) {
        model.addAttribute("message", getTestData());
        return "hello";
    }

}