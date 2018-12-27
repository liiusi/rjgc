package test;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.Login;
import test.Zcinformation;;
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8"); // 设置请求的字符编码格式，与JSP登陆界面的字符编码保持一致
        /** 以下是获得表单提交过来的值 **/
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");
        String[] sex = request.getParameterValues("sex");
        System.out.println(sex);

        /** 以下代码将获得的表单值封装到用户信息对象中 **/
        Zcinformation user = new Zcinformation();
        user.setUsername(name);
        user.setPassword(pwd);
        user.setEmail(email);
        user.setUserSex(sex[0]);

        boolean flag = Login.getInstance().saveUser(user); // 将用户注册信息保存到数据库
        // [request.getRequestDispatcher]和[response.sendRedirect]两种请求转发的区别：
        // 前者转发时，URL地址不会改变，而后者转发时URL会发生变化。其次，前者的请求响应为同一个，而后者是重新创建新的请求与响应对象。
        if(flag){       // 当注册成功时，转发到success.jsp页面
            request.getSession().setAttribute("userName", user.getUsername());
            request.getRequestDispatcher("成功.jsp").forward(request, response);
        }else{      // 否则，转发到errorpage.jsp页面，显示错误信息！ 
            response.sendRedirect("errorpage.jsp");
        }
    }

}
