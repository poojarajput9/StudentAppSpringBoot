package com.rkTech.studentApp.Listner;


import com.rkTech.studentApp.model.StudentLog;
import com.rkTech.studentApp.repository.StudentLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class StudentLogListner {
    @Autowired
    private StudentLogRepository  studentLogRepository;

    @KafkaListener(topics = "student-topic", groupId = "student_group")
    public void listen(String message) {
        StudentLog studentLog = new StudentLog();
        studentLog.setAction(message);
        studentLog.setEntityName("Student");
        studentLog.setTimestamp(LocalDateTime.now().toString());
        studentLogRepository.save(studentLog);
    }
}