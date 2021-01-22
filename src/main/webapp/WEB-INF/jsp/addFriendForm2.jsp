<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1>Add New Friend</h1>
<form:form method="post" action="save_my_friend_2" modelAttribute="friend">
	<table>
		<tr>
			<td>Name :</td>
			<td><form:input path="name"/></td>
			<td><form:errors path="name"/></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><form:input path="email" /></td>
			<td><form:errors path="email"/></td>
		</tr>
		<tr>
			<td>Phone :</td>
			<td><form:input path="phone" /></td>
			<td><form:errors path="phone"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Save" /></td>
		</tr>
	</table>
</form:form>
