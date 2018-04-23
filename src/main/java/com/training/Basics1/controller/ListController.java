package com.training.Basics1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ListController {

    private List<String> names = new ArrayList<>();

    /**
     * Way 1 to make a GET endpoint and pass a name as REQUEST Parameter
     * @param name
     * @return
     */
    @GetMapping("/addName")
    public String addName(@RequestParam String name) {
        names.add(name);
        return "Added";
    }

    /**
     * Way 2 to make a GET endpoint and pass a name as REQUEST Parameter
     * @param name
     * @return
     */
    @RequestMapping(value = "/addName1", method = RequestMethod.GET)
    public String addName1(@RequestParam String name) {
        names.add(name);
        return "Added";
    }

    /**
     * Way 3 to make a GET endpoint and pass a name as PATH Parameter
     * @param name
     * @return
     */
    @RequestMapping(value = "/addName2/{name}", method = RequestMethod.GET)
    public String addName2(@PathVariable String name) {
        names.add(name);
        return "Added";
    }

    @GetMapping("/getNames1")
    public List<String> getNames1() {
        return names;
    }

    @GetMapping("/getNames2")
    public ResponseEntity<List> getNames2() {
        return new ResponseEntity<>(names, HttpStatus.OK);
    }

}
