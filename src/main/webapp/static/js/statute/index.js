new Vue({
    el:"#app",
    data:{
        msg:'<h2><img src="http://img.baidu.com/hi/jx2/j_0003.gif" />Vue + UEditor + v_model双向绑定</h2>',
        myconfig:{
            // 为编辑器示例添加一个路径，该路径需要定位到ueditor下 base+"static/js/ueditor/"
            UEDITOR_HOME_URL:"static/ueditor/",

            //服务器统一请求接口路径
            serverUrl:"ueditor/execute"
        }
    },
    methods:{

    },
    components:{//组件配置，用于设置vue对象使用的组件
      VueUeditorWrap  //引用vue和ueditor
    },
    updated:function () {
        console.log(this.msg);
    }
})