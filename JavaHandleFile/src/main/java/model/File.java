package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class File {
    public boolean copyWordOneTimes(String source, String destination) throws Exception {
        Path sourcePath = Paths.get(source);
        if (!Files.exists(sourcePath)) {
            throw new Exception("Path doesn't exist");
        }

        if (!Files.isReadable(sourcePath)) {
            throw new Exception("Can't read file");
        }

        Path destinationPath = Paths.get(destination);
        if (!Files.isWritable(destinationPath)) {
            throw new Exception("Can't write file");
        }

        Set<String> uniqueWords = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                uniqueWords.addAll(Arrays.asList(words));
            }
            reader.close();
        } catch (IOException e) {
            throw new Exception("Error reading file");
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for (String word : uniqueWords) {
                writer.write(word);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            throw new Exception("Error writing file");
        }
     
        return true;
    }
}