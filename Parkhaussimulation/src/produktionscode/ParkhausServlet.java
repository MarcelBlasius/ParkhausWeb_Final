package produktionscode;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.IF_Controller;

// Author: Team
@WebServlet("/Parkhaus")
public class ParkhausServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] requestParamString = request.getQueryString().split("=");
		String command = requestParamString[0];
		String param = requestParamString[1];

		Controller c = (Controller) getPersistentController();

		System.out.println("Command = " + command);
		System.out.println("Param = " + param);

		if ("cmd".equals(command)) {
			PrintWriter out = response.getWriter();
			String ausgabe = c.doGet(param);
			out.println(ausgabe);
			System.out.println("Get ausgabe: " + ausgabe);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String body = getBody(request);
		System.out.println("body= " + body);
		String[] params = body.split(",");
		String event = params[0];
		IF_Controller c = getPersistentController();

		String ausgabe = c.doPost(event, params);

		if (event.equals("enter")) {
			if (Integer.parseInt(ausgabe) == 0) {
				PrintWriter out = response.getWriter();
				out.println(-1);
			} else {
				PrintWriter out = response.getWriter();
				out.println(Integer.parseInt(ausgabe));
				System.out.println("Post ausgabe: " + ausgabe);
			}
		}
		setPersistentController(c);
	}

	private static String getBody(HttpServletRequest request) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
		return stringBuilder.toString();
	}

	private ServletContext getApplication() {
		return getServletConfig().getServletContext();
	}

	private IF_Controller getPersistentController() {
		ServletContext application = getApplication();
		IF_Controller c = (IF_Controller) application.getAttribute("Controller");
		if (c == null) {
			c = Controller.getInstance();
		}
		return c;
	}

	private void setPersistentController(IF_Controller c) {
		ServletContext application = getApplication();
		application.setAttribute("Controller", c);

	}
}