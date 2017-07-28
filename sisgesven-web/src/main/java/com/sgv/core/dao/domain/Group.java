/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgv.core.dao.domain;

import java.util.ArrayList;

public class Group {

    private String groupID;
    //ArrayList<Student
    private ArrayList<Rating> ratingList = new ArrayList<>();   //array of ratings
    private ArrayList<Usuario> studentList = new ArrayList<>(); //array of students

    public Group(String groupID) {
        this.groupID = groupID;
        //this.class1 = class1;
    }

    public String getGroupID() {
        return groupID;
    }

    public Group getGroup() {
        return this;
    }

    public ArrayList<Usuario> getStudents() {
        return this.studentList;
    }

    public void addStudent(Usuario student) {
        this.studentList.add(student);
    }

    public ArrayList<Rating> getRatings() {
        return this.ratingList;
    }

    public void addRating(Rating rating) {
        this.ratingList.add(rating);
    }
}
