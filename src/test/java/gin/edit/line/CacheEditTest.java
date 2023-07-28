package gin.edit.line;

import gin.SourceFile;
import gin.SourceFileLine;
import gin.edit.Edit;
import junit.framework.TestCase;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class CacheEditTest {
    public String path="examples/ExamplesAndroid/AntennaPod//AntennaPod/core/src/main/java/de/danoeh/antennapod/core/util/id3reader/ID3Reader.java";

    @Before
    public void setUp() {
        List<Class<? extends Edit>> editTypes = Edit.parseEditClassesFromString(Edit.EditType.LINE.toString());
        List<String> targetMethod = new ArrayList<>();
        targetMethod.add("");
        SourceFileLine sourceFile =  (SourceFileLine) SourceFile.makeSourceFileForEditTypes(editTypes, path, targetMethod);
    }


}