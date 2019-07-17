export default{
	logout:function(){
		var _this=this;
		console.info(this.$commonapi);
		this.$axios.get(this.$commonapi.apiPath+this.$commonapi.logoutPath).then(function(res){
			console.info(res);
			_this.$router.push('/');
		})
	}
}
	