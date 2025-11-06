package Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ProfileManager {

    public static void main(String[] args) {
        UserProfile originalProfile = new UserProfile("alice", 30, "ABC123");
        File saveFile = new File("userprofile.dat");

        System.out.println("Before Serialization:");
        System.out.println(originalProfile);

        // Create output stream and write to file
        try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(saveFile))) {
            outStream.writeObject(originalProfile);
            System.out.println("Saved to " + saveFile.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("Error occurred when writing original profile");
        }

        // update appVersion
        UserProfile.appVersion = "2.0";

        // Create input stream and read from file
        try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(saveFile))) {
            UserProfile deserializedProfile = (UserProfile) inStream.readObject();

            System.out.println();
            System.out.println("After Deserialization:");
            System.out.println(deserializedProfile);
        } catch (Exception e) {
            System.err.println("Error occurred when reading saved profile");
        }
    }
}
