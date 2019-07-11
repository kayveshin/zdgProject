<template>
	<div>
		<h1>查看订单</h1>
<table class="table">
	<thead>
		<tr>
			<th>opentime</th>
			<th>orderType</th>
			<th>username</th>
			<th>usertel</th>
		</tr>
	</thead>
		<tbody>
			<tr ng-repeat="user in users">
				<td>{{user.name}}</td>
				<td>{{user.password}}</td>
				<td>{{user.detail}}</td>
				<td><button class="btn btn-danger" ng-click="remove(user._id)">Remove</button></td>
				<td><button class="btn btn-info" ng-click="edit(user._id)">Edit</button></td>
			</tr>
		</tbody>
	
</table>
	</div>
</template>