package com.example.QuestionnaireService;

public class ResultService {
    Result res = new Result();

    public String createBad(){
        return res.getBadResult();
    }
    public String createOk(){
        return res.getOkResult();
    }
}
