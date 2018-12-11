package hu.uni.miskolc.iit.model;

public class StudentRequestComplain
{

    private int requestId;
    private String complaint;
    private int id;

    public StudentRequestComplain(int requestId, String complaint, int id)
    {
        this.requestId = requestId;
        this.complaint = complaint;
        this.id = id;
    }


    public String getComplain() {
        return complaint;
    }

    public void setComplain(String complain) {
        this.complaint = complain;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

}