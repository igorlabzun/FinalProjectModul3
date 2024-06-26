package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameQuestionTest {

    @Test
    public void testGetQuestion() {
        GameQuestion question = new GameQuestion("Third planet from the sun?","Venus","Mars","Earth","Jupiter",3);
        assertEquals("Third planet from the sun?",question.getQuestion());
    }

    @Test
    public void testGetAnswerOption1() {
        GameQuestion question = new GameQuestion("Third planet from the sun?","Venus","Mars","Earth","Jupiter",3);
        assertEquals("Venus",question.getAnswerOption1());
    }

    @Test
    public void testGetAnswerOption2() {
        GameQuestion question = new GameQuestion("Third planet from the sun?","Venus","Mars","Earth","Jupiter",3);
        assertEquals("Mars",question.getAnswerOption2());
    }

    @Test
    public void testGetAnswerOption3() {
        GameQuestion question = new GameQuestion("Third planet from the sun?","Venus","Mars","Earth","Jupiter",3);
        assertEquals("Earth",question.getAnswerOption3());
    }

    @Test
    public void testGetAnswerOption4() {
        GameQuestion question = new GameQuestion("Third planet from the sun?","Venus","Mars","Earth","Jupiter",3);
        assertEquals("Jupiter",question.getAnswerOption4());
    }

    @Test
    public void testGetRightAnswer() {
        GameQuestion question = new GameQuestion("Third planet from the sun?","Venus","Mars","Earth","Jupiter",3);
        assertEquals(3,question.getRightAnswer());
    }
}