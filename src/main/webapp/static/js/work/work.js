new Vue({
    el:'#page-content',
    data:{
        version:'',
    },
    methods:{

    },
    created:function (){
        //在vue对象创建后   获取layer父窗口传递的对象数据
        this.version=parent.layer.appVersion;
        console.log(this.version)
    }

})