<template>
<h1>未被接受的订单</h1>
<table class="table">
	<thead>
		<tr>
			<th>opentime</th>
			<th>orderType</th>
			<th>need</th>
			<th>Action</th>
		</tr>
	</thead>
		<tbody>
			<tr v-for="order in orderList">
				<td>{{order.opentime}}</td>
				<td>{{order.orderType}}</td>
				<td>{{order.need}}</td>
				<td><button class="btn btn-info" @click="showUser(order.userId)">showUser</button></td>
				<td><button class="btn btn-info" @click="accept(order)">accept</button></td>
			</tr>
		</tbody>
	
</table>
</template>
<script type="text/javascript">
	export default {
        data:{
        	orderList:[]
        }
        methods:{
        	showUser:function(id){
        		var _this=this;
        		this.$axios.get(this.$commondata.apipath+'/user/user',{
        			params: {
     					 ID: id
  					}
        		})
        		.then(function(res){
        			console.info(res);
        			_this.res.id=null;
        			alert("用户信息"+res);
        		});
        	},
        	accept:function(order){
        		var _this=this;
        		order.id
        	}
        }
        mounted(){
        	var _this=this;
        	this.$axios.get(this.$commondata.apipath+'/order/status/',{
        		params: {
     					 status: 'unaccept'
  					}
        	}).then(function(res){
        		console.info(res);
        		_this.orderList=res;
        	})
        }
    };
</script>