package hu.uni.miskolc.iit;

import hu.uni.miskolc.iit.dao.StudentServiceDao;
import hu.uni.miskolc.iit.exceptions.ComplainAlreadyExistsException;
import hu.uni.miskolc.iit.exceptions.RequestDoesNotExistException;
import hu.uni.miskolc.iit.service.impl.StudentServiceImpl;
import junit.framework.AssertionFailedError;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertTrue;
import static  org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@Ignore
public class StudentServiceImplTests {

    @Mock
    StudentServiceDao studentServiceDaoMock;

    @InjectMocks
    StudentServiceImpl studentService;

    public StudentServiceImplTests(){
        super();
    }

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

}
