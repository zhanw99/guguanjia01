new Vue({
    el:'#page-content',
    data:{
        pageInfo:{
            pageNum:'',
            pageSize:'',
        },
        rid:[],
        uid:'',
        name:''
    },
    methods:{
        selectAll:function (pageNum,pageSize) {
           this.pageInfo.pageNum = pageNum,
           this.pageInfo.pageSize = pageSize,
            axios({
                url: 'manager/sysuser/user',
                method:'post',
                data: this.pageInfo,
            }).then(response => {
                this.pageInfo= response.data
                console.log(response.data)
            }).catch(function (error) {
                console.log(error)
            })
        },
        selectBy:function (rid,uid,name) {
            this.rid=this.$refs.rid.value,
            this.uid=this.$refs.uid.value,
            this.name=this.$refs.name.value,
            console.log(this.rid);
            console.log(this.uid);
            console.log(this.name);
        }
    },
    created:function () {
        this.selectAll()
    }
})