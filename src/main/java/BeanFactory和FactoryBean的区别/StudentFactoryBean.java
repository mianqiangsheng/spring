package BeanFactory和FactoryBean的区别;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by lizhen on 2018/10/29.
 */
public class StudentFactoryBean implements FactoryBean<Student> {

    private String studentInfo;

    public void setStudentInfo(String studentInfo) {
        this.studentInfo = studentInfo;
    }

    @Override
    public Student getObject() throws Exception {
        if (this.studentInfo == null) {
            throw new IllegalArgumentException("'studentInfo' is required");
        }

        // 分割属性
        String[] splitStudentInfo = studentInfo.split(",");
        if (null == splitStudentInfo || splitStudentInfo.length != 3) {
            throw new IllegalArgumentException("'studentInfo' config error");
        }

        // 创建Student并填充属性
        Student student = new Student();
        student.setName(splitStudentInfo[0]);
        student.setAge(Integer.valueOf(splitStudentInfo[1]));
        student.setClassName(splitStudentInfo[2]);
        return student;
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

}
