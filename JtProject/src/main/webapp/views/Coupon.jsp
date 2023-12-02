<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="your.package.name.CouponGenerator" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Coupon List</title>
</head>
<body>

<%
    // Generate coupon codes with various discounts
    List<String> couponList = CouponGenerator.generateCouponCodes(10);
%>
<h2>List of Coupons:</h2>
<ul>
    <%
        for (String coupon : couponList) {
    %>
        <li><%= coupon %></li>
    <%
        }
    %>
</ul>

</body>
</html>
