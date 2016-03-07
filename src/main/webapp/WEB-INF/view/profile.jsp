<%--
  Created by IntelliJ IDEA.
  User: donghoon
  Date: 2016. 3. 3.
  Time: 오후 1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Hello</title>
    <link rel="stylesheet" href="<c:url value="/resources/bower/bootstrap/dist/css/bootstrap.min.css" /> ">
    <link rel="stylesheet" href="<c:url value="/resources/bower/font-awesome/css/font-awesome.min.css" /> ">
    <link rel="stylesheet" href="<c:url value="/resources/bower/AdminLTE/dist/css/AdminLTE.min.css" /> ">
    <link rel="stylesheet" href="<c:url value="/resources/bower/AdminLTE/dist/css/skins/skin-blue.min.css" /> ">
    <link rel="stylesheet"
          href="<c:url value="/resources/bower/AdminLTE/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" /> ">
    <link rel="stylesheet" href="<c:url value="/resources/bower/AdminLTE/plugins/morris/morris.min.js" /> ">
    <link rel="stylesheet" href="<c:url value="/resources/bower/AdminLTE/plugins/datepicker/datepicker3.css" /> ">
    <link rel="stylesheet"
          href="<c:url value="/resources/bower/AdminLTE/plugins/daterangepicker/daterangepicker-bs3.css" /> ">
    <link rel="stylesheet"
          href="<c:url value="/resources/bower/AdminLTE/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" /> ">

</head>
<body class="skin-blue sidebar-mini" cz-shortcut-listen="true" style="">
<div class="wrapper">
    <jsp:include page="templates/header.jsp"/>
    <jsp:include page="templates/sidebar-left.jsp"/>
    <jsp:include page="templates/main-contents.jsp"/>
    <jsp:include page="templates/footer.jsp"/>
    <jsp:include page="templates/sidebar-right.jsp"/>
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg" style="position: fixed; height: auto;"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 2.1.4 -->
<script async="" src="//www.google-analytics.com/analytics.js"></script>
<script async="" type="text/javascript" src="https://www.googletagservices.com/tag/js/gpt.js"></script>
<script src="<c:url value='/resources/bower/AdminLTE/plugins/jQuery/jQuery-2.1.4.min.js' />"></script>
<!-- Bootstrap 3.3.5 -->
<script src="<c:url value='/resources/bower/bootstrap/dist/js/bootstrap.min.js'/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value="/resources/bower/AdminLTE/dist/js/app.min.js"/>"></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:url value="/resources/bower/AdminLTE/dist/js/demo.js"/>"></script>
<!-- AdminLTE plugins -->
<script src="<c:url value="/resources/bower/AdminLTE/plugins/morris/morris.min.js"/>"></script>
<script src="<c:url value="/resources/bower/AdminLTE/plugins/sparkline/jquery.sparkline.min.js"/>"></script>
<script src="<c:url value="/resources/bower/AdminLTE/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"/>"></script>
<script src="<c:url value="/resources/bower/AdminLTE/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"/>"></script>
<script src="<c:url value="/resources/bower/AdminLTE/plugins/knob/jquery.knob.js"/>"></script>
<script src="<c:url value="/resources/bower/AdminLTE/plugins/daterangepicker/daterangepicker.js"/>"></script>
<script src="<c:url value="/resources/bower/AdminLTE/plugins/datepicker/bootstrap-datepicker.js"/>"></script>
<script src="<c:url value="/resources/bower/AdminLTE/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"/>"></script>
<script src="<c:url value="/resources/bower/AdminLTE/plugins/slimScroll/jquery.slimscroll.min.js"/>"></script>
<script src="<c:url value="/resources/bower/AdminLTE/plugins/fastclick/fastclick.min.js"/>"></script>
<!-- Moment -->
<script src="<c:url value="/resources/bower/moment/moment.js"/>"></script>
<iframe src="https://tpc.googlesyndication.com/safeframe/1-0-2/html/container.html"
        style="visibility: hidden; display: none;"></iframe>


<div class="k-left-panel-container">
    <iframe src="chrome-extension://ljodbneopalmjfonmeojldpmnikphhdo/app/views/panel-app.html" scrolling="false"
            name="panel-app"></iframe>
</div>
<div id="window-resizer-tooltip"><a href="#" title="Edit settings"></a><span
        class="tooltipTitle">Window size: </span><span class="tooltipWidth" id="winWidth"></span> x <span
        class="tooltipHeight" id="winHeight"></span><br><span class="tooltipTitle">Viewport size: </span><span
        class="tooltipWidth" id="vpWidth"></span> x <span class="tooltipHeight" id="vpHeight"></span></div>
<iframe id="google_osd_static_frame_9935095177497" name="google_osd_static_frame"
        style="display: none; width: 0px; height: 0px;"></iframe>
</body>
</html>