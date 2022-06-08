package org.example.v1.drug.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.v1.drug.entity.Drug;
import org.example.v1.drug.controller.DrugController;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

//Сервлет для получения списка лекарств
@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private final DrugController drugController;

    public ListServlet(DrugController drugController) {
        this.drugController = drugController;
    }

    @Override
    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    //вывод списка лекарств
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //создаем коллекцию
        List<Drug> drugs = drugController.findAllDrugs();

        //задаем атрибут коллекции и перенаправляем дальше
        req.setAttribute("drugsFromServer", drugs);
        req.getServletContext().getRequestDispatcher("/list.jsp")
                .forward(req, resp);
    }

        @Override
        protected void doPost (HttpServletRequest request,
                HttpServletResponse response)
            throws IOException, ServletException {
            String name = request.getParameter("name");
            String date = request.getParameter("date");
            String nameInstruction = name.toLowerCase(Locale.ROOT);

            Drug drug = new Drug(name.toLowerCase(), date, nameInstruction);
            drugController.saveDrug(drug);

            doGet(request, response);
        }
    }


