package edu.pradita.dip;

public class CardioTrainingPlanRefactored implements TrainingPlanRefactored {
    @Override
    public void assignPlan(String memberName) {
        System.out.println("[DIP] Cardio training plan for " + memberName);
    }
}