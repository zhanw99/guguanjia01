let le = new Vue({
    el:"#main-container",
    data:{
        pageInfo:{
            pageNum:1,//默认值
            pageSize:5
        },
        version:''

    },methods:{
         selectAll:function (pageNum, pageSize) {
            //查询后台，返回分页数据，更新vue的pageInfo对象
             let index=axios({
                url:'manager/app/index/index',
                params:{
                    pageNum:pageNum,
                    pageSize:pageSize,
                }
            }).then(response=>{
                console.log(response.data),
                this.pageInfo=response.data
            }).catch(function (error) {
                console.log(error)
            })
        },
        doDelete:function (id) {
            layer.confirm('确定删除？', {
                btn: ['确定','取消'], //按钮
                yes:index=>{
                        axios({
                            url:"manager/app/index/doDelete",
                            params: {
                                id:index
                            }
                        }).then(response=>{
                            let red= response.data;
                            console.log(red);
                            if (red>=1){
                                layer.msg('已删除', {icon: 1})
                                this.selectAll(this.pageInfo.pageNum,this.pageInfo.pageSize);
                            }
                        }).catch(function (error) {
                             console.log(error);
                        })

                }
            })

        },
        toUpdate:function (id) {
            axios({
                url:'manager/app/index/toUpdate',
                params:{
                    id:id,
                }
            }).then(response=>{
                layer.appVersion= response.data;;//返回数据，绑定到layer上，传递给子窗口
                console.log(layer.appVersion)
                let index=layer.open({
                    type: 2,
                    title: '修改。',
                    content: 'html/app/update.html',
                    // maxmin: true, //开启最大化最小化按钮
                    area: ['893px', '600px'],
                    end: () => {//将then函数中的this传递到end的回调函数中
                        //刷新页面数据    1.直接查询selectAll实现    2.获取layer.appVersion更新当前pageInfo的该数据

                            this.selectAll(this.pageInfo.pageNum,this.pageInfo.pageSize);
                    }
                });
            }).catch(function (error) {
                console.log(error)
            })

        }
    },created:function (){
        this.selectAll();//在vue创建后调用函数返回数据
    }
});