package gin;

import gin.util.AndroidTest;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestDeletePatch {
    private final ArrayList<Integer> toRemove;
    private SourceFile file;
    private final String path;
    public AndroidTest test;

    public TestDeletePatch(AndroidTest test) {
        this.test = test;
        path = test.fileName;
        ArrayList<Integer> lines = testLines();
        System.out.println(test + " " + lines + " " + path);
        toRemove = new ArrayList<>();
        for (int line : lines) {
            toRemove.add(line);
        }
    }

    public ArrayList<Integer> getEdits() {
        return toRemove;
    }

    public ArrayList<Integer> testLines() {
        try {
            Scanner lines = new Scanner(new File(path));
            ArrayList<Integer> out = new ArrayList<>();
            int current = 0;
            int annoCount = 0;
            while (lines.hasNext()) {
                String line = lines.nextLine();
                current += 1;


                if (line.contains(test.getMethodName())) {
                    for (int i = current; i >= current - annoCount; i--) {
                        out.add(i);
                    }
                    annoCount = 0;
                    int depth = 1;
                    while (depth > 0) {
                        String testLine = lines.nextLine();
                        current += 1;
                        out.add(current);
                        if (testLine.contains("}")) {
                            depth -= StringUtils.countMatches(testLine, "}");
                        }
                        if (testLine.contains("{")) {
                            depth += StringUtils.countMatches(testLine, "{");
                        }
                    }
                } else if (line.trim().startsWith("@")) {
                    annoCount++;
                } else {
                    annoCount = 0;
                }
            }
            return out;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
