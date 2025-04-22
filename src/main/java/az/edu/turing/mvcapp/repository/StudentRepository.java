package az.edu.turing.mvcapp.repository;

import az.edu.turing.mvcapp.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Student(rs.getLong("id"), rs.getString("name"))
        );
    }


    public int addStudent(Student student) {
        String sql = "INSERT INTO students (name) VALUES (?)";
        return jdbcTemplate.update(sql, student.getName());
    }

    public int deleteStudent(long id) {
        String sql = "DELETE FROM students WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateStudent(Student student) {
        String sql = "UPDATE students SET name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, student.getName(), student.getId());
    }

    public Student getStudentById(long id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                    new Student(rs.getLong("id"), rs.getString("name")), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
