package ruCh.messenger.rea.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ruCh.messenger.rea.model.chat.InputMessage;
import ruCh.messenger.rea.model.chat.OutputMessage;

import java.util.Date;

@RestController
public class GitController {

    @RequestMapping(value = "/change/text", method = RequestMethod.POST)
    public OutputMessage changeText(@RequestBody InputMessage msg) {


        return new OutputMessage(msg.getFrom(), msg.getText(), new Date().toString());
    }
}
