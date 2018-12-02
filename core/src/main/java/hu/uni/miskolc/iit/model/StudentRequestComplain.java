package hu.uni.miskolc.iit.model;

public class StudentRequestComplain
{

    private int requestId;
    private String complain;
    private int id;

    public StudentRequestComplain(int requestId, String complain, int id)
    {
        this.requestId = requestId;
        this.complain = complain;
        this.id = id;
    }


    public String getComplain() {
        return complain;
    }

    public void setComplain(String complain) {
        this.complain = complain;
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
