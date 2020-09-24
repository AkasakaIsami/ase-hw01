package fudan.se.akasaka.asehw01.service;

import fudan.se.akasaka.asehw01.entity.Student;
import fudan.se.akasaka.asehw01.util.Response;

import java.util.List;

public interface StudentService {

    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    Response createStudent(Student student);

    /**
     * 查看学生
     *
     * @return
     */
    Response retrieveStudents();

    /**
     * 修改学生信息
     *
     * @param student
     * @return
     */
    Response updateStudent(Student student);

    /**
     * 删除学生
     *
     * @param studentId
     * @return
     */
    Response deleteStudent(String studentId);


}
