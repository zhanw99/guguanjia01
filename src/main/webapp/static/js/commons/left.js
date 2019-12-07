new Vue({
    el: '#treeMenu',
    data: {
        setting: {
            data: {
                simpleData: {
                    enable: true,
                    idKey: 'id',
                    pIdKey: 'parentId',
                    rootPId: 0
                }
            }
        },

        nodes: '',
    },
    methods: {
        initTree: function () {
            //获取session中的用户权限，如果不为空则直接调用showTree
            let userInfo = sessionStorage.getItem("userInfo");
            //保存在sessionStorage会话中的是字符串，需要转换成json对象
            //换成json对象后再转换数据结构为树形存储对应的结构
            this.nodes = JSON.parse(userInfo).resources;//转成成Json对象
            let treeObj = $.fn.zTree.init($("#treeMenu"), this.setting, this.nodes);
            //console.log(JSON.parse(userInfo));//转换成json对象
            // console.log("******");
            // console.log(this.nodes);
            //转换成树结构方式存储
            //this.nodes = treeObj.getNodes();
            // console.log(this.nodes);
            //获取menu的菜单根元素ul
            //let ul = $("#sidebar-menu");
            //this.showall(this.nodes, ul);
            // console.log(ul.html);

        },
        //menu_list为json数据,parent为要组合成html的容器
        // showall: function (menu_list, parent) {
        //     console.log(menu_list.length)
        //     for (let i = 0; i < menu_list.length; i++) {
        //         //构造一个li
        //         let li = $("<li></li>");
        //         li.append(` <a :href="javascript:void(0);"
        //                             class="dropdown-toggle" haschild="true">
        //                                 <i class="menu-icon ${menu_list[i].icon}"></i>
        //                     <span class="menu-text" style="vertical-align: middle;" > ${menu_list[i].name} </span>
        //                     <b class="arrow fa fa-angle-down"></b>
        //                             </a>
        //                     <b class="arrow"></b>`);
        //         //判断当前的menu_list有没有子元素，如果有则在当前的li中递归调用当前的方式showall
        //         //console.log(menu_list[i].children);
        //         if (menu_list[i].children != undefined && menu_list[i].children.length > 0) {
        //             let ul = $("<ul></ul>");
        //             li.append(ul);
        //             this.showall(menu_list[i].children, ul);
        //         }
        //         parent.append(li);
        //
        //     }
        // },
    },
    created: function () {
        //再vue对象创建的时候，进行判断   从sessionStorage中校验是否存在登录信息  ，如果没有则跳转到登录页面
        let userInfo = sessionStorage.getItem("userInfo");
        console.log(JSON.parse(userInfo));
        if(userInfo==null){//未登录
            layer.msg("请登录后访问",{time:500},function(){
                location.href='login.html';
            });
        }
    },mounted: function () {
        this.initTree();
    }
})