package ruCh.messenger.rea.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ruCh.messenger.rea.model.chat.InputMessage;
import ruCh.messenger.rea.model.chat.OutputMessage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@RestController
public class GitController {

    static String fileName = "/home/a/temp/writtenByJava.txt";

    @RequestMapping(value = "/change/text", method = RequestMethod.POST)
    public OutputMessage changeText(@RequestBody InputMessage msg) {

        System.out.println("Writing to file " + fileName);

        writeToFileHelper(fileName, msg.getText());

        return new OutputMessage(msg.getFrom(), msg.getText() + " - this is response!", new Date().toString());
    }

    @RequestMapping("/read/text")
    public String readWrittenText() {

        String text = null;
        try {
            text = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static void writeToFileHelper(String fileName, String text) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            bw.write(text);

            System.out.println("Done!!!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


