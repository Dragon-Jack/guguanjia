let vm = new Vue({
    el: '#main-container',
    data: {
        pageInfo: "",
        appVersion:{},

    },
    methods: {
        selectAll: function (pageNum, pageSize) {
            axios({
                url: 'manager/app/index/all',
                params: {
                    pageNum: pageNum,
                    pageSize: pageSize
                }
            })
                .then(response => {
                    console.log(response.data);
                    this.pageInfo = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        },


        toupdata: function (id) {
            axios({
                url: 'manager/app/index/toupdata',
                params: {id: id}
            })
                .then(response => {
                    console.log(response.data);
                    layer.appVersion = response.data;
                    layer.open({
                        type: 2,
                        title: "更新数据",
                        content: "html/app/update.html",
                        area: ["80%", "80%"],
                        end: () => {
                            this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
                        }
                    })
                })
                .catch(function (error) {
                    console.log(error);
                })
        },

        todelete: function (id) {
            axios({
                url: 'manager/app/index/deletefalse',
                params: {id: id}
            })
                .then(response => {
                    console.log(response.data);
                    layer.msg(response.data);

                    this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize);

                })
                .catch(function (error) {
                    console.log(error);
                })
        },

        appadd:function(){
            // console.log(this.addapp)
            axios({
                url: 'manager/app/index/appadd',
                method:"post",
               data:this.appVersion
            })
                .then(response => {
                    // console.log(response.data);
                    layer.msg(response.data);
                    // this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    },
    created: function () {
        this.selectAll();//在vue创建后调用函数返回数据
    }
});