package fudan.se.akasaka.asehw01.repository;

import fudan.se.akasaka.asehw01.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public StudentRepository() {
        initStudents();
    }

    private void initStudents() {
        students.add(new Student("01", "test01", "testDep01", "testMaj01"));
        students.add(new Student("02", "test02", "testDep02", "testMaj02"));
        students.add(new Student("03", "test03", "testDep03", "testMaj03"));
        students.add(new Student("04", "test04", "testDep04", "testMaj04"));
    }

    /**
     * 通过ID查找学生
     *
     * @param studentId
     * @return
     */
    public Student findById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId))
                return student;
        }
        return null;
    }

    /**
     * 查找所有学生
     *
     * @return
     */
    public List<Student> findAll() {
        return students;
    }

    /**
     * 添加学生
     *
     * @param student
     */
    public Student save(Student student) {
        for (Student tempStudent : students) {
            if (tempStudent.getStudentId().equals(student.getStudentId())) {
                return null;
            }
        }
        students.add(student);
        return student;
    }

    /**
     * 删除学生
     *
     * @param studentId
     */
    public Student deleteById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                students.remove(student);
                return student;
            }
        }
        return null;
    }

    public Student updateById(Student student) {
        String studentId = student.getStudentId();
        for (Student tempStudent : students) {
            if (tempStudent.getStudentId().equals(studentId)) {
                tempStudent.setName(student.getName());
                tempStudent.setDepartment(student.getDepartment());
                tempStudent.setMajor(student.getMajor());
                return tempStudent;
            }
        }
        return null;
    }
}
