<template>
    <div>
    <button class="btn btn-info" @click="logout">logout</button>
<h1>未被接受的订单</h1>
<table class="table">
	<thead>
		<tr>
			<th>opentime</th>
			<th>orderType</th>
			<th>need</th>
			<th>Action</th>
		</tr>
	</thead>
		<tbody>
			<tr v-for="order in orderList">
				<td>{{order.opentime}}</td>
				<td>{{order.orderType}}</td>
				<td>{{order.need}}</td>
				<td><button class="btn btn-info" @click="showUser(order.userId)">showUser</button></td>
				<td><button class="btn btn-info" @click="accept(order)">accept</button></td>
			</tr>
		</tbody>
	
</table>
</div>
</template>
<script type="text/javascript">
	export default {
        inject:['reload'],
        data(){
            return{
        	orderList:[]
             }
         },
        methods:{
        	showUser:function(id){
        		var _this=this;
        		this.$axios.get(this.$commondata.apipath+'/user/user',{
        			params: {
     					 id: id
  					}
        		})
        		.then(function(res){
        			console.info(res);
        			alert("用户信息"+res);
        		});
        	},
        	accept:function(order){
        		var _this=this;
        		order.orderStatus='accept';
                order.dgId=this.$cookies.get("user_id");
                order.dgPrice=prompt("请输入报价");

                this.$axios.post(this.$commondata.apipath+'/order/update',order)
                .then(function(res){
                    console.info(res);
                    this.reload();
                })
        	},
            logout:function(){
                this.$cookies.remove("user_id");
                this.$router.push('/');
            },
            checkCookies:function(){
                var _this=this;
            this.$axios.get(this.$commondata.apipath+'/order/status/',{
                params: {
                         status: 'unaccept'
                    }
            }).then(function(res){
                console.info(res);
                _this.orderList=res.data;
            })
            }
        },
        mounted(){
        	this.checkCookies();
        }
    };
</script>