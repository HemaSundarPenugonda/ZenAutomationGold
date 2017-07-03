package com.znalytics.enrollment.tx.api.entity.serviceaccount;

public class Survey {
    private String QuestionNumber;
    private String Response;

    public Survey() {

    }

    public Survey(String questionNumber, String response) {
	this.QuestionNumber = questionNumber;
	this.Response = response;
    }

    public String getQuestionNumber() {
	return QuestionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
	this.QuestionNumber = questionNumber;
    }

    public String getResponse() {
	return Response;
    }

    public void setResponse(String response) {
	this.Response = response;
    }

}
