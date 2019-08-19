package de.sample;

import edu.umd.cs.findbugs.*;
import edu.umd.cs.findbugs.classfile.ClassDescriptor;
import org.apache.bcel.classfile.JavaClass;

public class MyReporter extends TextUIBugReporter {

    private final BugCollection bugs;

    MyReporter(BugCollection bugs) {
        this.bugs = bugs;
        setPriorityThreshold(Detector.NORMAL_PRIORITY);
    }

    @Override
    protected void doReportBug(BugInstance bugInstance) {
        bugs.add(bugInstance);
    }

    public void finish() {
        System.out.println("Finished SpotBugs analysis");
        System.out.println("Results: ");
        if(bugs.getCollection().isEmpty()) {
            System.out.println("No bugs found");
        } else {
            System.out.println(String.format("%d bugs found", bugs.getCollection().size()));
            System.out.println(bugs);
        }

    }

    public void observeClass(JavaClass javaClass) {
        // TODO Auto-generated method stub

    }
    public void observeClass(ClassDescriptor classDescriptor) {
        // TODO Auto-generated method stub
    }

    public BugCollection getBugCollection() {
        return bugs;
    }

}
