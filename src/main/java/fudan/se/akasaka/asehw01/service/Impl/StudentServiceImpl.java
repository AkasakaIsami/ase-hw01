package fudan.se.akasaka.asehw01.service.Impl;

import fudan.se.akasaka.asehw01.entity.Student;
import fudan.se.akasaka.asehw01.repository.StudentRepository;
import fudan.se.akasaka.asehw01.service.StudentService;
import fudan.se.akasaka.asehw01.util.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository=new StudentRepository();

    String success = "Success";


    @Override
    public Response createStudent(Student student) {
        if (studentRepository.save(student) == null)
            return new Response<Student>(0, "Student already exit", student);
        return new Response<Student>(1, success, student);
    }


    @Override
    public Response retrieveStudents() {
        List<Student> result = studentRepository.findAll();
        if (result == null)
            return new Response<Student>(0, "Fail to retrieve students", null);
        return new Response<List>(1, success, result);

    }


    @Override
    public Response updateStudent(Student student) {
        if (studentRepository.updateById(student) == null)
            return new Response<String>(0, "Student doesn't exist.", student.getStudentId());
        return new Response<Student>(1, success, student);
    }


    @Override
    public Response deleteStudent(String studentId) {
        if (studentRepository.deleteById(studentId) == null)
            return new Response<String>(0, "Student doesn't exist.", studentId);
        return new Response<String>(1, success, studentId);
    }

}
