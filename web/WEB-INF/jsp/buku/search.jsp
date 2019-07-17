<%-- 
    Document   : search
    Created on : Jul 16, 2019, 8:21:58 AM
    Author     : utama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<%@include  file="/constructed/header.jsp" %>
<!DOCTYPE html>
<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
    <div class="message-box">
        <h2>Pencarian Data Buku</h2>
        <fm:form modelAttribute="buku" method="post">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Judul:</td>
                        <td><fm:input path="judul" size="30"/></td>
                        <td><input type="submit" value="Cari" /></td>
                    </tr>
                    <tr>
                        <td>Pengarang</td>
                        <td><fm:input path="pengarang" size="30"/></td>
                        <td><a href="<%=request.getContextPath()%>/buku/add.htm"><input type="button" value="Tambah" /></a></td>
                    </tr>
                </tbody>
            </table>
        </fm:form>
    </div>
    <!-- end messagebox -->
</div>
<!-- end col -->
<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">

    <table border="1">
        <thead>
            <tr>
                <th>No.</th>
                <th>Judul</th>
                <th>Pengarang</th>
                <th>Penerbit</th>
                <th>Aksi</th>
            </tr>
        </thead>
        <tbody>
            <c:set var="i" value="0"/>
            <c:forEach var="b" items="${bks}">
                <c:set var="i" value="${i+1}"/>
                <tr>
                    <td><c:out value="${i}"/></td>
                    <td><c:out value="${b.judul}"/></td>
                    <td><c:out value="${b.pengarang}"/></td>                       
                    <td><c:out value="${b.penerbit}"/></td>                       
                    <td>
                        <a href="buku/edit_<c:out value="${b.idBuku}"/>.htm">edit</a>&nbsp;                            
                        <a href="buku/delete_<c:out value="${b.idBuku}"/>.htm">hapus</a>                            
                    </td>                       
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p>${keterangan}</p>
    <p>${message}</p>

</div>

<%@include  file="/constructed/footer.jsp" %>
