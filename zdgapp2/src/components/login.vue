<template>
    <div>
<h1>Login</h1>
<form>
	<div class="form-group">
		<label>name</label>
		<input class="form-control" v-model="accout.username"></input>
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
                }
            }
        },
        methods:{
        	save:function(){
        		var _this=this;
        		this.$axios.post(this.$commonapi.apiPath+this.$commonapi.loginPath,_this.accout)
        		.then(function(res){
                    //这里改成返回ok码
                    _this.refresh();
        		});
        		
        	},
            moveRegister:function(){
                this.$router.push('/register');
            },
            refresh:function(){
                 var _this=this;
                _this.accout={};
                
                console.info(this.$commonapi.apiPath+this.$commonapi.sessionLoginPath);
                
                this.$axios.get(this.$commonapi.apiPath+this.$commonapi.sessionLoginPath).then(function(res){
                    if(res.data.role=='user'){
                        _this.$router.push('/orderCtrl');
                    }else if(res.data.role=='wireman'){
                        _this.$router.push('/unacceptedOrder');
                    }
                });
            

            }
        },
        mounted(){
            this.refresh();
        }
            
            
    };
</script>