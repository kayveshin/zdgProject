<template>
	<div>
		<button class="btn btn-info" @click="logout()">注销</button>
	<h1>查看已接受的订单：</h1>
	<button class="btn btn-info" @click="naviAccept(order.id)">已接受的订单</button>
		<h1>可接受的订单：</h1>
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
				<td><button class="btn btn-danger" @click="apply(order.id)">Apply</button></td>
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
				this.$axios.get(this.$commonapi.apiPath+this.$commonapi.getUnacceptPath)
				.then(function(res){
					console.info(res);
					_this.orderList=res.data;
				})
			},
			apply:function(id){
				var _this=this;
				var apply={};
				apply.orderId=id;
				apply.price=prompt("请输入报价");
				if(apply.price!=null){
					this.$axios.get(this.$commonapi.apiPath+this.$commonapi.createApplyPath)
					.then(function(res){
						console.info(res);
						_this.refresh();
					})
				}else{
					alert("报价不能为空");
				}
			},
			naviAccept:function(){
				this.$router.push('/acceptedOrder');
			},
			logout:this.$commonfun.logout()
			
		},
		mounted(){
			this.refresh();
		}
	}
</script>