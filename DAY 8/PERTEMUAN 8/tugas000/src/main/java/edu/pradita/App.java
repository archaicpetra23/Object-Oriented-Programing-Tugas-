package edu.pradita;

import edu.pradita.srp.GymManager;
import edu.pradita.ocp.GymScheduler;
import edu.pradita.lsp.GymEquipment;
import edu.pradita.lsp.LockedEquipment;
import edu.pradita.isp.RegularMember;
import edu.pradita.dip.TrainingCoach;
import edu.pradita.dip.WeightTrainingPlan;

// TODO: Uncomment these imports after you finish the refactored versions
import edu.pradita.srp.MemberRecordRefactored;
import edu.pradita.srp.MemberPrinterRefactored;
import edu.pradita.srp.MemberRepositoryRefactored;
import edu.pradita.ocp.GymSchedulerRefactored;
import edu.pradita.ocp.YogaSessionRefactored;
import edu.pradita.ocp.CardioSessionRefactored;
import edu.pradita.ocp.SpinningSessionRefactored;
import edu.pradita.lsp.StandardEquipmentRefactored;
import edu.pradita.lsp.LockedEquipmentRefactored;
import edu.pradita.isp.RegularMemberRefactored;
import edu.pradita.dip.TrainingCoachRefactored;
import edu.pradita.dip.WeightTrainingPlanRefactored;
import edu.pradita.dip.CardioTrainingPlanRefactored;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Pertemuan 08: SOLID Principles Refactoring ===\n");
        // - SRP: 3 classes, each 1 job  
        // - OCP: Interface + multiple implementations  
        // - LSP: No broken inheritance contracts  
        // - ISP: RegularMemberRefactored implements BookableRefactored ONLY  
        // - DIP: TrainingCoachRefactored constructor takes interface  
        // - App.java: Uncomment refactored imports + usage  

        // ==================== OLD VERSION ====================
        // GymManager gm = new GymManager();
        // gm.registerMember("Alice", "alice@email.com", 3);
        // gm.printMemberInfo();
        // gm.saveMemberToFile();

        // System.out.println("\n--- OCP: Gym Scheduler ---");
        // GymScheduler scheduler = new GymScheduler();
        // scheduler.startSession("Yoga");
        // scheduler.startSession("Cardio");

        // System.out.println("\n--- LSP: Gym Equipment ---");
        // GymEquipment treadmill = new GymEquipment("Treadmill");
        // treadmill.release();

        // LockedEquipment barbell = new LockedEquipment("Barbell Rack");
        // try {
        //     barbell.release();
        // } catch (UnsupportedOperationException e) {
        //     System.out.println("LSP violation caught: " + e.getMessage());
        // }

        // System.out.println("\n--- ISP: Regular Member ---");
        // RegularMember member = new RegularMember("Bob");
        // member.bookClass("Yoga");
        // try {
        //     member.manageMember("Charlie");
        // } catch (UnsupportedOperationException e) {
        //     System.out.println("ISP violation caught: " + e.getMessage());
        // }

        // System.out.println("\n--- DIP: Training Coach ---");
        // TrainingCoach coach = new TrainingCoach(new WeightTrainingPlan());
        // coach.assignPlan("Alice");

        // ==================== REFACTORED VERSION ====================
        // TODO: After you finish the Refactored files, comment out the OLD VERSION above
        // TODO: Then uncomment the code below

        // System.out.println("\n=== Refactored Version ===\n");

        // MemberRecordRefactored memberData = new MemberRecordRefactored("Alice", "alice@email.com", 3);
        // MemberPrinterRefactored printer = new MemberPrinterRefactored();
        // MemberRepositoryRefactored repository = new MemberRepositoryRefactored();
        // System.out.println("[SRP] Member registered: " + memberData.getName());
        // printer.print(memberData);
        // repository.save(memberData);

        // GymSchedulerRefactored newScheduler = new GymSchedulerRefactored();
        // newScheduler.startSession(new YogaSessionRefactored());
        // newScheduler.startSession(new CardioSessionRefactored());
        // newScheduler.startSession(new SpinningSessionRefactored());

        // StandardEquipmentRefactored standardEquipment = new StandardEquipmentRefactored("Treadmill");
        // standardEquipment.release();
        // LockedEquipmentRefactored lockedEquipment = new LockedEquipmentRefactored("Barbell Rack");
        // System.out.println("[LSP] Locked equipment: " + lockedEquipment.getName());

        // RegularMemberRefactored regularMember = new RegularMemberRefactored("Bob");
        // regularMember.bookClass("Yoga");

        // TrainingCoachRefactored weightCoach = new TrainingCoachRefactored(new WeightTrainingPlanRefactored());
        // weightCoach.assignPlan("Alice");
        // TrainingCoachRefactored cardioCoach = new TrainingCoachRefactored(new CardioTrainingPlanRefactored());
        // cardioCoach.assignPlan("Bob");
    
    System.out.println("\n=== Refactored Version ===\n");

        MemberRecordRefactored memberData = new MemberRecordRefactored("Alice", "alice@email.com", 3);
        MemberPrinterRefactored printer = new MemberPrinterRefactored();
        MemberRepositoryRefactored repository = new MemberRepositoryRefactored();
        System.out.println("[SRP] Member registered: " + memberData.getName());
        printer.print(memberData);
        repository.save(memberData);

        GymSchedulerRefactored newScheduler = new GymSchedulerRefactored();
        newScheduler.startSession(new YogaSessionRefactored());
        newScheduler.startSession(new CardioSessionRefactored());
        newScheduler.startSession(new SpinningSessionRefactored());

        StandardEquipmentRefactored standardEquipment = new StandardEquipmentRefactored("Treadmill");
        standardEquipment.release();
        LockedEquipmentRefactored lockedEquipment = new LockedEquipmentRefactored("Barbell Rack");
        System.out.println("[LSP] Locked equipment: " + lockedEquipment.getName());

        RegularMemberRefactored regularMember = new RegularMemberRefactored("Bob");
        regularMember.bookClass("Yoga");

        TrainingCoachRefactored weightCoach = new TrainingCoachRefactored(new WeightTrainingPlanRefactored());
        weightCoach.assignPlan("Alice");
        TrainingCoachRefactored cardioCoach = new TrainingCoachRefactored(new CardioTrainingPlanRefactored());
        cardioCoach.assignPlan("Bob");
    }
}