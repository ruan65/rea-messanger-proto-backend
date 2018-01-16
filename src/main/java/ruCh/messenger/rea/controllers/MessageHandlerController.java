package ruCh.messenger.rea.controllers;


import org.springframework.http.HttpOutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ruCh.messenger.rea.model.Message;
import ruCh.messenger.rea.model.chat.InputMessage;
import ruCh.messenger.rea.model.chat.OutputMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MessageHandlerController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(InputMessage message) throws Exception{

        String time = new SimpleDateFormat("HH:mm").format(new Date());

        System.out.println("invoked");
        System.out.println(message.getFrom() + " >> "+message.getText());
        return new OutputMessage(message.getFrom(),message.getText(),time);

    }

}
