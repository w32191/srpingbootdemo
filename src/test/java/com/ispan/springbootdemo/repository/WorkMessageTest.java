package com.ispan.springbootdemo.repository;

import com.ispan.springbootdemo.Entity.WorkMessages;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
public class WorkMessageTest {

  @Autowired
  private WorkMessagesRepository dao;


  @Test
  public void testSave() {
    WorkMessages msg = new WorkMessages();
    msg.setText("new Message");
    dao.save(msg);
    Assertions.assertNotNull(msg.getId(), "No ID generate");
    Assertions.assertNotNull(msg.getAdded(), "No Date generate");


  }


}
