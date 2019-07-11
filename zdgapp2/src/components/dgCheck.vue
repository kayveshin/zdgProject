<template>
    <div>
<h1>登记其他信息</h1>
<form>
	<div>
	<h1>登记真实信息</h1>
		<div class="form-group">
			<label>realName</label>
			<input class="form-control" v-model="accout.realName"></input>
		</div>
		<div class="form-group">
			<label>CreditNum</label>
			<input class="form-control" v-model="accout.name"></input>
		</div>
		<input type="button" value="Register" class="btn btn-primary" @click="saveReal"></input>
	</div>
	<div>
		<h2>详细信息</h2>
		<div class="form-group">
		<label>password</label>
		<input class="form-control" v-model="accout.password"></input>
		</div>
		<input type="button" value="Register" class="btn btn-primary" @click="saveDetail"></input>
	</div>
	
	<div>
		<h2>付款认证</h2>
		<div class="form-group">
		
		<input type="button" value="Register" class="btn btn-primary" @click="savetarget"></input>
	</div>
</form>
</div>
</template>