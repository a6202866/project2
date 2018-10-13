package com.lxd.project2.entity;

/**
 * Created by Administrator on 2018/10/13 0013.
 */
public class IID {
    private int resumeID;
    private int recruitID;
    private int interviewID;

    public IID() {
    }

    public IID(int resumeID, int recruitID) {
        this.resumeID = resumeID;
        this.recruitID = recruitID;
    }

    public IID(int resumeID, int recruitID, int interviewID) {
        this.resumeID = resumeID;
        this.recruitID = recruitID;
        this.interviewID = interviewID;
    }

    public int getResumeID() {
        return resumeID;
    }

    public void setResumeID(int resumeID) {
        this.resumeID = resumeID;
    }

    public int getRecruitID() {
        return recruitID;
    }

    public void setRecruitID(int recruitID) {
        this.recruitID = recruitID;
    }

    public int getInterviewID() {
        return interviewID;
    }

    public void setInterviewID(int interviewID) {
        this.interviewID = interviewID;
    }

    @Override
    public String toString() {
        return "IID{" +
                "resumeID=" + resumeID +
                ", recruitID=" + recruitID +
                ", interviewID=" + interviewID +
                '}';
    }
}
