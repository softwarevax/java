<template>
  <div id="footer" >
    <div v-for="item in menus">
      <router-link :to="item.href"><i v-bind:class="item.iconfont"></i>okoko</router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Footer',
  data() {
    return {
      menus: [{
        label: "主页",
        href: "/home",
        iconfont: "el-icon-s-home"
      },{
        label: "设置",
        href: "/settings",
        iconfont: "el-icon-document-copy"
      }]
    }
  }
}
</script>
<style>
#about {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>