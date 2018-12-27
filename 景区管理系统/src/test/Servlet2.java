package test;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.Dl;
import test.Dlinformation;
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8"); // ����������ַ������ʽ����JSP��½������ַ����뱣��һ��
        /** �����ǻ�ñ��ύ������ֵ **/
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        /** ���´��뽫��õı�ֵ��װ���û���Ϣ������ **/
        Dlinformation user = new Dlinformation();
        user.setUsername(name);
        user.setPassword(pwd);


        boolean flag = Dl.getInstance().equals(user);// ���û�ע����Ϣ���浽���ݿ�
        // [request.getRequestDispatcher]��[response.sendRedirect]��������ת��������
        // ǰ��ת��ʱ��URL��ַ����ı䣬������ת��ʱURL�ᷢ���仯����Σ�ǰ�ߵ�������ӦΪͬһ���������������´����µ���������Ӧ����
        if(flag){       // ��ע��ɹ�ʱ��ת����success.jspҳ��
            request.getSession().setAttribute("userName", user.getUsername());
            request.getRequestDispatcher("ѡ��.jsp").forward(request, response);

        }else{      // ����ת����errorpage.jspҳ�棬��ʾ������Ϣ��
            response.sendRedirect("����.jsp");
        }
    }

}
