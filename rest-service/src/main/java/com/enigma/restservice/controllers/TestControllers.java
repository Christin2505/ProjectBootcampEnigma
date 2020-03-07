package com.enigma.restservice.controllers;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestControllers {

    @GetMapping(produces = "text/html")
    public String testGet(@RequestParam("name") String[] names, HttpServletRequest request,
            HttpServletResponse response) {
        Enumeration<String> e = request.getHeaderNames();
        String result = "";

        while (e.hasMoreElements()) {
            String header = e.nextElement();
            String value = request.getHeader(header);
            result += header + ":" + value + "<br>";
        }
        result += "<br>";

        response.setContentType("text/html;charset=UTF-8");

        for (

        String name : names) {
            result += "[GET] <b> Hello </b>" + name + "<br>";
        }
        return result;
    }

    @PostMapping(produces = "text/html")
    public String testPost(@RequestParam String name, @RequestParam("age") int age) {
        return "[POST] <b>Hello </b>" + name + ",Your Age Is " + age;
    }
}
