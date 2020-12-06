package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

    // url : http://localhost:8080/hello
    // result :
    // 안녕하세요, 손님
    // message : hello, world!
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello, world!");
        return "hello";
    }

    // url : http://localhost:8080/hello-mvc?name=jogilsang
    // result :
    // message : jogilsang
    @GetMapping("hello-mvc")
    public String hellomvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-mvc";
    }

    // url : http://localhost:8080/hello-string?name=jogilsang
    // result : hello jogilsang
    @GetMapping("hello-string")
    @ResponseBody
    public String hellostring(@RequestParam("name") String name) {
        return "hello " + name;
    }

    // url : http://localhost:8080/hello-api?name=jogilsang
    // result : {"name":"jogilsang"}
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloapi(@RequestParam("name") String name) {

        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }

    static class Hello{
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}