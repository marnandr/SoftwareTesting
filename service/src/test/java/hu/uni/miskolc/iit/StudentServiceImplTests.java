package hu.uni.miskolc.iit;

import hu.uni.miskolc.iit.dao.StudentServiceDao;
import hu.uni.miskolc.iit.exceptions.ComplainAlreadyExistsException;
import hu.uni.miskolc.iit.exceptions.RequestDoesNotExistException;
import hu.uni.miskolc.iit.service.impl.StudentServiceImpl;
import junit.framework.AssertionFailedError;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertTrue;
import static  org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

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

    @Test
    public void checkRequestStatusValidInputs()
    {
        try {
            doReturn("Denied").when(studentServiceDaoMock).checkRequestStatus(0);
            assertEquals( "Denied" ,studentService.checkRequestStatus(0));
        } catch (RequestDoesNotExistException e) {
            throw new AssertionFailedError();
        }
    }

    @Test(expected = RequestDoesNotExistException.class)
    public void checkRequestStatusRequestDoesNotExist() throws RequestDoesNotExistException {
        doThrow(new RequestDoesNotExistException()).when(studentServiceDaoMock).checkRequestStatus(0);
        studentService.checkRequestStatus(0);
    }

    @Test(expected = RequestDoesNotExistException.class)
    public void createComplainRequestDoesNotExist() throws RequestDoesNotExistException, ComplainAlreadyExistsException {
        doThrow(new RequestDoesNotExistException()).when(studentServiceDaoMock).createComplain(0, "pistike");
        studentService.createComplain(0, "pistike");
    }

    @Test(expected = ComplainAlreadyExistsException.class)
    public void createComplainComplainAlreadyExists() throws RequestDoesNotExistException, ComplainAlreadyExistsException {
        doThrow(new ComplainAlreadyExistsException()).when(studentServiceDaoMock).createComplain(0, "pistike");
        studentService.createComplain(0, "pistike");
    }
}
