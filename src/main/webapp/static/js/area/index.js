var vm = new Vue({
    el: '#main-container',
    data: function () {
        return {
            pageInfo: {
                pageNum: 1,
                pageSize: 5
            },
            setting: {
                data: {
                    simpleData: {
                        enable: true,
                        pIdKey: 'parentId'//根据node节点中的parentId属性来作为pId属性值
                    }
                },
                callback: {
                    // beforeClick:this.beforeClick,
                    onClick: this.onClick
                },
                view: {
                    fontCss: this.setCss
                }
            },
            nodes: [],
            treeObj: {},
            params: {
                pageNum: '',
                pageSize: '',
                areaName: '',//默认值，让下拉出现的时候默认被选中
                aid: 0,
                name: ''
            },
            //模糊查询绑定事件
            inputval: '',
            appVersion:{
            }
        }
    },
    methods: {
        toUpdate: function (id) {
            console.log(id)
            axios({
                url: 'manager/area/toUpdate',
                params: {
                    aid:id
                },
            }).then(response => {
                console.log(response.data);
                layer.appVersion = response.data;
                console.log(layer.appVersion.code);
                layer.open({
                    type: 2,
                    area: ['700px', '450px'],
                    fixed: false, //不固定
                    maxmin: true,
                    content: 'html/area/area-save.html'
                });

            }).catch(function (error) {
                console.log(error)
            })

        },
        toUpdateNameAndAll: function (pageNum, pageSize) {
            this.params.pageNum = pageNum;
            this.params.pageSize = pageSize;
            this.params.name = this.inputval
            axios({
                url: 'manager/area/selectByPageName',
                method: 'post',
                data: this.params
            }).then(response => {
                // console.log(this.params.name)
                this.pageInfo = response.data;
            }).catch(function (error) {
                console.log(error)
            })
        },
        update: function () {


        },
        toDelete: function (id) {

        },
        deleteById: function () {

        },
        save: function () {

        },
        // 导出Excel
        exportExcel: function () {
            location.href = 'manager/area/exportExcel';
        },
        //导入数据
        importExcel: function (e) {
            //console.log(e.target);//获取事件源对象   input
            let file = e.target.files[0];//获取上传的文件对象
            let form = new FormData();//构建表单对象
            form.append("file", file);//绑定file对象到key file上，该key必须与后台的接收参数名一致
            //获取nodes
            axios({
                url: 'manager/area/importExcel',
                method: "post",
                headers: {"content-type": 'multipart/form-data'},//设置请求头为文件上传
                data: form
            }).then(response => {
                layer.msg(response.data.msg);

            }).catch(function (error) {
                layer.msg(error);
            })
        },
        //初始化ztree
        initTree: function () {
            //获取nodes
            axios({
                url: 'manager/area/ztree'
            }).then(response => {
                this.nodes = response.data;
                console.log(response.data);
                this.treeObj = $.fn.zTree.init($("#treeMenu"), this.setting, this.nodes);
            }).catch(function (error) {
                layer.msg(error);
            })
        },
        //treeId:树节点id， treeNode:当前触发事件的节点
        beforeClick: function (event, treeId, treeNode) {
            // console.log(treeId);
            // console.log(treeNode);
        },
        onClick: function (event, treeId, treeNode) {
            console.log(treeId);
            console.log(treeNode);
            this.name = treeNode.name;
        },
        // 高亮显示找到的节点//搜索处理
        search: function () {
            // console.log(this.inputval);
            //进行模糊查询所有节点
            let nodes = this.treeObj.getNodesByParamFuzzy("name", this.inputval, null)
            //给当前ztree中找到的nodes设置高亮标记
            //更新节点，ztree会自动调用  显示方法fontColor
            console.log(this.treeObj.getNodes());
            //根据传入的节点数组转换成简单节点数组结构
            let treeNodes = this.treeObj.transformToArray(this.treeObj.getNodes());
            //清除原高亮标记
            for (let index in treeNodes) {
                // 清除
                treeNodes[index].higtLine = false;
                this.treeObj.updateNode(treeNodes[index]);//更新节点，自动调用清除css
            }
            // console.log(treeNodes);
            for (let index in treeNodes) {
                // console.log(treeNodes[index]);
                //从ztree的所有节点对象中查找出搜索到的节点，添加标记
                for (let nodeIndex in nodes) {
                    if (treeNodes[index].id == nodes[nodeIndex].id) {
                        // console.log(nodes[nodeIndex].id+"******")
                        treeNodes[index].higtLine = true;//设置高亮标记
                        //更新节点  会触发自动的设置css等回调
                        this.treeObj.updateNode(treeNodes[index])
                    }
                }
            }
            if (this.inputval == null || this.inputval == "") {
                //清除原高亮标记
                for (let index in treeNodes) {
                    // 清除
                    treeNodes[index].higtLine = false;
                    this.treeObj.updateNode(treeNodes[index]);//更新节点，自动调用清除css
                }
            }

        },
        setCss: function (treeId, treeNode) {
            return treeNode.higtLine ? {color: "red"} : {color: ''};//根据标记显示高亮
        }
    },
    created: function () {
        this.toUpdateNameAndAll();
    },
    mounted: function () {
        this.initTree();

    }

});