<template>
  <div id="app">
		<!-- <router-view>
		</router-view> -->
		<Footer></Footer>
  </div>
</template>

<script>

import Footer from "@/components/footer/Footer.vue"

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
		   console.log(event.target)
		}
	},
	components: {
		Footer
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