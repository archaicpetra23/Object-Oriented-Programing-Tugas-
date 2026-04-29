package edu.pradita.dip;

public class TrainingCoachRefactored {
    private TrainingPlanRefactored plan;

    public TrainingCoachRefactored(TrainingPlanRefactored plan) {
        this.plan = plan;
    }

    public void assignPlan(String memberName) {
        plan.assignPlan(memberName);
    }
}