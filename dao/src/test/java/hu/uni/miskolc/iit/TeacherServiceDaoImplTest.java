package hu.uni.miskolc.iit;

import org.junit.Before;
import org.junit.Test;
import hu.uni.miskolc.iit.impl.TeacherServiceDaoImpl;


public class TeacherServiceDaoImplTest {

    TeacherServiceDaoImpl tImp;

    @Before
    public void before(){
        tImp = new TeacherServiceDaoImpl();
    }

    @Test
    public void getFormsTest(){
        tImp.getForms();
    }
}
