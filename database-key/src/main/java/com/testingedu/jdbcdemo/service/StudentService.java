package com.testingedu.jdbcdemo.service;

import com.testingedu.jdbcdemo.domain.dao.BaseDao;
import com.testingedu.jdbcdemo.domain.jpa.Card;
import com.testingedu.jdbcdemo.domain.jpa.Student;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService extends BaseDao {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(StudentService.class);

    public Integer SaveAllStudent(List<Student> studentList){
        getJDBCConnection();
        String sql=null;

        if(CollectionUtils.isEmpty(studentList)){
            logger.info("传入参数不能空");
        }else{
            for (Student student:studentList){
                sql = "insert into student(sname,cid) VALUES (?,?)";
                try {
                    pstmt = connection.prepareStatement(sql);
                    pstmt.setString(1,student.getSname());
                    Card cid = student.getCid();
                    pstmt.setObject(2,cid);
                    Integer result = pstmt.executeUpdate();
                    logger.info("数据存储成功",result);
                    return result;

                } catch (SQLException e) {
                    logger.info("数据存储异常",e);

                }finally {
                    closeAll();
                }
            }
        }
        return 0;
    }
}
