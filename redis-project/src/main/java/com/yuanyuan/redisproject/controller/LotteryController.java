package com.yuanyuan.redisproject.controller;

import com.yuanyuan.redisproject.service.LotteryService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author FAYUAN.PENG
 * @version \$Id: LotteryController.java,  2021-07-13 17:18 FAYUAN.PENG Exp $$
 */
@RequestMapping("/redisproject/lottery")
@Controller
public class LotteryController {

    @Autowired
    private LotteryService lotteryService;

    private Set<String> users;
    private Long userCount;
    private List<String> firstPrizeUsers;
    private List<String> secondPrizeUsers;
    private List<String> thridPrizeUsers;

    @GetMapping("/listAllUser")
    public String listAllUser(Model model) {
        System.out.println("listAllUser invoke");
        if (users == null) {
            users = lotteryService.listAllUser();
            userCount = lotteryService.getCount();
        }

        model.addAttribute("users", users);
        model.addAttribute("userCount", userCount);

        return "lottery";
    }

    @GetMapping("/randomLottery")
    public String randomLottery(Model model) {
        System.out.println("listAllUser randomLottery");
        if (thridPrizeUsers == null) {
            thridPrizeUsers = lotteryService.randomLottery(5);
        }

        if (secondPrizeUsers == null) {
            secondPrizeUsers = lotteryService.randomLottery(3);
        }

        if (firstPrizeUsers == null) {
            firstPrizeUsers = lotteryService.randomLottery(2);
        }
        model.addAttribute("users", users);
        model.addAttribute("userCount", userCount);
        model.addAttribute("thridPrizeUsers", thridPrizeUsers);
        model.addAttribute("secondPrizeUsers", secondPrizeUsers);
        model.addAttribute("firstPrizeUsers", firstPrizeUsers);

        return "lottery";
    }

}
