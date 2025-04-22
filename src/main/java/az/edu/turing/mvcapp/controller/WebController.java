package az.edu.turing.mvcapp.controller;

import az.edu.turing.mvcapp.model.Student;
import az.edu.turing.mvcapp.service.StudentService;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class WebController {
    private final StudentService studentService;

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students/list";
    }

    @GetMapping("/students/create")
    public String createStudentForm() {
        return "students/create";
    }

    @PostMapping("/students")
    public String createStudent(@RequestParam("name") String name) {
        Student newStudent = new Student();
        newStudent.setName(name);
        studentService.createStudent(newStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/update/{id}")
    public String updateStudentForm(@PathVariable("id") long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "students/update";
    }

    @PutMapping("/students/{id}")
    public String updateStudent(@PathVariable("id") long id, @RequestParam("name") String name) {
        Student student = studentService.getStudentById(id);
        student.setName(name);
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
