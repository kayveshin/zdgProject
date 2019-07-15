<template>
	<div>
		<h1>已经接受的订单</h1>
<table class="table">
	<thead>
		<tr>
			<th>need</th>
			<th>opentime</th>
			<th>orderStatus</th>
		</tr>
	</thead>
		<tbody>
			<tr v-for="order in orderList">
				<td>{{order.need}}</td>
				<td>{{order.opentime}}</td>
				<td>{{order.orderStatus}}</td>
				<td><button class="btn btn-danger" @click="detail(order)">detail</button></td>
			</tr>
		</tbody>
	
</table>
	</div>
</template>
<script type="text/javascript">
	export default{
		data(){
			return {
				orderList:[]
			}
		},
		methods:{
			refresh:function(){
				var _this=this;
				this.$axios.get(this.$commonapi.apiPath+this.$commonapi.getAccepOrderPath)
				.then(function(res){
					console.info(res);
					_this.orderList=res.data;
				})
			},
			detail:function(order){
				alert(JSON.parse(order));
			}
		},
		mounted(){
			this.refresh();
		}
	}
</script>