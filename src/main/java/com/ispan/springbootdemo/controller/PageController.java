package com.ispan.springbootdemo.controller;

import com.ispan.springbootdemo.Entity.WorkMessages;
import com.ispan.springbootdemo.service.WorkMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

  @Autowired
  private WorkMessagesService messagesService;

  @GetMapping("/")
  public String welcomeIndex() {
    return "index";
  }

  @GetMapping("message/add")
  public ModelAndView addMessagePage(ModelAndView mav) {

    WorkMessages massage = new WorkMessages();
    mav.addObject("workMessages", massage);

    WorkMessages lastMsg = messagesService.getLastest();
    mav.addObject("lastMsg", lastMsg);

    mav.setViewName("addMessage");
    return mav;

  }
  @GetMapping("/message/viewMessages")
  public ModelAndView viewMessages(
      ModelAndView mav,
      @RequestParam(name = "p", defaultValue = "1") Integer pageNumber) {

    Page<WorkMessages> page = messagesService.findByPage(pageNumber);
    mav.getModel().put("pagesBack", page);
    mav.setViewName("viewMessages");
    return mav;
  }

  @GetMapping("/message/ajax")
  public String ajaxPage() {
    return "ajax-message";
  }

}
