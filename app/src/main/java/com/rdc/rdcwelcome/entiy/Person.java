package com.rdc.rdcwelcome.entiy;

import cn.bmob.v3.BmobObject;

/**
 * Created by 残渊 on 2018/11/11.
 */

public class Person extends BmobObject {
    private String name;
    private String sex;
    private String  studentId;
    private String college;
    private String team;
    private String work;
    private String phoneNum;
    private String email;
    private String qq;
    private String signDirection;
    private String skills;
    private String introduction;
    private String hope;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhoneNum() {
        return phoneNum;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCollege() {
        return college;
    }

    public String getName() {
        return name;
    }

    public String getHope() {
        return hope;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSex() {
        return sex;
    }

    public String getSignDirection() {
        return signDirection;
    }

    public String getSkills() {
        return skills;
    }

    public String getTeam() {
        return team;
    }

    public String getWork() {
        return work;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHope(String hope) {
        this.hope = hope;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getQq() {
        return qq;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSignDirection(String signDirection) {
        this.signDirection = signDirection;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }



    public void setTeam(String team) {
        this.team = team;
    }

    public void setWork(String work) {
        this.work = work;
    }
}

