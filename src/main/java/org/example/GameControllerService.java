package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/pony")
public class GameControllerService extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String level = request.getParameter("level");
        String startNewGame = request.getParameter("newGame");

        if ("true".equals(startNewGame)){
            session.removeAttribute("currentQuestion");
            session.removeAttribute("currentQuestionIndex");
            session.removeAttribute("message");
        }
        List<GameQuestion> questions = GameQuestionBase.getInstance().getQuestions();

        if (!questions.isEmpty()){
            session.setAttribute("currentQuestion",questions.get(0));
            session.setAttribute("currentQuestionIndex",0);
            session.setAttribute("level",level);
            session.setAttribute("totalQuestion",questions.size());
            getServletContext().getRequestDispatcher("/pony.jsp").forward(request,response);
        } else {
            response.getWriter().println("Помилка: Не має доступних питань.");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        GameQuestion currentQuestion =(GameQuestion) session.getAttribute("currentQuestion");
        String userAnswerStr = request.getParameter("userAnswer");

        if (userAnswerStr != null && !userAnswerStr.isEmpty()){
            try {
                int userAnswer = Integer.parseInt(userAnswerStr);
                if(userAnswer == currentQuestion.getRightAnswer()){
                    session.setAttribute("message","Correct!");
                } else {
                    session.setAttribute("message","Incorrect");
                }
            }catch (NumberFormatException e){
                session.setAttribute("message","Error");
            }
        }
        List<GameQuestion> questions = GameQuestionBase.getInstance().getQuestions();
        int currentQuestionIndex = (Integer) session.getAttribute("currentQuestionIndex");
        if("true".equals(request.getParameter("restartButton"))){
            restartGame(session);
            response.sendRedirect("/pony.jsp");
            return;
        }
        session.setAttribute("currentQuestionIndex",currentQuestionIndex);
        session.setAttribute("totalQuestion",questions.size());

        if(currentQuestionIndex < questions.size() - 1){
            GameQuestion nextQuestion = questions.get(currentQuestionIndex + 1);
            session.setAttribute("currentQuestion",nextQuestion);
            session.setAttribute("currentQuestionIndex",currentQuestionIndex + 1);
            response.sendRedirect("/pony.jsp");
        } else {
            response.sendRedirect("/ponyResult.jsp");
        }
    }
    private void restartGame(HttpSession session){
        session.removeAttribute("currentQuestion");
        session.removeAttribute("currentQuestionIndex");
        session.removeAttribute("message");
        List<GameQuestion> questions = GameQuestionBase.getInstance().getQuestions();
        GameQuestion firstQuestion = questions.get(0);
        session.setAttribute("currentQuestion",firstQuestion);
        session.setAttribute("currentQuestionIndex",0);
    }

}
