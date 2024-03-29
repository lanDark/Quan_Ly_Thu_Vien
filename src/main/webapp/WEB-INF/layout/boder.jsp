<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" %>
<!-- Start BEst Seller Area -->
                
		<section class="wn__product__area brown--color pt--80  pb--30">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="section__title text-center">
							<h2 class="title__be--2">New <span class="color--theme">Products</span></h2>
							<p>Bộ sách mới nhất dành cho bạn đọc :D </p>
						</div>
					</div>
				</div>
				<!-- Start Single Tab Content -->
				<div class="furniture--4 border--round arrows_style owl-carousel owl-theme row mt--50">
					<!-- Start Single Product -->
                                    <c:forEach var="newProduct" items="${productNews}">
                                        <c:forEach var="hinhAnhs" begin="0" end="1"  items="${newProduct.hinhAnhs}">
                                                <c:if test="${not empty srcHinhAnh1}">
                                                     <c:set var="srcHinhAnh2" value="Resource/images/books/${hinhAnhs.src}"/>
                                                </c:if>
                                                <c:if test="${ empty srcHinhAnh1}">
                                                     <c:set var="srcHinhAnh1" value="Resource/images/books/${hinhAnhs.src}"/>
                                                </c:if>
                                            </c:forEach>
                                        <c:forEach var="tacGia" begin="0" end="0" items="${newProduct.tacgias}">
                                                  <c:set var="tacGiaHoTen" value="${tacGia.hoTen}"/>
                                        </c:forEach>
					<div class="product product__style--3">
						<div class="col-lg-3 col-md-4 col-sm-6 col-12">
							<div class="product__thumb">
                                                            <a class="first__img" href=""><img src='<c:url value="${srcHinhAnh1}"/>' alt="product image"></a>
                                                                <a class="second__img animation1" href="singe-product.html"><img src='<c:url value= "${srcHinhAnh2}"/>' alt="product image" ></a>
								<div class="hot__box">
									<span class="hot-label">NEW BOOK</span>
								</div>
							</div>
							<div class="product__content content--center">
                                                            <h4><a href="<c:url value="/product/${newProduct.url}"/>"><c:out value="${newProduct.tenSach}"/></a></h4>
								<ul class="prize d-flex">
									<li>Tác giả: </li>
									<li class="old_prize">${tacGiaHoTen}</li>
								</ul>
								<div class="action">
									<div class="actions_inner">
										<ul class="add_to_links">
                                                                                    <li><a class="cart addToCart" tenSach="${newProduct.tenSach}" tacGia="${tacGiaHoTen}" url="<c:out value="${pageContext.request.contextPath}/${srcHinhAnh1}"/>" > 
                                                                                            <p hidden>${newProduct.maSach}</p>
                                                                                            <i class="bi bi-shopping-bag4"></i></a>
                                                                                    </li>
											<li><a class="wishlist" href="wishlist.html"><i class="bi bi-shopping-cart-full"></i></a></li>
                                                                                        <li class=""><a data-toggle="modal" title="Quick View" class="showProductModal quickview modal-view detail-link " data-target="#productmodal"><p hidden>${newProduct.maSach}</p><i class="bi bi-search"></i></a></li>
										</ul>
									</div>
								</div>
								<div class="product__hover--content">
									<ul class="rating d-flex">
										<li class="on"><i class="fa fa-star-o"></i></li>
										<li class="on"><i class="fa fa-star-o"></i></li>
										<li class="on"><i class="fa fa-star-o"></i></li>
										<li><i class="fa fa-star-o"></i></li>
										<li><i class="fa fa-star-o"></i></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<!-- Start Single Product -->
                                         <c:remove var = "srcHinhAnh1"/>
                                         <c:remove var = "srcHinhAnh2"/>
                                    </c:forEach>                        
					<!-- Start Single Product -->
					
					
				</div>
				<!-- End Single Tab Content -->
			</div>
		</section>
		<!-- Start BEst Seller Area -->
		<!-- Start NEwsletter Area -->
		<section class="wn__newsletter__area bg-image--2">
			<div class="container">
				<div class="row">
					<div class="col-lg-7 offset-lg-5 col-md-12 col-12 ptb--150">
						<div class="section__title text-center">
							<h2>Stay With Us</h2>
						</div>
						<div class="newsletter__block text-center">
							<p>Subscribe to our newsletters now and stay up-to-date with new collections, the latest lookbooks and exclusive offers.</p>
							<form action="#">
								<div class="newsletter__box">
									<input type="email" placeholder="Enter your e-mail">
									<button>Subscribe</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- End NEwsletter Area -->
  <!-- Modal -->
  <div class="modal fade" id="alertAddToCart" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title">Thông báo</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
        
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
