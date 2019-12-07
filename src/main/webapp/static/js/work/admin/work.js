new Vue({
    el:'#page-content',
    data:{
        params:{
            pageNum:'',
            pageSize:''
        },
        id:{

        }
    },
    methods:{
        selectAll:function (pageNum,pageSize) {
         axios({
             url:'manager/admin/work/work',
             params: {
                pageNum:pageNum,
                pageSize:pageSize,
             }
         }).then(response=>{
             this.params= response.data
             console.log(this.params)
         }).catch(function (error) {
             console.log(error)
         })
        },
        toUpdate: function (id,p) {
            axios({
                url: 'manager/admin/work/selectId',
                method:"post",
                params:{
                    id:id,
                }
            }).then(response => {
                layer.appVersion = p;//返回数据，绑定到layer上，传递给子窗口
                console.log(response.data)
                layer.open({
                    type: 2,
                    title: '查看用户状态',
                    area: ['700px', '450px'],
                    fixed: false, //不固定
                    maxmin: true,//开启最大化最小化按钮
                    content: 'html/work/work-detail.html',
                    end: () => {//将then函数中的this传递到end的回调函数中
                        //刷新页面数据    1.直接查询selectAll实现    2.获取layer.appVersion更新当前pageInfo的该数据
                    }
                });
            }).catch(function (error) {
                console.log(error)
            })
        }

    },
    created:function () {
        this.selectAll()
    }
})