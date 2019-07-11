<template>
	<div>
		<h1>查看申请</h1>
<table class="table">
	<thead>
		<tr>
			<th>price</th>
			<th>Action</th>
		</tr>
	</thead>
		<tbody>
			<tr v-for="apply in applyList">
				<td>{{apply.dgPrice}}</td>
				<td><button class="btn btn-info" @click="showDetail(apply.dgId)">ShowDg</button></td>
				<td><button class="btn btn-info" @click="accept(apply)">Accept</button></td>
			</tr>
		</tbody>
	
</table>
<dir v-if="showDgDeatil">
	<p>name:dgInfo.name</p>
	<p>tel:dgInfo.tel</p>
</dir>
	</div>
</template>
<script type="text/javascript">
	export default{
		data(){
			return{
				applyList:[],
				showDgDeatil,
				dgInfo:null,
				showDgDeatil:false
			}
		},
		methods:{
			refresh:function(){
				var _this=this;
				showDgDeatil=false;
				this.$axios.get(this.$commonapi.apiPath+this.$commonapi.ApplyByOrderPath,{
					params:{
						orderId:_this.$route.params.id
					}
				}).then(function(res){
					console.info(res);
					_this.applyList=res.data;
				})
			},
			showDetail:function(dgId){
				var _this=this;
				showDgDeatil=true;
				this.$axios.get(this.$commonapi.apiPath+this.$commonapi.DgInfoPath,{
					params:{
						id:dgId
					}
				}).then(function(res){
					console.info(res);
					this.dgInfo==res.data;
				})
			},
			accept:function(apply){
				var _this=this;
				this.$axios.post(this.$commonapi.apiPath+this.$commonapi.AcceptApplyPath,apply)
				.then(function(res){
					console.info(res);
					_this.$router.push('/orderCtrl');
				})
			}
		},
		mounted(){
			this.refresh();
		}
	}
</script>