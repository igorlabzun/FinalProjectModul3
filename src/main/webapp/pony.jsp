<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.example.GameQuestion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Little Pony</title>
    <link rel="stylesheet" type="text/css" href="./static/my.style.css">
    <script type="text/javascript" src="script.js"></script>
</head>
<body>
<div class="container">
    <div class="pony-header">
        <h1>My Little Pony</h1>
    </div>
    <form id="pony-form" action="/pony" method="post">
        <div class="pony-question">
            <%
                GameQuestion currentQuestion = (GameQuestion) session.getAttribute("currentQuestion");
                String questionImage = currentQuestion.getQuestion();
            %>

            <div class="question-image-container">
                <img src="<%=questionImage%>" alt="Зображення питання" class="question-image" width="200">
            </div>

            <div class="pony-info">Питання ${sessionScope.currentQuestionIndex + 1} з ${sessionScope.totalQuestion}</p></div>
        </div>
        <div class="pony-options">
            <div class="form-check">
                <input class="form-check-input" type="radio" name="userAnswer" value="1" id="option1">
                <label class="form-check-label" for="option1">${currentQuestion.getAnswerOption1()}</label><br>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="userAnswer" value="2" id="option2">
                <label class="form-check-label" for="option1">${currentQuestion.getAnswerOption2()}</label><br>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="userAnswer" value="3" id="option3">
                <label class="form-check-label" for="option1">${currentQuestion.getAnswerOption3()}</label><br>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="userAnswer" value="4" id="option4">
                <label class="form-check-label" for="option1">${currentQuestion.getAnswerOption4()}</label><br>
            </div>
        </div>
        <div class="pony-submit">
            <input type="submit" class="btn" id="submit-button" value="Відправити" onclick="return validateSelection();"/>
        </div>
        <div class="pony-timer">
            <p>Час до завершення відповіді:<span id="timer"></span></p>
        </div>
        <div class="hidden-element" id="answer-alert">
            ${message}
        </div>
        <div class="hidden-element" id="level">
            ${sessionScope.level}
        </div>
    </form>

    <div class="pony-timer-message">
        <p id="timer-message"></p>
    </div>
    <div class="pony-restart">
        <button id="restart-button" onclick="restartGame();"> Почати заново </button>
    </div>
    <div class="go-home">
        <button class="btn" onclick="goHome();" > На головну </button>
    </div>
</div>

</body>
</html>