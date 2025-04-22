package az.edu.turing.mvcapp.service;

import az.edu.turing.mvcapp.exception.StudentNotFoundException;
import az.edu.turing.mvcapp.model.Student;
import az.edu.turing.mvcapp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public String createStudent(Student student) {
        int rowsAffected = studentRepository.addStudent(student);
        if (rowsAffected > 0) {
            return "Student created successfully!";
        } else {
            throw new RuntimeException("Failed to create student.");
        }
    }

    public String deleteStudent(long id) {
        int rowsAffected = studentRepository.deleteStudent(id);
        if (rowsAffected > 0) {
            return "Student deleted successfully!";
        } else {
            throw new StudentNotFoundException("Student with id " + id + " not found.");
        }
    }

    public String updateStudent(Student student) {
        int rowsAffected = studentRepository.updateStudent(student);
        if (rowsAffected > 0) {
            return "Student updated successfully!";
        } else {
            throw new StudentNotFoundException("Student with id " + student.getId() + " not found.");
        }
    }

    public Student getStudentById(long id) {
        Student student = studentRepository.getStudentById(id);
        if (student == null) {
            throw new StudentNotFoundException("Student with id " + id + " not found.");
        }
        return student;
    }
}
