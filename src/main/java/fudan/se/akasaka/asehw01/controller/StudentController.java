package fudan.se.akasaka.asehw01.controller;

import fudan.se.akasaka.asehw01.entity.Student;
import fudan.se.akasaka.asehw01.service.StudentService;
import fudan.se.akasaka.asehw01.util.JsonUtils;
import fudan.se.akasaka.asehw01.util.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

    @PostMapping("/api/v1/student")
    @ResponseBody
    public String createStudent(@RequestBody Student student) {
        Response response = studentService.createStudent(student);
        int status = response.getStatus();
        if (status == 0)
            return response.getMsg();
        else if (status == 1)
            return response.getMsg();
        else return "Unknown error";
    }

    @GetMapping("/api/v1/student")
    @ResponseBody
    public String retrieveStudents() {
        Response response = studentService.retrieveStudents();
        int status = response.getStatus();
        if (status == 0)
            return response.getMsg();
        else if (status == 1)
            return JsonUtils.object2Json(response.getData());
        else return "Unknown error";
    }

    @PutMapping("/api/v1/student")
    @ResponseBody
    public String updateStudent(@RequestBody Student student) {
        Response response = studentService.updateStudent(student);
        int status = response.getStatus();
        if (status == 0)
            return response.getMsg();
        else if (status == 1)
            return response.getMsg();
        else return "Unknown error";
    }

    @DeleteMapping("/api/v1/student")
    @ResponseBody
    public String deleteStudent(@RequestBody Student student) {
        Response response = studentService.deleteStudent(student.getStudentId());
        int status = response.getStatus();
        if (status == 0)
            return response.getMsg();
        else if (status == 1)
            return response.getMsg();
        else return "Unknown error";
    }
}
