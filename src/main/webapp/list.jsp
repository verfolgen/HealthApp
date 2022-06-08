<%@ page import="java.util.ArrayList" %>
<%@ page import="org.example.v1.drug.entity.Drug" %>
<!--JSP для получения списка лекарств-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Список медикаментов</title>
    <style>
      body {background-color: #64e7f7;}
      a {
        text-decoration: none;
      }
      h1   {color: #1515eb; font-size: 80px; font-style: oblique;
        font-family: "Century Gothic"; text-align: center}
      h2 {color: #e2270f; font-style: oblique;
        font-family: "Century Gothic"; text-align: center;
        font-size: 50px}
        th {
          color: #e2270f; background: #64e7f7; font-size: 50px;font-style: oblique;
          font-family: "Century Gothic"; text-align: center;
          padding: 8px;
        }
        tr {
          color: #e2270f; background: #64e7f7; font-size: 40px;font-style: oblique;
          font-family: "Century Gothic"; text-align: center;
          padding: 3px;
        }

        td{
          color: #e2270f; background: #64e7f7; font-size: 40px;font-style: oblique;
          font-family: "Century Gothic"; text-align: center;
          padding: 3px;
        }
        table{
          border-color: #e2270f; border-collapse: collapse;
        }

      input { display: table-cell; }


    </style>
  </head>


  <body>
  <div class="form-style-6">
    <form method="post" action="/delete">
  <%
    ArrayList <Drug> drugs = (ArrayList) request.getAttribute("drugsFromServer");
  %>
  <h1>Список медикаментов</h1>

  <table border="1"; align="center">
    <tr>
      <th>Наименование</th>
      <th>Срок годности</th>
      <th>Инструкция</th>
      <th>Удаление</th>
    </tr>

    <%for(Drug drug:drugs) {

    %>

    <tr>
      <td><%=drug.getName()%></td>
      <td><%=drug.getDate()%></td>
    <% String adress = "https://www.vidal.ru/search?t=all&q=" + drug.getInstruction();%>
    <td><a href="<%=adress%>" target="_blank">Инструкция</a></td>
      <td><input type="hidden" name="id" value="<%=drug.getId()%>">
        <input type="submit" value="Удалить" /></td>

    </tr>
    <%}%>



  </table>
  </div>
  </form>

      <form  method="post" action="welcome1.html">
        <input type="submit" name="" value="Домой" />
      </form>


  </body>
</html>
