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

@WebServlet("/find")
public class FindServlet extends HttpServlet {
    private final DrugController drugController;

    public FindServlet (DrugController drugController) {
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

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {



        String name = req.getParameter("name");
        List<Drug> drugsFind = drugController.findDrug(name);

        //задаем атрибут коллекции и перенаправляем дальше
        req.setAttribute("drugsFind", drugsFind);


        req.getServletContext().getRequestDispatcher
                        ("/findList.jsp")
                .forward(req, resp);
    }
}
