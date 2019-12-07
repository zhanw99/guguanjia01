new Vue({
    el:'#page-content',
    data:{
        icon:'',
    },
    methods:{
        toSelect:function () {
            let index= layer.open({
                type: 2,
                area: ['80%', '60%'],
                fixed: false, //不固定
                content: 'html/area/font-awesome.html',
                end:()=>{
                    this.icon=layer.icon;
                }
            });
        }
    },
    created:function () {
        //在vue对象创建后   获取layer父窗口传递的对象数据
        this.appVersion=parent.layer.appVersion;
    }
})