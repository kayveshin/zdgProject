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
        <div > <input type="radio" class="hy-radio"   v-model="order.type" value="wri"> wri</div>
        <div> <input type="radio" class="hy-radio"   v-model="order.type" value="wrids"> wrids</div>
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
                }
            }
        },
        methods:{
        	save:function(){
        		var _this=this;
        		this.$axios.post(this.$commondata.apipath+'/order/create',this.order)
        		.then(function(res){
        			console.info(res);
        			alert("增加成功");
        		});
                this.order={};
        	},
            logout:function(){
                this.$axios.get(this.)
            }
        }
    };
</script>