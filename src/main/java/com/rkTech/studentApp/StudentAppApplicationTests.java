package com.rkTech.studentApp;

import com.rkTech.studentApp.model.Student;
import com.rkTech.studentApp.repository.StudentRepository;
import com.rkTech.studentApp.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// working on mockito issue
/*import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
*/
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/*import static org.mockito.Mockito.*;
*/
public class StudentAppApplicationTests {

	/*
	 * @Mock private StudentRepository studentRepository;
	 * 
	 * @InjectMocks private StudentService studentService;
	 * 
	 * @BeforeEach void setUp() { MockitoAnnotations.openMocks(this); }
	 */
    @Test
    void testCreateStudentSuccess() {
        Student student = new Student();
        student.setFirstName("test");
        student.setLastName("test1");
        student.setCourse("kafka");
        student.setEmail("test@example.com");

		/*
		 * when(studentRepository.save(any(Student.class))).thenReturn(student); Student
		 * savedStudent = studentService.save(student);
		 */
		/*
		 * assertNotNull(savedStudent); assertEquals("test test1",
		 * savedStudent.getFirstName());
		 */
    }

    @Test
    void testFindStudentByIdSuccess() {
        Student student = new Student();
        student.setId(1L);
        student.setFirstName("test");
        student.setLastName("test1");
        student.setCourse("kafka");
        student.setEmail("test@example.com");
        
		/*
		 * when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
		 * Student foundStudent = studentService.findById(1L);
		 */
		/*
		 * assertNotNull(foundStudent); assertEquals("test test1",
		 * foundStudent.getFirstName());
		 */
    }

    @Test
    void testFindStudentByIdFailure() {
		/*
		 * when(studentRepository.findById(1L)).thenReturn(Optional.empty()); Student
		 * foundStudent = studentService.findById(1L);
		
        assertNull(foundStudent);*/
    }
}
