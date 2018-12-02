package hu.uni.miskolc.iit.service;

public interface RequestService {

    public boolean requestCreate(int TeacherID, String course);

    public boolean checkRequstStatus(int RequestID);
}
