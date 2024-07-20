package org.zz.springmvc.guide.parameter.controller.validation;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zz.springmvc.guide.parameter.vao.*;

@Controller
@RequestMapping("/validation/get")
public class ValidationGetController {

    @GetMapping("")
    public String index() {
        return "/validation/get/index";
    }

    @GetMapping("/testNumber")
    public String testNumber(@Valid NumberVao numberVao) {
        System.out.println("numberVao:" + numberVao);
        return "/ok";
    }

    @GetMapping("/testNotBlank")
    public String testNotBlank(@Valid NotBlankVao notBlankVao) {
        System.out.println("notBlankVao:" + notBlankVao);
        return "/ok";
    }

    @GetMapping("/testNotEmpty")
    public String testNotEmpty(@Valid NotEmptyVao notEmptyVao) {
        System.out.println("notEmptyVao:" + notEmptyVao);
        return "/ok";
    }

    @GetMapping("/testAssert")
    public String testAssert(@Valid AssertVao assertVao) {
        System.out.println("assertVao:" + assertVao);
        return "/ok";
    }

    @GetMapping("/testDate")
    public String testDate(@Valid DateVao dateVao) {
        System.out.println("dateVao:" + dateVao);
        return "/ok";
    }

    @GetMapping("/testEmail")
    public String testEmail(@Valid EmailVao emailVao) {
        System.out.println("emailVao:" + emailVao);
        return "/ok";
    }

    @GetMapping("/testLength")
    public String testLength(@Valid LengthVao lengthVao) {
        System.out.println("lengthVao:" + lengthVao);
        return "/ok";
    }

    @GetMapping("/testPattern")
    public String testPattern(@Valid PatternVao patternVao) {
        System.out.println("patternVao:" + patternVao);
        return "/ok";
    }

    @GetMapping("/testSize")
    public String testSize(@Valid SizeVao sizeVao) {
        System.out.println("sizeVao:" + sizeVao);
        return "/ok";
    }

    @GetMapping("/testRange")
    public String testRange(@Valid RangeVao rangeVao) {
        System.out.println("rangeVao:" + rangeVao);
        return "/ok";
    }

    @GetMapping("/testNull")
    public String testNull(@Valid NullVao nullVao) {
        System.out.println("nullVao:" + nullVao);
        return "/ok";
    }

    @GetMapping("/testNotNull")
    public String testNotNull(@Valid NotNullVao notNullVao) {
        System.out.println("notNullVao:" + notNullVao);
        return "/ok";
    }
}
