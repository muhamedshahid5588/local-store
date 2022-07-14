package com.example.requestsqlitedatabase;

public class Subject {


    private String ID;
    private String SubjectName;
    private String MaxMark;

    public Subject(String ID, String subjectName, String maxMark) {
        this.ID = ID;
        SubjectName = subjectName;
        MaxMark = maxMark;

    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public String getMaxMark() {
        return MaxMark;
    }

    public void setMaxMark(String maxMark) {
        MaxMark = maxMark;
    }
}
