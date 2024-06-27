let timerSeconds;

function setTimerDuration(){
    let levelElement = document.getElementById('level');
    let levelText = levelElement.textContent.trim().toLowerCase();

    if(levelText == 'easy'){
        timerSeconds = 28;
    } else if (levelText == 'hard'){
        timerSeconds = 5;
    }else {
        timerSeconds = 14;
    }
}
function updateTimer(){
    document.getElementById('timer').innerHTML = timerSeconds + "сек";
    timerSeconds--;

    if (timerSeconds < 0){
        document.getElementById('pony-form').style.display ='none';
        document.getElementById('timer-message').innerHTML = "Час вичерпано!";
        document.getElementById('answer-alert').style.display ='block';
        document.getElementById('pony-form').style.display ='block';
        makeScreenRed()
    }else {
        setTimeout(updateTimer,1000)
    }
}

function validateSelection(){
    let selectedOption = document.querySelector('input[name="userAnswer"]:checked');
    let answerAlert = document.getElementById('answer-alert');

    if(!selectedOption){
        answerAlert.style.display = 'block';
        return false;
    } else{
        answerAlert.style.display = 'none';
        return true;
    }
}

function validateForm(){
    let answerAlert = document.getElementById('answer-alert');
    if (answerAlert.innerText.trim() === "Incorrect"){
        makeScreenRed();
        document.getElementById("pony-form").style.display = 'none';
        document.getElementById('timer-message').innerHTML = "Неправильна відповідь.Гра закінчена!";
        answerAlert.style.display = 'block';
        document.getElementById('restart-button').style.display = 'block';
    } else if (answerAlert.innerText.trim() === "Correct!"){
        makeScreenGreen();
    }
}

function makeScreenGreen() {
    let opacity = 1;
    const interval = 20;
    const duration = 1000;
    const steps = duration / interval;

    const intervalId = setInterval(function () {
        document.body.style.backgroundColor =`rgba(144,238,144 ${opacity}`;
        opacity -= 1 / steps;

        if(opacity <= 0){
            clearInterval(intervalId);
            document.body.style.backgroundColor = '';
        }
    },interval);
}
function  makeScreenRed(){
    let opacity = 1;
    const interval = 20;
    const duration = 1500;
    const steps = duration / interval;
    const intervalId = setInterval(function () {
        document.body.style.backgroundColor =`rgba(220,20,60 ${opacity}`;
        opacity -= 1 / steps;

        if(opacity <= 0){
            clearInterval(intervalId);
            document.body.style.backgroundColor = '';
        }
    },interval);
}

window.onload = function (){
    setTimerDuration();
    updateTimer();
    validateForm();
}
function restartGame(){
    let restartInput = document.createElement('input');
    restartInput.type = 'hidden';
    restartInput.name = 'restartButton';
    restartInput.value = 'true';
    document.getElementById('pony-form').appendChild(restartInput);
    document.getElementById('pony-form').submit();
}
function goHome(){
    window.location.href = "index.jsp";
}