package com.ispan.springbootdemo.controller;

import com.ispan.springbootdemo.Dto.MessageDto;
import com.ispan.springbootdemo.Entity.WorkMessages;
import com.ispan.springbootdemo.service.WorkMessagesService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {

  @Autowired
  private WorkMessagesService messagesService;

  @PostMapping("message/add")
  public ModelAndView addMessage(ModelAndView mav,
      @Valid @ModelAttribute(name = "workMessages") WorkMessages messages,
      BindingResult br) {

    if (!br.hasErrors()) {
      //將輸入的message寫進ＤＢ
      messagesService.insert(messages);
      //new一個新的，把原本的換掉，回傳後畫面那一欄就會空了
      WorkMessages newMsg = new WorkMessages();
      mav.getModel().put("workMessages", newMsg);
    }

    //取資料庫中最新一筆資料
    WorkMessages lastMsg = messagesService.getLastest();
    mav.getModel().put("lastMsg", lastMsg);

    mav.setViewName("addMessage");
    return mav;
  }


  @GetMapping("/message/editMessage")
  public String editMessage(Model model, @RequestParam("id") Integer id) {
    WorkMessages msg = messagesService.findById(id);
    model.addAttribute("workMessages", msg);
    return "editMessage";
  }

  @PostMapping("/message/editMessage")
  public ModelAndView editMessage(ModelAndView mav,
      @Valid @ModelAttribute(name = "workMessages") WorkMessages messages,
      BindingResult br) {

    mav.setViewName("editMessage");
    if (!br.hasErrors()) {
      // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.entity-persistence.saving-entites
      messagesService.insert(messages);
      mav.setViewName("redirect:/message/viewMessages");
    }
    return mav;
  }

  @GetMapping("/message/deleteMessage")
  public ModelAndView deleteMessage(ModelAndView mav, @RequestParam("id") Integer id) {
    messagesService.deleteById(id);
    mav.setViewName("redirect:/message/viewMessages");

    return mav;
  }


  @PostMapping("/api/postMessage")
  @ResponseBody
  public List<WorkMessages> postMessageApi(@RequestBody MessageDto dto) {
    //先用dto接收前端傳入的JSON
    String text = dto.getMsg();

    WorkMessages workMessages = new WorkMessages();
    workMessages.setText(text);
    messagesService.insert(workMessages);

    Page<WorkMessages> page = messagesService.findByPage(1);
    return page.getContent();
  }


}
