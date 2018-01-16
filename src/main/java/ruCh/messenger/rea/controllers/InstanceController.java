package ruCh.messenger.rea.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ruCh.messenger.rea.repositories.InstanceRepository;

@Controller
public class InstanceController {

    private InstanceRepository instanceRepository;

    public InstanceController(InstanceRepository instanceRepository) {
        this.instanceRepository = instanceRepository;
    }

    @RequestMapping("/instances")
    public String getInstances(Model model) {
        model.addAttribute("instances", instanceRepository.findAll());
        return "instances";
    }
}
