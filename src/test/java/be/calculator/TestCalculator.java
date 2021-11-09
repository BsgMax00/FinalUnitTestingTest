package be.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculator {
    @Test
    void CodeIsNull(){
        Double result = new CodeCalculator().getResult(null);
        assertEquals(0, result);
    }

    @Test
    void CodeIsEmpty(){
        Double result = new CodeCalculator().getResult("");
        assertEquals(0, result);
    }

    @Test
    void NormalTestAdding(){
        Double result = new CodeCalculator().getResult("&+(5,4,1)");
        assertEquals(10, result);
    }

    @Test
    void NormalTestSubtracting(){
        Double result = new CodeCalculator().getResult("&-(9,4,1)");
        assertEquals(4, result);
    }

    @Test
    void NormalTestMultiplying(){
        Double result = new CodeCalculator().getResult("&*(5,4,1)");
        assertEquals(20, result);
    }

    @Test
    void NormalTestDividing(){
        Double result = new CodeCalculator().getResult("&/(10,2)");
        assertEquals(5, result);
    }

    @Test
    void TestWithoutFirstCharAdding(){
        Double result = new CodeCalculator().getResult("+(5,4,1)");
        assertEquals(10, result);
    }

    @Test
    void TestWithoutFirstCharSubtracting(){
        Double result = new CodeCalculator().getResult("-(9,4,1)");
        assertEquals(14, result);
    }

    @Test
    void TestWithoutFirstCharMultiplying(){
        Double result = new CodeCalculator().getResult("*(5,4,1)");
        assertEquals(10, result);
    }

    @Test
    void TestWithoutFirstCharDividing(){
        Double result = new CodeCalculator().getResult("/(10,2)");
        assertEquals(12, result);
    }

    @Test
    void TestWithoutOperation(){
        Double result = new CodeCalculator().getResult("&(4,5,1)");
        assertEquals(10, result);
    }

    @Test
    void TestWithoutFirstCharNoOperation(){
        Double result = new CodeCalculator().getResult("(4,5,1)");
        assertEquals(10, result);
    }

    @Test
    void TestWithoutFirstCharNoOperationNoBrackets(){
        Double result = new CodeCalculator().getResult("4,5,1");
        assertEquals(10, result);
    }

    @Test
    void TestWithSpaces(){
        Double result = new CodeCalculator().getResult("&+(4,    5, 1)");
        assertEquals(10, result);
    }

    @Test
    void TestWithoutFirstCharWithSpaces(){
        Double result = new CodeCalculator().getResult("+(4,    5, 1)");
        assertEquals(10, result);
    }

    @Test
    void TestWithoutFirstCharNoOperationWithSpaces(){
        Double result = new CodeCalculator().getResult("(4,    5, 1)");
        assertEquals(10, result);
    }

    @Test
    void TestWithoutFirstCharNoOperationNoBracketsWithSpaces(){
        Double result = new CodeCalculator().getResult("4,      5,     1");
        assertEquals(10, result);
    }
}
