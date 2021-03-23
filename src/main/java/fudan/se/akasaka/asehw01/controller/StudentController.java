package fudan.se.akasaka.asehw01.controller;

import fudan.se.akasaka.asehw01.entity.Student;
import fudan.se.akasaka.asehw01.service.StudentService;
import fudan.se.akasaka.asehw01.util.JsonUtils;
import fudan.se.akasaka.asehw01.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import javax.annotation.Resource;

@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

    @PostMapping("/api/v1/student")
    @ResponseBody
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        Response response = studentService.createStudent(student);
        int status = response.getStatus();
        if (status == 0)
            return ResponseEntity.ok(response.getMsg());
        else if (status == 1)
            return ResponseEntity.ok(response.getMsg());
        else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/v1/student")
    @ResponseBody
    public ResponseEntity<?> retrieveStudents() {
        Response response = studentService.retrieveStudents();
        int status = response.getStatus();
        if (status == 0)
            return ResponseEntity.ok(response.getMsg());
        else if (status == 1)
            return ResponseEntity.ok(response.getData());
        else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/api/v1/student")
    @ResponseBody
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        Response response = studentService.updateStudent(student);
        int status = response.getStatus();
        if (status == 0)
            return ResponseEntity.ok(response.getMsg());
        else if (status == 1)
            return ResponseEntity.ok(response.getMsg());
        else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/api/v1/student")
    @ResponseBody
    public ResponseEntity<?> deleteStudent(@RequestBody Student student) {
        Response response = studentService.deleteStudent(student.getStudentId());
        int status = response.getStatus();
        if (status == 0)
            return ResponseEntity.ok(response.getMsg());
        else if (status == 1)
            return ResponseEntity.ok(response.getMsg());
        else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
