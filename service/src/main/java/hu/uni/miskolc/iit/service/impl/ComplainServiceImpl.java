package hu.uni.miskolc.iit.service.impl;



import hu.uni.miskolc.iit.dao.StudentServiceDao;
import hu.uni.miskolc.iit.exceptions.ComplainAlreadyExistsException;
import hu.uni.miskolc.iit.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;

public class ComplainServiceImpl implements ComplainService {

        @Autowired
    StudentServiceDao studentServiceDao;

        public ComplainServiceImpl() {
            // TODO Auto-generated constructor stub
        }

        @Override
        public boolean requestCreate(int TeacherID, String course) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean checkRequstStatus(int RequestID) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean createComplain(int ComplainID, int RequestID, String Complain) throws ComplainAlreadyExistsException {

            return studentServiceDao.createComplain(ComplainID, RequestID, Complain);
        }

    }

