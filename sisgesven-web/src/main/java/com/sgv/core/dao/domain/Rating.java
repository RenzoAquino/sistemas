/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgv.core.dao.domain;

public class Rating {

    public Usuario studentRated;    //student that was rated
    public Usuario studentRating;   //student that is rating
    public int score;   //out of 10
    public String comment;      //comment to justify score

    public Rating(Usuario studentRated, Usuario studentRating, int score, String comment) {
        this.studentRated = studentRated;
        this.studentRating = studentRating;
        this.score = score;
        this.comment = comment;
    }

    //getters
    public Usuario getStudentRated() {
        return this.studentRated;
    }

    public Usuario getStudentRating() {
        return this.studentRating;
    }

    public int getScore() {
        return this.score;
    }

    public String getComment() {
        return this.comment;
    }

    @Override
    public String toString() {
        return this.studentRating + " rated " + this.studentRated + " " + this.score + "/10.";

    }
}
