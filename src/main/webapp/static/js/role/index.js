let vm = new Vue({
    el: '#main-container',
    data: {
        pageInfo: {
            pageNum: 1,
            pageSize: 5
        },
        params:{
        },
        pp:{
            srname:'',
            aa:''
        }

    },
    methods: {
        selectAll: function (pageNum, pageSize) {
            this.params.pageNum=pageNum;
            this.params.pageSize=pageSize;
            axios({
                url: 'manager/role/section',
                params: this.params
            })
                .then(response => {
                    this.pageInfo = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        toselect: function (srname) {
            this.pp.srname=srname;
            axios({
                url: 'manager/role/toselect',
            }).then(response => {
                    this.pp.aa=response.data;
                    layer.appVersion = this.pp;

                    layer.open({
                        type: 2,
                        title: "更新数据",
                        content: "html/role/role-user.html",
                        area: ["80%", "80%"],
                        end: function () {
                        }
                    })
                }).catch(function (error) {
                    console.log(error);
                })
        }
    },
    created: function () {
        this.selectAll();
    }
});