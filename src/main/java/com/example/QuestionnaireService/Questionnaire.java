package com.example.QuestionnaireService;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class Questionnaire {


    public Questionnaire() {

    }
    @JsonProperty("taxCode")
    String taxCode;
    @JsonProperty("answers")
    private Map<String, Boolean> ques;
    private boolean risk;



    public Questionnaire(String taxId, Map<String, Boolean> ques) {
        super();
        int score = 0;
        this.taxCode = taxId;
        this.ques = ques;
        for (Map.Entry<String, Boolean> entry : ques.entrySet()) {
            if (entry.getValue()) {
                score += 1;
            }
            if (score >= 3)
                this.risk = true;
        }
    }

    public Map<String,Boolean> getQues() {
        return ques;

    }
    public String getTaxCode(){
        return this.taxCode;
    }

    public boolean isRisk(){
        return this.risk;
    }
}