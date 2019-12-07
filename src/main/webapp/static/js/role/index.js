new Vue({
    el: "#page-content",
    data: {
        pageInfo:{
            pageNum:'',
            pageSize:''
        },
        listScope:{},
        params:{
            dataScope:'',
        },
        /*setting:{//zTree设置对象
            data:{//zTree的data数据设置配置
                key:{
                    title: "fullName",//将//将treeNode的fullName作为节点的title  ztree对象下面的节点对象就叫treeNode
                },
                simpleData:{
                    enable:true//使用极简数组模式传入nodes给zTree
                }
            }
        },*/
        setting:{//ztree设置对象
            data:{//ztree的data数据设置配置
                /**
                 * 非极简模式：
                 * [
                 * {"id":1,"name":"父节点1",children:[{{"id":3,"name":"父节点1的字节点1",children:[]},{},{}]}
                 * {"id":2,"name":"父节点2",children:[{},{},{}]}
                 * ]
                 *
                 * 极简模式:						 *
                 *[
                 * {"id":1,"name":"父节点1",pId:0},
                 * {"id":2,"name":"父节点2",pId:0},
                 * {"id":3,"name":"父节点1字节的1",pId:1},
                 * {"id":4,"name":"父节点2字节的1",pId:2}
                 * ]
                 */
                simpleData:{
                    enable:true,//使用极简数组模式传入nodes给ztree
                    pIdKey:'parentId'
                }
            }
        },
        // nodes:[]
        nodes:[
            {id:1,name:"父节点1",pId:0},
            {id:2,name:"父节点2",pId:0},
            {id:3,name:"父节点1字节的1",pId:1},
            {id:4,name:"父节点2字节的1",pId:2},
            {id:5,name:"父节点2字节的2",pId:2}
        ]

    }, methods: {
        selectAll:function(pageNum,pageSize){
            this.pageInfo.pageNum=pageNum;
            this.pageInfo.pageSize=pageSize
            axios({
                url:'manager/role/role',
                method:'post',
                data:this.pageInfo
            }).then(response=>{
                this.pageInfo=response.data;
            }).catch(function (error) {
                console.log(error)
            })
        },
        updataById:function (id) {
            layer.rid=id
                layer.open({
                    type: 2,
                    title: '查看用户状态',
                    area: ['80%', '80%'],
                    fixed: false, //不固定
                    maxmin: true,//开启最大化最小化按钮
                    content: 'html/role/role-user.html',
                    end: () => {//将then函数中的this传递到end的回调函数中
                        //刷新页面数据    1.直接查询selectAll实现    2.获取layer.appVersion更新当前pageInfo的该数据
                        this.selectAll();
                    }
                });
        },
        selectByDataScope:function () {
            axios({
                url:'manager/role/dataScope',
            }).then(response=> {
                this.listScope= response.data;
                // console.log(this.listScope);
            }).catch(function (error) {
                console.log(error)
            })
        },
        dataScope:function () {
            this.params.dataScope = this.$refs.foodWrapper1.value,
            console.log(this.params.dataScope)
        },
        initTree:function () {
            axios({
                url:'manager/role/officeName',
            }).then(response=> {
                // this.nodes= response.data;
                console.log(this.nodes);
                //初始化zTree
                let treeObj = $.fn.zTree.init($("#treeDemo"),this.setting,this.nodes);
                 console.log(treeObj);
            }).catch(function (error) {
                console.log(error);
            })
        }
    },
    created: function () {
        this.selectAll();
        this.selectByDataScope();
    },
    mounted:function () { //dom节点挂在 已经有节点对象了
        this.initTree();
    }
});