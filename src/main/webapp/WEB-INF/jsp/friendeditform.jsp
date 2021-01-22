<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  <html>
<head>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
        <h1>Edit friend</h1>  
       <form:form method="POST" action="editsave" modelAttribute="friend">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="id" /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"  /></td>  
          <td><form:errors path="name" cssClass="error" /></td>
         </tr>    
         <tr>    
          <td>email :</td>    
          <td><form:input path="email" /></td>  
         </tr>   
         <tr>    
          <td>phone :</td>    
          <td><form:input path="phone" /></td>  
          <td><form:errors path="phone" cssClass="error" /></td>
         </tr>   
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>  
       </body>
       </html>  