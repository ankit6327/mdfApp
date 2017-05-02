package com.akeys.mdf.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akeys.mdf.vo.SchemeVo;

/**
 * The Class SchemeRestController.
 *
 * @author Ankit Sood May 2, 2017
 */
@RestController
public class SchemeRestController {

    /**
     * Welcome.
     *
     * @return the string
     */
    @RequestMapping("/")
    public String welcome() {
	return "Welcome to the page of MDF";
    }


    /**
     * Message.
     *
     * @param mdfScheme
     *            the mdf scheme
     * @return the scheme vo
     */
    @RequestMapping("/scheme/{mdfScheme}")
    public SchemeVo message(@PathVariable String mdfScheme) {
	SchemeVo msg = new SchemeVo(mdfScheme, "Hello " + mdfScheme);
	return msg;
    }

}
