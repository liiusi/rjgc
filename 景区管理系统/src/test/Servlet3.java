package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet3
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        request.setCharacterEncoding("UTF-8"); // ����������ַ������ʽ����JSP��½������ַ����뱣��һ��
	        /** �����ǻ�ñ��ύ������ֵ **/
	        String email = request.getParameter("email");
	        String passwd=request.getParameter("passwd");
	        

	        /** ���´��뽫��õı�ֵ��װ���û���Ϣ������ **/
	        Wjmm user = new Wjmm();
	        user.setEmail(email);
	        user.setPasswd(passwd);



	        boolean flag = Xg.getInstance().equals(user);// ���û�ע����Ϣ���浽���ݿ�
	        // [request.getRequestDispatcher]��[response.sendRedirect]��������ת��������
	        // ǰ��ת��ʱ��URL��ַ����ı䣬������ת��ʱURL�ᷢ���仯����Σ�ǰ�ߵ�������ӦΪͬһ���������������´����µ���������Ӧ����
	        if(flag){       // ��ע��ɹ�ʱ��ת����success.jspҳ��
//	            request.getSession().setAttribute("userName", user.getUsername());
	            request.getRequestDispatcher("�ɹ�.jsp").forward(request, response);

	        }else{      // ����ת����errorpage.jspҳ�棬��ʾ������Ϣ��
	            response.sendRedirect("����.jsp");
	        }
	}

}
