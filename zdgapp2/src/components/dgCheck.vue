<template>
    <div>
<h1>登记其他信息</h1>
<form>
	<div v-if="useReal">
	<h1>登记真实信息</h1>
		<div class="form-group">
			<label>realName</label>
			<input class="form-control" v-model="accout.realName"></input>
		</div>
		<div class="form-group">
			<label>CreditNum</label>
			<input class="form-control" v-model="accout.name"></input>
		</div>
		<input type="button" value="Register" class="btn btn-primary" @click="saveReal()"></input>
	</div>
	<div v-if="useDetail">
		<h2>详细信息</h2>
		<div class="form-group">
		<label>password</label>
		<input class="form-control" v-model="accout.password"></input>
		</div>
		<input type="button" value="Register" class="btn btn-primary" @click="saveDetail()"></input>
	</div>
	
	<div>
		<h2>延长认证</h2>
		
		<input type="button" value="Register" class="btn btn-primary" @click="savetarget()"></input>
	</div>
</form>
</div>
</template>
<script type="text/javascript">
	export default{
		data(){
			return{
				accout:{},
				useReal:false,
				useDetail:false,
			}
		},
		methods:{
			refresh:function(){
				var _this=this;
				this.$axios.get(this.$commonapi.apiPath+this.$commonapi.getSelfPath)
				.then(function(res){
					console.info(res);
					_this.accout=res.data;
					if(data.realName==null){
						_this.useReal=true;
					}else{
						_this.useReal=false;
					}
				})
			},
			saveReal:function(){
				var _this=this;
				this.$axios.post(this.$commonapi.apiPath+this.$commonapi.enterRealPath,this.accout)
				.then(function(res){
					console.info(res);
				})
			},
			saveDetail:function(){
				var _this=this;
				this.$axios.post(this.$commonapi.apiPath+this.$commonapi.enterDetailPath,this.accout)
				.then(function(res){
					console.info(res);
				})
			},
			savetarget:function(){
				var _this=this;
				this.$axios.get(this.$commonapi.apiPath+this.$commonapi.enterAvailPath)
				.then(function(res){
					console.info(res);
				})
			}
		}
	}
</script>