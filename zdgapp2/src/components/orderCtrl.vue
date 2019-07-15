<template>
	<div>
		<button class="btn btn-info" @click="logout">logout</button>

		<h1>查看订单</h1>
		<button class="btn btn-info" @click="add">AddOrder</button>
<table class="table">
	<thead>
		<tr>
			<th>need</th>
			<th>opentime</th>
			<th>orderstate</th>
		</tr>
	</thead>
		<tbody>
			<tr v-for="order in orderList">
				<td>{{order.need}}</td>
				<td>{{order.opentime}}</td>
				<td>{{order.orderstate}}</td>
				<td v-if="(order.orderstate=='unaccept')"><button class="btn btn-danger" @click="cancel(order.id)">Remove</button></td>
				<td v-if="(order.orderstate=='unaccept')"><button class="btn btn-info" @click="applyView(order.id)">Edit</button></td>
				<td v-if="(order.orderstate=='unremark')"><button class="btn btn-info" @click="remark(order.dgId)">Edit</button></td>
				<td v-if="(order.orderstate=='accepted')"><button class="btn btn-info" @click="over(order._id)">Edit</button></td>
			</tr>
		</tbody>
	
</table>
	</div>
</template>
<script type="text/javascript">
	export default{
		data(){
			return{
				orderList:[]
			}
		},
		methods:{
			refresh:function(){
				var _this=this;
				_this.$axios.get(this.$commonapi.apiPath+this.$commonapi.DemandOrderListPath)
				.then(function(res){
					console.info(res);
					_this.orderList=res.data;
				})
			},
			cancel:function(id){
				var _this=this;
				this.$axios.get(this.$commonapi.apiPath+this.$commonapi.orderCancelPath)
				.then(function(res){
					console.info(res);
					_this.refresh();
				})
			},
			applyView:function(id){
				this.$router.push('/applyCtrl/'+id);
			},
			over:function(id){
				var _this=this;
				this.$axios.get(this.$commonapi.apiPath+this.$commonapi.overOrderPath)
				.then(function(res){
					console.info(res);
					_this.refresh();
				})
			},
			remark:function(id){
				var remarkTable={
					comment:null,
					score:null,
				};
				remarkTable.dgId=id;
				remarkTable.comment=prompt("请输入评价");
				remarkTable.score=prompt("请打分");
				if(remarkTable.comment!=null&&remarkTable.score!=null){
					var _this=this;
					this.$axios.post(this.$commonapi,apiPath+this.$commonapi.remarkDgPath)
					.then(function(res){
						console.info(res);
						_this.refresh();
					})
				}else{
					alart("不能为空");
				}
			},
			logout:function(){
                this.$commonfun.logout();
            },
            add:function(){
            	this.$router.push('/openOrder')
            }
		},
		mounted(){
			this.refresh();
		}
	}

</script>