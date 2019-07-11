<template>
    <div>
    <button class="btn btn-info" @click="logout">logout</button>
	<h1>发起订单</h1>
<form>
	<div class="form-group">
		<label>need</label>
		<input class="form-control" v-model="order.need"></input>
	</div>
	<div class="form-group">
		<label>type</label>
        <div v-for="type in typeList"> <input type="radio" class="hy-radio"   v-model="order.typeid" value="type.id"> {{type.name}}</div>
	</div>
    <div class="form-group">
        <label>tel</label>
        <input class="form-control" v-model="order.need"></input>
    </div>
    <div class="form-group">
        <label>Streetaddress</label>
        <input class="form-control" v-model="order.needStreetAddress"></input>
    </div>
    <div class="form-group">
        <label>Homeaddress</label>
        <input class="form-control" v-model="order.needHomeAddress"></input>
    </div>
	<input type="button" value="Register" class="btn btn-primary" @click="save"></input>
</form>
</div>

</template>

<script type="text/javascript">
	export default {
        data(){
            return {
        	   order:{
                  type:null,
                  need:null,
                  userId:null
                }
            }
        },
        methods:{
        	save:function(){
        		var _this=this;
                this.order.userId=this.$cookies.get('user_id');
        		this.$axios.post(this.$commonapi.apipath+this.$commonapi.openOrderPath,this.order)
        		.then(function(res){
        			console.info(res);
        			alert("增加成功");
        		});
                this.order={};
        	},
            logout:function(){
                this.$cookies.remove("user_id");
                this.$router.push('/');
            }
        }
    };
</script>