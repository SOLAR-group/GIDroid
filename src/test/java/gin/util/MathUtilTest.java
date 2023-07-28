package gin.util;

import org.junit.Test;

public class MathUtilTest {

    @Test
    public void factorialTest() {
        assert MathsUtils.factorial(1) == 1;
        assert MathsUtils.factorial(2) == 2;
        assert MathsUtils.factorial(3) == 6;
        assert MathsUtils.factorial(4) == 24;

    }

    @Test
    public void chooseTest() {
        assert MathsUtils.choose(5, 2) == 10;
        assert MathsUtils.choose(9, 2) == 36;
        assert MathsUtils.choose(17, 4) == 2380;
    }
}
