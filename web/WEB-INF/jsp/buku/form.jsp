<%-- 
    Document   : form
    Created on : Jul 16, 2019, 8:21:47 AM
    Author     : utama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
<!DOCTYPE html>
<%@include  file="/constructed/header.jsp" %>
<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
    <div class="message-box">
        <h2>${flag} Data Buku</h2>
        <h5>WE ARE THE LEADERS IN THE CONSTRUCTION INDUSTRY!</h5>
    </div>
    <!-- end messagebox -->
</div>
<!-- end col -->
<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
    <fm:form modelAttribute="buku" method="post">
        <fm:hidden path="idBuku" />
        <table border="0">
            <tbody>
                <tr>
                    <td>ISBN:</td>
                    <td><fm:input path="isbn" size="20"/></td>
                </tr>
                <tr>
                    <td>Judul:</td>
                    <td><fm:input path="judul" size="30"/></td>
                </tr>
                <tr>
                    <td>Tahun Terbit:</td>
                    <td><fm:input path="tahun" size="5"/></td>
                </tr>
                <tr>
                    <td>Pengarang:</td>
                    <td><fm:input path="pengarang" size="30"/></td>
                </tr>
                <tr>
                    <td>Penerbit:</td>
                    <td><fm:input path="penerbit" size="30"/></td>
                </tr>
                <tr>
                    <td>Jumlah Salinan:</td>
                    <td><fm:input path="jumlahSalinan" size="5"/></td>
                </tr>
                <tr>
                    <td>Ringkasan:</td>
                    <td><fm:textarea path="ringkasan" rows="4" cols="30"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="${flag}" name="btn_simpan" /></td>
                    <td><a href="<%=request.getContextPath()%>/buku.htm"><input type="button" value="Batal" name="btn_batal" /></a></td>
                </tr>
            </tbody>
        </table>
    </fm:form>
    <!-- end messagebox -->
</div>

<%@include  file="/constructed/footer.jsp" %>