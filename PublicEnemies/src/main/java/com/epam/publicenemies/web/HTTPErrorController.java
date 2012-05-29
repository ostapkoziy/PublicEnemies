package com.epam.publicenemies.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Handles errors
 * @author I. Kostyrko
 *
 */
@Controller
public class HTTPErrorController {

    @RequestMapping(value="/errors/404.html")
    public String handle404() {
        return "error404";
    }

    @RequestMapping(value="/errors/500.html")
    public String handle500(){
        return "error500";
    }

}