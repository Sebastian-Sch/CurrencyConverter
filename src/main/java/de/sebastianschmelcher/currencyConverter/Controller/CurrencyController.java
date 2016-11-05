package de.sebastianschmelcher.currencyConverter.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CurrencyController {

    @RequestMapping("/convert")
    public String convert(Model model) {
    	return "convert";
    }
}
