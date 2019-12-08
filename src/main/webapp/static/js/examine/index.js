let le = new Vue({
    el:"#page-content",
    data:{
        pageInfo:{
            pageNum:1,//默认值
            pageSize:5,
            userName:'',
            officeName:''
        },
    },methods:{
        selectAll:function (pageNum, pageSize) {
            //查询后台，返回分页数据，更新vue的pageInfo对象
            let index=axios({
                url:'manager/examine/index/index',
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
    },
    created:function (){
        this.selectAll();//在vue创建后调用函数返回数据
    }
});