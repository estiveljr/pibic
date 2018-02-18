
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Converter")
public class Converter extends HttpServlet {
    
    private int converter(int graus,String tipoConversao){
        int resultado = 0;
        if (tipoConversao.equals("C2F")) resultado = ((graus * 9) / 5) + 32;
        if (tipoConversao.equals("F2C")) resultado = ((graus - 32) * 5) / 9;
        return resultado;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int graus = Integer.parseInt(request.getParameter("Graus"));
        String tipoConversao = request.getParameter("tipoConversao");
        int resultado = converter(graus, tipoConversao);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Conversão de Graus</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>A conversão é igual a: " + resultado  + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}