<template>
    <div>
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
<p>没有账号？</p>
<button class="btn btn-info" @click="moveRegister">Register</button>
</div>
</template>
<script type="text/javascript">

	export default {
        data(){
            return {
                accout:{
                    name:null,
                    password:null
                }
            }
        },
        inject:['reload'],
        methods:{
        	save:function(){
        		var _this=this;
        		this.$axios.post(this.$commondata.apipath+'/user/login',{name:_this.accout.name,password:_this.accout.password})
        		.then(function(res){
                    console.info(res);
                    _this.$cookies.set("user_id",res.data.id);
                    _this.accout={};
                    _this.reload();
        		});
        		
        	},
            moveRegister:function(){
                this.$router.push('/register');
            }
        },
        mounted(){
            var _this=this;

            console.info(_this.$commondata.apipath);
            if(this.$cookies.isKey("user_id")){
                var _id=this.$cookies.get("user_id");
                this.$axios.get(this.$commondata.apipath+'/user/user',{
                    params: {
                         id: _id
                    }
                }).then(function(res){
                    if(res.data.role=='user'){
                        _this.$router.push('/openOrder');
                    }else if(res.data.role=='wireman'){
                        _this.$router.push('/unaccept');
                    }
                });
            }
        }
            
            
    };
</script>