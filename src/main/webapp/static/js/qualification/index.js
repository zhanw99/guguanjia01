new Vue({
    el: "#page-content",
    data: {
        pageInfo: {
            pageNum: 1,//默认值
            pageSize: 5
        },
        params: {
            pageNum: 1,
            pageSize: 5,
            type: '',
            check: '',
            startDate: '',
            endDate: '',
            id: ''
        },
        appVersion:''
    }, methods: {
        selectAll: function (pageNum, pageSize) {
            axios({
                url: 'manager/qualification/index/index',
                params: {
                    pageNum: pageNum,
                    pageSize: pageSize,
                }
            }).then(response => {
                this.pageInfo = response.data;
            }).catch(function (error) {
                console.log(error)
            })
        },
        selectFuzzy: function () {
                this.params.type = this.$refs.foodWrapper1.value,
                this.params.check = this.$refs.foodWrapper2.value,
                this.params.startDate = this.$refs.foodWrapper3.value,
                this.params.endDate = this.$refs.foodWrapper4.value,
                axios({
                    url: 'manager/qualification/index/example',
                    method: "post",
                    data: this.params
                }).then(response => {
                    this.pageInfo = response.data;
                    console.log(this.pageInfo)
                }).catch(function (error) {
                    console.log(error)
                })
        },
        toUpdate: function (id) {
            axios({
                url: 'manager/qualification/index/toUpdate',
                params: {
                    id: id
                }
            }).then(response => {
                layer.appVersion = response.data;//返回数据，绑定到layer上，传递给子窗口
                console.log(layer)
                layer.open({
                    type: 2,
                    title: '查看用户状态',
                    area: ['700px', '450px'],
                    fixed: false, //不固定
                    maxmin: true,//开启最大化最小化按钮
                    content: 'html/qualification/update.html',
                    end: () => {//将then函数中的this传递到end的回调函数中
                        //刷新页面数据    1.直接查询selectAll实现    2.获取layer.appVersion更新当前pageInfo的该数据
                        this.selectAll();
                    }
                });
            }).catch(function (error) {
                console.log(error)
            })
        },

    }, created: function () {
        console.log("执行了")
        this.selectAll();//在vue创建后调用函数返回数据

    }
});