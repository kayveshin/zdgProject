<template>
	<div>
		<h1>可接受的订单</h1>
<table class="table">
	<thead>
		<tr>
			<th>need</th>
			<th>opentime</th>
		</tr>
	</thead>
		<tbody>
			<tr v-for="order in orderList">
				<td>{{order.need}}</td>
				<td>{{order.opentime}}</td>
				<td><button class="btn btn-danger" @click="remove(user._id)">Remove</button></td>
				<td><button class="btn btn-info" @click="edit(user._id)">Edit</button></td>
			</tr>
		</tbody>
	
</table>
	</div>
</template>
