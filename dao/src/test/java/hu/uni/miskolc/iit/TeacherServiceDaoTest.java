package hu.uni.miskolc.iit;

import hu.uni.miskolc.iit.dao.TeacherServiceDao;
import hu.uni.miskolc.iit.model.Form;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import hu.uni.miskolc.iit.impl.TeacherServiceDaoImpl;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceDaoTest {

    private TeacherServiceDao teacherServiceDao = new TeacherServiceDaoImpl();

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void teacherServiceDaoTest() {
    }

    @Test
    public void getFormsTest(){
    }


}
