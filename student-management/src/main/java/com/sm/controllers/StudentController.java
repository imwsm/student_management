package com.sm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sm.DAO.StudentDAO;
import com.sm.DAO.StudentDAOImpls;
import com.sm.api.Student;
import com.sm.service.StudentService;


@Controller
public class StudentController {
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/")
	public String home() {
		return "index";	
	}
	
	@GetMapping("/showStudent")
	public String showStudentList(Model model) {
		
		
		List<Student> studentList = studentService.loadStudents();
		
		for(Student temp:studentList) System.out.println(temp);
		
		model.addAttribute("students",studentList);
	
		return "student-list";
	}
	
	@GetMapping("/showAddStudent")
	public String addStudent(Model model) {
		
		Student student = new Student();
		
		model.addAttribute("student",student);
	
		return "add-student";
	}
	
		
		@PostMapping("/save-student")
		public String saveStudent(Student student) {
		
			if(student.getId()==0)
			studentService.saveStudent(student);
			else {
				studentService.update(student);
			}
			
		return "redirect:/showStudent";
	}
		
		@GetMapping("/updateStudent")
		public String updateStudent(@RequestParam("userId") int id , Model model) {
			
		Student thestudent = studentService.getStudent(id);	
		System.out.println(thestudent);
		

		model.addAttribute("student",thestudent);
		
		
		return "add-student";
		}
		
		@GetMapping("/deleteStudent")
		public String deleteStudent(@RequestParam("userId") int id ) {
		
			studentService.deleteStudent(id);
			
		return "redirect:/showStudent";
		}
		


}
