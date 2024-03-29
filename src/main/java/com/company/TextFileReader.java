package com.company;

import javafx.scene.control.ComboBox;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextFileReader {
    private File file;
    private ArrayList<String> textBlocks;

    public ArrayList<String> getTextBlocks() {
        return textBlocks;
    }
    public TextFileReader(File file) {
        this.file = file;
        textBlocks = new ArrayList<>();
    }

    public void readTextFile(ComboBox<String> comboBox) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder currentBlock = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("{TEXT_END}")) {
                    textBlocks.add(currentBlock.toString());
                    currentBlock = new StringBuilder();
                    continue;
                }
                if (line.trim().length() == 0) {
                    currentBlock.append("\n");
                } else {
                    currentBlock.append(line + "\n");
                }
            }
            textBlocks.add(currentBlock.toString());

            for (String textBlock : textBlocks) {
                int charactersInBlock = textBlock.length();
                int substring = (int) (charactersInBlock*3.0f/100.0f);
                comboBox.getItems().add(textBlock.substring(0, substring));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}