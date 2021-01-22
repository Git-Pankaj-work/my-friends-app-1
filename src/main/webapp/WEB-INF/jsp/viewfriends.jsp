<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>friends List</h1>

<a href="add_new_friend_form_1">Add New friends</a> | <a href="add_new_friend_form_2">Add New friends</a>
<br /><br /><br />
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>email</th>
		<th>phone</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="friend" items="${list}">
		<tr>
			<td>${friend.id}</td>
			<td>${friend.name}</td>
			<td>${friend.email}</td>
			<td>${friend.phone}</td>
			 <td><a href="editfriend/${friend.id}">Edit</a></td>  
   			<td><a href="deletefriend/${friend.id}">Delete</a></td>  
		</tr>
	</c:forEach>
</table>
