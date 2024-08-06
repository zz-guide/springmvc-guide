package org.zz.springmvc.guide.parameter.controller.validation;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zz.springmvc.guide.parameter.vao.*;
import org.zz.springmvc.guide.parameter.vao.custom.MyVao;

@Controller
@RequestMapping("/valid/get")
public class ValidGetController {

    @GetMapping("")
    public String index() {
        return "/valid/get/index";
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

    @GetMapping("/testPast")
    public String testPast(@Valid PastVao pastVao) {
        System.out.println("pastVao:" + pastVao);
        return "/ok";
    }

    @GetMapping("/testFuture")
    public String testFuture(@Valid FutureVao futureVao) {
        System.out.println("futureVao:" + futureVao);
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

    @GetMapping("/testPositive")
    public String testPositive(@Valid PositiveVao positiveVao) {
        System.out.println("positiveVao:" + positiveVao);
        return "/ok";
    }

    @GetMapping("/testPositiveOrZero")
    public String testPositiveOrZero(@Valid PositiveOrZeroVao positiveVao) {
        System.out.println("positiveVao:" + positiveVao);
        return "/ok";
    }


    @GetMapping("/testNegative")
    public String testNegative(@Valid NegativeVao negativeVao) {
        System.out.println("negativeVao:" + negativeVao);
        return "/ok";
    }

    @GetMapping("/testNegativeOrZero")
    public String testNegativeOrZero(@Valid NegativeOrZeroVao negativeOrZeroVao) {
        System.out.println("negativeOrZeroVao:" + negativeOrZeroVao);
        return "/ok";
    }

    @GetMapping("/testFutureOrPresent")
    public String testFutureOrPresent(@Valid FutureOrPresentVao futureOrPresentVao) {
        System.out.println("futureOrPresentVao:" + futureOrPresentVao);
        return "/ok";
    }

    @GetMapping("/testPastOrPresent")
    public String testPastOrPresent(@Valid PastOrPresentVao pastOrPresentVao) {
        System.out.println("pastOrPresentVao:" + pastOrPresentVao);
        return "/ok";
    }

    @GetMapping("/testUrl")
    public String testUrl(@Valid URLVao urlVao) {
        System.out.println("urlVao:" + urlVao);
        return "/ok";
    }

    @GetMapping("/testAlias")
    public String testAlias(@Valid AliasVao aliasVao) {
        System.out.println("aliasVao:" + aliasVao);
        return "/ok";
    }

    @GetMapping("/testMyVao")
    public String testMyVao(@Valid MyVao myVao) {
        System.out.println("myVao:" + myVao);
        return "/ok";
    }
}
