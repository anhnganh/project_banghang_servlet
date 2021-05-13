package org.apache.jsp.view.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class editcate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("  <!-- Start header section -->\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./header/header.jsp", out, true);
      out.write("\n");
      out.write("    <div class=\"content-wrapper\">\n");
      out.write("      <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("        <div class=\"row mt-3\">\n");
      out.write("          <div class=\"col-lg-8\">\n");
      out.write("            <div class=\"card\">\n");
      out.write("              <div class=\"card-body\">\n");
      out.write("                <div class=\"card-title\">Sửa chuyên mục</div>\n");
      out.write("                <hr>\n");
      out.write("          \t\n");
      out.write("\t                <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/cate/edit\" method=\"post\">\n");
      out.write("\t                  <div class=\"form-group\">\n");
      out.write("\t                    <label for=\"input-1\">ID</label>\n");
      out.write("\t                    <input type=\"text\" class=\"form-control\" readonly id=\"input-1\" placeholder=\"ID\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${catelist.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t                  </div>\n");
      out.write("\t                  <div class=\"form-group\">\n");
      out.write("\t                    <label for=\"input-1\">Tên chuyên mục</label>\n");
      out.write("\t                    <input type=\"text\" class=\"form-control\" id=\"input-1\" placeholder=\"Tên chuyên mục\" name=\"name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${catelist.name }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t                  </div>\n");
      out.write("\t\t              <div class=\"form-group\">\n");
      out.write("\t\t                  <label for=\"input-2\">Chuyên mục cha</label>\n");
      out.write("\t\t                  <div>\n");
      out.write("\t\t                     <select class=\"form-control valid\" id=\"input-6\" name=\"parent-id\" required aria-invalid=\"false\">\n");
      out.write("\t\t                        <option value=\"0\">NULL</option>\n");
      out.write("\t\t                       <option value=\"1\">Sản phẩm mới</option>\n");
      out.write("\t\t                    </select>\n");
      out.write("\t\t                  </div>\n");
      out.write("\t\t               </div>\n");
      out.write("\t                   <div class=\"form-footer\">\n");
      out.write("\t                      <button class=\"btn btn-danger\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/cate/list\">Hủy</a></button>\n");
      out.write("                         \n");
      out.write("                     \t\t<button type=\"submit\" class=\"btn btn-success\">Cập nhật</button>\n");
      out.write("\t                   </div> \n");
      out.write("\t               \n");
      out.write("\t                </form>\n");
      out.write("\t                 \n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"overlay toggle-menu\"></div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  \n");
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
