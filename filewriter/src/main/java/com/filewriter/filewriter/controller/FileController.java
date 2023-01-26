package com.filewriter.filewriter.controller;

//import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class FileController {


    @RequestMapping(value = "/getFile/{path}", method = RequestMethod.GET)
    public void getFile(@PathVariable String path) {
        try {
//            String path = "/Users/svrohith9/Downloads";
            path = "/" + path.replace('+', '/');
            Path fullPath = Paths.get(path);
            new WatchExample(fullPath, true).processEvents();
        } catch (Exception e) {
            System.err.println(e);
        }
    }


}
