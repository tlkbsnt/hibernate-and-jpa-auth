package fr.bsnt.controller;

import fr.bsnt.model.HelloBeans;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloBeanController {

    private MessageSource messageSource;
    // localhost:8080/hello
    //@RequestMapping(method = RequestMethod.GET, path = "/hello")
    @GetMapping(path="/hello")
    public String helloWorld(){
        return "Wel-Come to RestApi programming";
    }

    @GetMapping(path="/hello-beans")
    public HelloBeans helloBeans(){
        return new HelloBeans("Wel-Come bsnt coding  Beans World ");
    }
    // localhost:8080/hello/path/variable/tilak
    @GetMapping(path="/hello/path/variable/{name}")
    public HelloBeans helloPathVariable(@PathVariable String name){
        return new HelloBeans( String.format("Wel-Come to path variable %s", name ));
    }

    @GetMapping(path = "/message-internationalization")
    public String internationalization(MessageSource message){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,locale);
    }
}
