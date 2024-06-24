package com.example.QuestionnaireService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class QuestionnaireService {

    private static final ArrayList <String> questions = new ArrayList <> (Arrays.asList(
            "Do you have diabetes?",
            "Did you come in contact with poisonous substances?",
            "Do you suffer from cardiovascular disturbs?",
            "Do you have ha fever now?",
            "Are you having trouble breathing?"

    ));

    static QuestionnaireService questionnaireService = null;
    ArrayList<Questionnaire> questionnaires;


    public QuestionnaireService() {
        questionnaires = new ArrayList<>();

    }


    public static QuestionnaireService getQuesInstance() {
        if (questionnaireService == null)
            questionnaireService = new QuestionnaireService();
        return questionnaireService;
    }


    public boolean create(Questionnaire questionnaire) {
        Questionnaire ques = new Questionnaire(questionnaire.getTaxCode(),questionnaire.getQues());
       return questionnaires.add(ques);
    }

    public ArrayList<Questionnaire> findAllQuestionnaires() {
        return questionnaires;
    }

   public Questionnaire findQuestionnaireByTaxCode(String taxCode) {
        return questionnaires.stream().filter(q -> q.getTaxCode().equals(taxCode)).findFirst().orElse(null);
        }
   public ArrayList<Questionnaire> findQuestionnaireByRisk() {
        return (ArrayList<Questionnaire>) questionnaires.stream().filter(questionnaire -> questionnaire.isRisk()).collect(
                Collectors.toList()
        );
   }
        public ArrayList<String> getQuestionnaire() {
        return questions;
        }
   }

