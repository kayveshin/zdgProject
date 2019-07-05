<template>
<h1>Register</h1>
<form>
	<div class="form-group">
		<label>name</label>
		<input class="form-control" v-model="accout.name"></input>
	</div>
	<div class="form-group">
		<label>password</label>
		<input class="form-control" v-model="accout.password"></input>
	</div>
	<div class="form-group">
		<label>role</label>
        <div > <input type="radio" class="hy-radio"   v-model="accout.role" value="user"> 用户</div>
        <div> <input type="radio" class="hy-radio"   v-model="accout.role" value="wireman"> 电工</div>
	</div>
	<div class="form-group">
		<label>tel</label>
		<input class="form-control" v-model="accout.tel"></input>
	</div>
	<input type="button" value="Register" class="btn btn-primary" @click="save"></input>
</form>
</template>
<script type="text/javascript">
	export default {
        data:{
        	account:{}
        }
        methods:{
        	save:function(){
        		var _this=this;
        		this.$axios.post(this.$commondata.apipath+'/user/register',account)
        		.then(function(res){
        			console.info(res);
        			alert("注册成功");
        		});
        		this.account={};
        	}
        }
    };
</script>