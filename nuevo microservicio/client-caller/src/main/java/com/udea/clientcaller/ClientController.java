package com.udea.clientcaller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {

    @Autowired
    ClientService clientService;

    public ClientController() {

    }

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/client")
    public String greetingAll() {
        return "greetingAll";
    }

    @RequestMapping("/client/{id}")
    @HystrixCommand(fallbackMethod =  "greetingDefault")
    public String greeting(Model model, @PathVariable("id") long id) {
        clientService = ClientCallerApplication.productoService();
        Client greeting = clientService.greeting(id);
        Map<String, Object> params = new HashMap<>();
        params.put("nombre", greeting.getClientName());
        params.put("email", greeting.getEmail());
        params.put("numero", greeting.getCellNumber());
        model.addAllAttributes(params);
        System.out.println(params);
        return "greeting";
    }

     public String greetingDefault(Model model, @PathVariable("id") long id) {
        Client greeting = clientService.greetingDefault();
        Map<String, Object> params = new HashMap<>();
        params.put("nombre", greeting.getClientName());
        params.put("email", greeting.getEmail());
        params.put("numero", greeting.getCellNumber());
        model.addAllAttributes(params);
        System.out.println(params);
        return "greeting";
    }
}
