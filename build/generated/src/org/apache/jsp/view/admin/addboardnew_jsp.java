package org.apache.jsp.view.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addboardnew_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  <!-- Start header section -->\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./header/header.jsp", out, true);
      out.write("\n");
      out.write("    <div class=\"content-wrapper\">\n");
      out.write("      <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("        <div class=\"row mt-3\">\n");
      out.write("          <div class=\"col-lg-12\">\n");
      out.write("            <div class=\"card\">\n");
      out.write("              <div class=\"card-body\">\n");
      out.write("                <div class=\"card-title\">Th??m tin t???c</div>\n");
      out.write("                <hr>\n");
      out.write("                <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/new/add\" method=\"post\">\n");
      out.write("                 \n");
      out.write("                  <div class=\"form-group\">\n");
      out.write("                    <label for=\"input-2\">T??n tin t???c</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"input-2\" placeholder=\"T??n tin t???c\" name=\"new-title\">\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"form-group\">\n");
      out.write("                    <label for=\"input-3\">N???i dung</label>\n");
      out.write("                    <textarea class=\"form-control\" rows=\"4\" id=\"input-17\" name=\"new-content\"></textarea>\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"form-group\">\n");
      out.write("                    <label for=\"input-3\">H??nh ???nh</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"input-18\" placeholder=\"?????a ch??? h??nh ???nh\" name=\"new-image_link\">\n");
      out.write("                  </div>\n");
      out.write("\t               <div class=\"form-group\">\n");
      out.write("\t                  <label for=\"input-4\">Ng?????i ????ng</label>\n");
      out.write("                  <div>\n");
      out.write("                    <select class=\"form-control valid\" id=\"input-4\" name=\"new-author\" required aria-invalid=\"false\">\n");
      out.write("                        <option>Th???nh D????ng</option>\n");
      out.write("                        <option>L?? Th???ch</option>\n");
      out.write("                        <option>Lan Ng???c</option>\n");
      out.write("                        <option>Kim Vy</option>\n");
      out.write("                    </select>\n");
      out.write("                  </div>\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"form-group\">\n");
      out.write("\t                  <label for=\"input-5\">Ng??y ????ng</label>\n");
      out.write("\t                  <input type=\"date\" class=\"form-control\" id=\"the-date\" name=\"new-created\">\n");
      out.write("\t              </div>\n");
      out.write("                 <div class=\"form-footer\">\n");
      out.write("                 \t\n");
      out.write("                    <button class=\"btn btn-danger\"><i class=\"fa fa-times\"></i><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/new/list\">H???y</a></button>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-success\"><i class=\"fa fa-check-square-o\"></i> Th??m</button>\n");
      out.write("                </div>\n");
      out.write("                </form>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"overlay toggle-menu\"></div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  <script>\n");
      out.write("\t\tvar date = new Date();\n");
      out.write("\t\t\n");
      out.write("\t\tvar day = date.getDate();\n");
      out.write("\t\tvar month = date.getMonth() + 1;\n");
      out.write("\t\tvar year = date.getFullYear();\n");
      out.write("\t\t\n");
      out.write("\t\tif (month < 10) month = \"0\" + month;\n");
      out.write("\t\tif (day < 10) day = \"0\" + day;\n");
      out.write("\t\t\n");
      out.write("\t\tvar today = year + \"-\" + month + \"-\" + day;\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\tdocument.getElementById('the-date').value = today;\n");
      out.write("</script>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./footer/footer.jsp", out, true);
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
