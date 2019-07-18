export default{
	commonapi:this.$commonapi
	logout:function(){
		var _this=this;
		this.$axios.get(this.$commonapi.apiPath+this.$commonapi.logoutPath).then(function(res){
			console.info(res);
			_this.$router.push('/');
		})
	}
}
	