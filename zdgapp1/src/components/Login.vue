<template>
<h1>Login</h1>
<form>
	<div class="form-group">
		<label>name</label>
		<input class="form-control" v-model="accout.name"></input>
	</div>
	<div class="form-group">
		<label>password</label>
		<input class="form-control" v-model="accout.password"></input>
	</div>
	<input type="button" value="Login" class="btn btn-primary" @click="save"></input>
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
        		this.$axios.post(this.$commondata.apipath+'/user/login',account)
        		.then(function(res){
        			if(res.role=='user'){
        				_this.$router.push('/openOrder');
        			}else(res.role=='wireman'){
        				_this.$router.push('/unaccept');
        			}
        		});
        		this.account={};
        	}

        }
    };
</script>