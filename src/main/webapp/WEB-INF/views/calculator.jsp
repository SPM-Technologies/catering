<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculator Application</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }

        .container {
            max-width: 1200px;
            width: 100%;
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 30px;
        }

        .calculator-section, .history-section {
            background: white;
            border-radius: 20px;
            padding: 30px;
            box-shadow: 0 20px 60px rgba(0, 0, 0, 0.3);
        }

        h1, h2 {
            color: #333;
            margin-bottom: 20px;
            text-align: center;
        }

        h1 {
            font-size: 2em;
        }

        h2 {
            font-size: 1.5em;
        }

        .calculator-form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        .input-group {
            display: flex;
            flex-direction: column;
            gap: 8px;
        }

        label {
            color: #555;
            font-weight: 600;
            font-size: 0.95em;
        }

        input[type="number"], select {
            padding: 12px 15px;
            border: 2px solid #e0e0e0;
            border-radius: 10px;
            font-size: 1em;
            transition: all 0.3s;
        }

        input[type="number"]:focus, select:focus {
            outline: none;
            border-color: #667eea;
            box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);
        }

        select {
            cursor: pointer;
            background-color: white;
        }

        .button-group {
            display: flex;
            gap: 10px;
            margin-top: 10px;
        }

        button {
            flex: 1;
            padding: 14px;
            border: none;
            border-radius: 10px;
            font-size: 1em;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s;
        }

        .btn-calculate {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
        }

        .btn-calculate:hover {
            transform: translateY(-2px);
            box-shadow: 0 10px 25px rgba(102, 126, 234, 0.3);
        }

        .btn-clear {
            background: #e0e0e0;
            color: #555;
        }

        .btn-clear:hover {
            background: #d0d0d0;
        }

        .result-box {
            background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);
            color: white;
            padding: 20px;
            border-radius: 15px;
            text-align: center;
            margin-top: 20px;
            animation: slideIn 0.5s ease;
        }

        .result-box h3 {
            font-size: 1.2em;
            margin-bottom: 10px;
        }

        .result-box .result-value {
            font-size: 2em;
            font-weight: bold;
        }

        .error-box {
            background: #ff6b6b;
            color: white;
            padding: 15px;
            border-radius: 10px;
            text-align: center;
            margin-top: 20px;
            animation: shake 0.5s ease;
        }

        .history-list {
            max-height: 500px;
            overflow-y: auto;
            margin-top: 20px;
        }

        .history-item {
            background: #f8f9fa;
            padding: 15px;
            border-radius: 10px;
            margin-bottom: 10px;
            border-left: 4px solid #667eea;
            transition: all 0.3s;
        }

        .history-item:hover {
            transform: translateX(5px);
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
        }

        .history-item .calculation {
            font-weight: 600;
            color: #333;
            font-size: 1.1em;
            margin-bottom: 5px;
        }

        .history-item .timestamp {
            color: #888;
            font-size: 0.85em;
        }

        .empty-history {
            text-align: center;
            color: #999;
            padding: 40px;
            font-style: italic;
        }

        .clear-history-btn {
            width: 100%;
            background: #ff6b6b;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 10px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s;
            margin-top: 15px;
        }

        .clear-history-btn:hover {
            background: #ff5252;
            transform: translateY(-2px);
        }

        @keyframes slideIn {
            from {
                opacity: 0;
                transform: translateY(-20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        @keyframes shake {
            0%, 100% { transform: translateX(0); }
            25% { transform: translateX(-10px); }
            75% { transform: translateX(10px); }
        }

        @media (max-width: 768px) {
            .container {
                grid-template-columns: 1fr;
            }
        }

        .history-list::-webkit-scrollbar {
            width: 8px;
        }

        .history-list::-webkit-scrollbar-track {
            background: #f1f1f1;
            border-radius: 10px;
        }

        .history-list::-webkit-scrollbar-thumb {
            background: #667eea;
            border-radius: 10px;
        }

        .history-list::-webkit-scrollbar-thumb:hover {
            background: #764ba2;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="calculator-section">
            <h1>🧮 Calculator</h1>
            
            <form action="/calculate" method="post" class="calculator-form">
                <div class="input-group">
                    <label for="operand1">First Number:</label>
                    <input type="number" id="operand1" name="operand1" step="any" 
                           value="${operand1}" required>
                </div>

                <div class="input-group">
                    <label for="operator">Operation:</label>
                    <select id="operator" name="operator" required>
                        <option value="add" ${operator == 'add' ? 'selected' : ''}>➕ Addition (+)</option>
                        <option value="subtract" ${operator == 'subtract' ? 'selected' : ''}>➖ Subtraction (-)</option>
                        <option value="multiply" ${operator == 'multiply' ? 'selected' : ''}>✖️ Multiplication (×)</option>
                        <option value="divide" ${operator == 'divide' ? 'selected' : ''}>➗ Division (÷)</option>
                    </select>
                </div>

                <div class="input-group">
                    <label for="operand2">Second Number:</label>
                    <input type="number" id="operand2" name="operand2" step="any" 
                           value="${operand2}" required>
                </div>

                <div class="button-group">
                    <button type="submit" class="btn-calculate">Calculate</button>
                    <button type="reset" class="btn-clear">Clear</button>
                </div>
            </form>

            <c:if test="${not empty result}">
                <div class="result-box">
                    <h3>Result</h3>
                    <div class="result-value">${result}</div>
                </div>
            </c:if>

            <c:if test="${not empty error}">
                <div class="error-box">
                    <strong>Error:</strong> ${error}
                </div>
            </c:if>
        </div>

        <div class="history-section">
            <h2>📊 Calculation History</h2>
            
            <c:choose>
                <c:when test="${not empty history}">
                    <form action="/clear-history" method="post">
                        <button type="submit" class="clear-history-btn">Clear History</button>
                    </form>
                    
                    <div class="history-list">
                        <c:forEach items="${history}" var="item">
                            <div class="history-item">
                                <div class="calculation">
                                    ${item.operand1} 
                                    <c:choose>
                                        <c:when test="${item.operator == 'add'}">+</c:when>
                                        <c:when test="${item.operator == 'subtract'}">-</c:when>
                                        <c:when test="${item.operator == 'multiply'}">×</c:when>
                                        <c:when test="${item.operator == 'divide'}">÷</c:when>
                                    </c:choose>
                                    ${item.operand2} = ${item.result}
                                </div>
                                <div class="timestamp">${item.calculatedAt}</div>
                            </div>
                        </c:forEach>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="empty-history">
                        No calculations yet. Start calculating!
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</body>
</html>
