package com.example.notdemo.domain.inner;

import java.io.Serializable;

public class SocialProgress implements Serializable {
    private int numberOfComments;
    private int numberOfQuestions;
    private int numberOfReceivedLikes;
    private int numberOfReviews;

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public int getNumberOfReceivedLikes() {
        return numberOfReceivedLikes;
    }

    public void setNumberOfReceivedLikes(int numberOfReceivedLikes) {
        this.numberOfReceivedLikes = numberOfReceivedLikes;
    }

    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(int numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    @Override
    public String toString() {
        return "SocialProgress{" +
                "numberOfComments=" + numberOfComments +
                ", numberOfQuestions=" + numberOfQuestions +
                ", numberOfReceivedLikes=" + numberOfReceivedLikes +
                ", numberOfReviews=" + numberOfReviews +
                '}';
    }
}
