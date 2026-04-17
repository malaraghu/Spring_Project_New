package com.raghu.project3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController//REPRESENTATIONAL STATE TRANSFOR
//@RequestMapping("/home")
public class HomeController {
    @RequestMapping("/greet")
//    @ResponseBody
/*IF WE ARE USING THE @Controller THIS ALONE WILL GIVE EXTRA
   OUTPUT LIKE FILE NOT FOUND OUTPUT WILL COME BUT WITH 404 ERROR*/

    public String greet(){
        return "welcome to my first home controller ..";
    }
}
