export default{
	logout:function(){
		this.$axios.get(this.$commonapi.apiPath+this.$commonapi.logoutPath)
		.then(res){
			console.info(res);
			return 1;
		}
	}
}