new Vue({
    el:'#page-content',
    methods:{
        selectAll:function () {
            axios({
                url:'manager/qualification/index/index',
                pageInfo: {
                    pageNum: 1,//默认值
                    pageSize: 5
                }
            }).then(response=>{
                console.log(response)

            }).catch(function (error) {
                console.log(error)
            })
        },
        update1:function (id) {
            axios({
                url:'manager/qualification/index/update1',
                params: {
                    id: id
                }
            }).then(response=>{
                console.log('关闭当前窗口....');
                let index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.layer.close(index); //再执行关闭
            }).catch(function (error) {
                console.log(error)
            })
        },
        update2:function (id) {
            axios({
                url:'manager/qualification/index/update2',
                params: {
                    id: id
                }
            }).then(response=>{
                console.log('关闭当前窗口....');
                let index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.layer.close(index); //再执行关闭
            }).catch(function (error) {
                console.log(error)
            })
        }
    },
    created:function () {
        //在vue对象创建后   获取layer父窗口传递的对象数据
        this.appVersion=parent.layer.appVersion;
    }
})