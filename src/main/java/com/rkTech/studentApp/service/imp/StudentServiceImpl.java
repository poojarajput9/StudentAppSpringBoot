package com.rkTech.studentApp.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.rkTech.studentApp.model.Student;
import com.rkTech.studentApp.repository.StudentRepository;
import com.rkTech.studentApp.service.StudentService;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository studentRepository;
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);	
	}

	
	 @Transactional
	    public Student save(Student student) {
	        Student savedStudent = studentRepository.save(student);
	        kafkaTemplate.send("student-topic", "Created Student: " + savedStudent.getId());
	        return savedStudent;
	    }

	    @Transactional
	    public Student update(Long id, Student student) {
	        student.setId(id);
	        Student updatedStudent = studentRepository.save(student);
	        kafkaTemplate.send("student-topic", "Updated Student: " + updatedStudent.getId());
	        return updatedStudent;
	    }

	    @Transactional
	    public void delete(Long id) {
	        studentRepository.deleteById(id);
	        kafkaTemplate.send("student-topic", "Deleted Student: " + id);
	    }
}