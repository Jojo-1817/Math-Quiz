<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Interactive Math Quiz</title>
  <style>
    body { font-family: Arial, sans-serif; max-width: 600px; margin: 40px auto; }
    .question { background: #f9f9f9; border: 1px solid #ddd;
                padding: 15px; margin-bottom: 15px; border-radius: 4px; }
  </style>
</head>
<body>
  <h2 style="text-align:center">Interactive Math Quiz</h2>
  <form action="ScoreServlet" method="post">
    <div class="question">
      <h3>1. What is 5 + 3?</h3>
      <input type="checkbox" name="q1" value="6"> 6<br>
      <input type="checkbox" name="q1" value="7"> 7<br>
      <input type="checkbox" name="q1" value="8"> 8<br>
      <input type="checkbox" name="q1" value="9"> 9
    </div>
    <div class="question">
      <h3>2. What is 10 - 4?</h3>
      <input type="checkbox" name="q2" value="4"> 4<br>
      <input type="checkbox" name="q2" value="5"> 5<br>
      <input type="checkbox" name="q2" value="6"> 6<br>
      <input type="checkbox" name="q2" value="7"> 7
    </div>
    <div class="question">
      <h3>3. What is 7 x 3?</h3>
      <input type="checkbox" name="q3" value="18"> 18<br>
      <input type="checkbox" name="q3" value="20"> 20<br>
      <input type="checkbox" name="q3" value="21"> 21<br>
      <input type="checkbox" name="q3" value="24"> 24
    </div>
    <input type="submit" value="Submit Quiz">
  </form>
</body>
</html>