package com.hello.typeconverter.controller;

import com.hello.typeconverter.dto.FormV2;
import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormatterController {

    @GetMapping("/formatter/edit")
    public String formatterForm(Model model) {

        FormV2 form = FormV2.builder()
            .number(10000)
            .localDateTime(LocalDateTime.now())
            .build();

        model.addAttribute("form", form);
        return "formatter-form";
    }

    @PostMapping("/formatter/edit")
    public String formatterEdit(@ModelAttribute FormV2 form, Model model) {

        model.addAttribute("form", form);
        return "formatter-view";
    }
}
