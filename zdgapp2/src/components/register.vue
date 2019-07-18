<template>
    <div>
<h1>Register</h1>
<form>
	<div class="form-group">
		<label>name</label>
		<input class="form-control" v-model="accout.username"></input>
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
</div>
</template>
<script type="text/javascript">
	export default {
        data(){
            return {
        	   accout:{}
            }
        },
        methods:{
        	save:function(){
        		var _this=this;
                this.$axios.get(this.$commonapi.apiPath+this.$commonapi.publicKeyPath)
                .then(function(res){
                    _this.$axios.post(_this.$commonapi.apiPath+_this.$commonapi.registerPath,_this.accout)
                .then(function(res){
                    console.info(res);
                    alert("注册成功");
                    _this.accout={};
                    _this.$router.push('/');
                });
                })
        		
        		
        	},

        }
    };
</script>