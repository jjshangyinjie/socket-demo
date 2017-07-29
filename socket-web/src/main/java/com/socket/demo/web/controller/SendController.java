package com.socket.demo.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shang Yinjie on 2017/6/4.
 */
@Controller
@RequestMapping("/")
public class SendController {

    private static final Log logger = LogFactory.getLog(SendController.class);

    @RequestMapping("/onMessage")
    public String onMessage(Model view) {
        logger.info("start send message!");

        view.addAttribute("name", "onMessage");
        return "socket/tables";
    }

}
