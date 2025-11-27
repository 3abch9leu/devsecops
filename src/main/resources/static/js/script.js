let display = document.getElementById('display');
let resultFloat = document.getElementById('result-float');
let historyDiv = document.getElementById('history');
let themeBtn = document.getElementById('theme-btn');

// Toggle thème clair/sombre
themeBtn.addEventListener('click', () => {
    if(document.body.classList.contains('light-theme')){
        document.body.classList.replace('light-theme','dark-theme');
        themeBtn.textContent = "☀️ Light Mode";
    } else {
        document.body.classList.replace('dark-theme','light-theme');
        themeBtn.textContent = "🌙 Dark Mode";
    }
});

function appendValue(value) {
    display.value += value;
    evaluateLive();
}

function clearDisplay() {
    display.value = '';
    resultFloat.innerText = '0';
    historyDiv.innerHTML = '';
}

function evaluateExpression() {
    try {
        let result = safeEval(display.value);
        historyDiv.innerHTML += `<div onclick="reuseHistory('${display.value}')">${display.value} = ${result}</div>`;
        display.value = result;
        resultFloat.innerText = '';
        historyDiv.scrollTop = historyDiv.scrollHeight;
    } catch (err) {
        display.value = "Erreur";
    }
}

function reuseHistory(expr) {
    display.value = expr;
    evaluateLive();
}

function evaluateLive() {
    try {
        let result = safeEval(display.value);
        resultFloat.innerText = result;
        display.style.color = "#fff";
    } catch (err) {
        resultFloat.innerText = '';
        display.style.color = "#ff6b6b";
    }
}

// Convertir degrés en radians
function deg2rad(deg) { return deg * Math.PI / 180; }

// Factorielle
function factorial(n) {
    n = parseInt(n);
    if (n < 0) return NaN;
    let res = 1;
    for (let i = 2; i <= n; i++) res *= i;
    return res;
}

// Évaluer expression avec fonctions scientifiques
function safeEval(expr) {
    expr = expr.replace(/sin\(/g, 'Math.sin(deg2rad(');
    expr = expr.replace(/cos\(/g, 'Math.cos(deg2rad(');
    expr = expr.replace(/tan\(/g, 'Math.tan(deg2rad(');
    expr = expr.replace(/log\(/g, 'Math.log(');
    expr = expr.replace(/log10\(/g, 'Math.log10(');
    expr = expr.replace(/sqrt\(/g, 'Math.sqrt(');
    expr = expr.replace(/\^/g, '**');
    expr = expr.replace(/(\d+)!/g, (_, n) => factorial(n));
    return eval(expr);
}

// Clavier
document.addEventListener('keydown', function(event) {
    const allowedKeys = "0123456789+-*/().^";
    if (allowedKeys.includes(event.key)) {
        appendValue(event.key);
    } else if (event.key === 'Enter') {
        evaluateExpression();
    } else if (event.key === 'Backspace') {
        display.value = display.value.slice(0, -1);
        evaluateLive();
    } else if (event.key.toLowerCase() === 'c') {
        clearDisplay();
    }
});
