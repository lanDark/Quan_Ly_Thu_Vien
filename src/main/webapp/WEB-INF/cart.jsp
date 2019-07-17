<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="layout/header.jsp"/>
<jsp:include page="layout/search.jsp"/>
<jsp:include page="layout/slide.jsp"/>  
<div class="cart-main-area section-padding--lg bg--white">
            <div class="container">
                
                <div class="row">
                    <div class="col-md-12 col-sm-12 ol-lg-12">
                        <form action="#">               
                            <div class="table-content wnro__table table-responsive">
                                <table>
                                    <thead>
                                        <tr class="title-top">
                                            <th class="product-thumbnail">ẢNH</th>
                                            <th class="product-name">TÊN SÁCH</th>
                                            <th class="product-quantity">SỐ LƯỢNG</th>
                                            <th class="product-remove">XÓA</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="items" items="${cartList}">
                                            <c:forEach var="hinhAnhs" begin="0" end="0"  items="${items.hinhAnhs}">
                                                     <c:set var="srcHinhAnh" value="${hinhAnhs.src}"/>
                                            </c:forEach>
                                        <tr>
                                            <td class="product-thumbnail"><a href="#"><img src="<c:url value="Resource/images/books/${srcHinhAnh}"/> " alt="product img"></a></td>
                                            <td class="product-name"><a href="#">${items.tenSach}</a></td>
                                            <td class="product-quantity"><input type="number" value="1"></td>
                                            <td class="product-remove"><a href="#">X</a></td>
                                        </tr>
                                        </c:forEach>     
                                </table>
                            </div>
                        </form> 
                        <div class="cartbox__btn">
                            <ul class="cart__btn__list d-flex flex-wrap flex-md-nowrap flex-lg-nowrap justify-content-between">
                                <div class="col-md-9"></div>
                                <li><a href="#">Đặt giữ</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-6 offset-lg-6">
                        <div class="cartbox__total__area">
                            <div class="cartbox-total d-flex justify-content-between">
                                <ul class="cart__total__list">
                                    <li>Tổng số lượng</li>
                                </ul>
                                <ul class="cart__total__tk">
                                    <li>$70</li>
                                </ul>
                            </div>
              
                        </div>
                    </div>
                </div>
                            
            </div>  
        </div>
<jsp:include page="layout/footer.jsp"/>