package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        String weight = request.getParameter("weight");
        String height = request.getParameter("height");
        
        
        //TODO: calculate bmi
        double weightInt = Double.parseDouble(weight);
        double heightInt = Double.parseDouble(height);
        double bmi = weightInt/(heightInt*heightInt);
        int BMI = (int) Math.round(bmi);
       
        //TODO: determine the built from BMI
        
        String BmiType;
        if(BMI < 18.5)
            BmiType = "underweight";
        else if(BMI >= 18.5 && BMI < 25)
            BmiType = "normal";
        else if(BMI >= 25 && BMI < 30)
            BmiType = "overweight";
        else if(BMI >= 30 && BMI < 35)
            BmiType = "obese";
        else
            BmiType = "extremely obese";
        
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("BMI",BMI);
        request.setAttribute("BmiType", BmiType);

        //TODO: forward to jsp
        request.getRequestDispatcher("bmi_result.jsp").forward(request, response);
           
    }
    
}
