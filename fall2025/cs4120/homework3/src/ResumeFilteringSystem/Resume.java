package ResumeFilteringSystem;

import java.util.ArrayList;
import java.util.Objects;

public class Resume {

    private String candidateName;
    private int yearsOfExperience;
    private ArrayList<String> skills;
    private Address address;

    public Resume(String candidateName, int yearsOfExperience, ArrayList<String> skills, Address address) {
        this.candidateName = candidateName;
        this.yearsOfExperience = yearsOfExperience;
        this.skills = skills;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format(
                "Name: %s\nExperience: %d years\nSkills: %s\nAddress: %s",
                this.candidateName, this.yearsOfExperience, this.skills.toString(), this.address.toString()
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Resume)) {
            return false;
        }
        Resume otherResume = (Resume) other;
        // Assuming Address has fields like street, city, and zipCode
        return Objects.equals(this.yearsOfExperience, otherResume.yearsOfExperience)
                && Objects.equals(this.skills, otherResume.skills)
                && Objects.equals(this.address, otherResume.address);
    }
}
