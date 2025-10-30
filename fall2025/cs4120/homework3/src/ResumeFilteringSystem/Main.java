package ResumeFilteringSystem;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static ArrayList<Resume> resumes = new ArrayList<>(Arrays.asList(
            new Resume("Alice", 5, new ArrayList<>(Arrays.asList("Java", "Spring", "AWS")), new Address("123 Elm St", "New York", "NY", "10001")),
            new Resume("Bob", 3, new ArrayList<>(Arrays.asList("Python", "ML", "TensorFlow")), new Address("456 Pine St", "San Francisco", "CA", "94105")),
            new Resume("Charlie", 5, new ArrayList<>(Arrays.asList("Java", "Spring", "AWS")), new Address("123 Elm St", "New York", "NY", "10001")),
            new Resume("Eve", 3, new ArrayList<>(Arrays.asList("Python", "ML", "TensorFlow")), new Address("456 Pine St", "San Francisco", "CA", "94105"))
    ));
    private static ArrayList<Resume> duplicateResumes = new ArrayList<>();
    private static ArrayList<Resume> uniqueResumes = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("--- All Received Applications ---");
        System.out.println();

        for (Resume resume : resumes) {
            System.out.println(resume.toString());
            System.out.println();
        }

        System.out.println("--- Duplicate Applications Found ---");
        System.out.println();

        for (Resume resume : resumes) {
            // if resume isn't already in uniqueResumes, add it
            if (!uniqueResumes.contains(resume)) {
                uniqueResumes.add(resume);
            } else {
                // if resume is already in uniqueResumes, add it to duplicateResumes
                duplicateResumes.add(resume);
                System.out.println(resume);
                System.out.println();
            }
        }

        System.out.println("--- Final Unique Applications ---");
        System.out.println();

        for (Resume resume : uniqueResumes) {
            System.out.println(resume);
            System.out.println();
        }

        System.out.println("Total Unique Applications: " + uniqueResumes.size());
    }
}
