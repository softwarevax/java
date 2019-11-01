<template>
  <div id="app">
		<router-view>
			<!--路由管道标签，任何符合某一路由(route)信息的组件都会在这个标签内展示出来 -->
		</router-view>
		<div class="tab">
			<div class="tab-item" @click="clickNav"><router-link :to="'/home'"><i class="el-icon-s-home"></i></router-link></div>
			<div class="tab-item" @click="clickNav"><router-link :to="'/about'"><i class="el-icon-document-copy"></i></router-link></div>
		</div>
  </div>
</template>

<script>
export default {
  name: 'app',
  data: function () {
		return {
			isSelected: true
		}
	},
	methods:{
		clickNav: function(event) {
			var items = $(".tab").children();
			/* $.each(items, function(i,item){     
				$(item).removeClass("menuSelected")
		   }); */
		   console.log(event.target)
		}
	}
}
</script>
<!-- css格式 -->
<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.tab {
	position: absolute;
	bottom: 0;
	left: 0;
	right: 0;
	display: flex;
  flex-direction: row;
	justify-content: center;
	height: 3rem;
	line-height: 3rem;
	text-align: center;
}
.tab-item {
	display: flex;
	flex: 1;
	justify-content: center;
	background-color: #8CC5FF;
}
a {
	display: inline-block;
	width: 100%;
	height: 100%;
	text-decoration: none;
	color: white;
	font-size: 1.3rem;
}

.menuSelected {
	color: #409EFF;
}
</style>