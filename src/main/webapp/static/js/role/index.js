let vm = new Vue({
    el: '#main-container',
    data: {
        pageInfo: {
            pageNum: 1,
            pageSize: 5
        },
        params:{}

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
                    // console.log(response.data);
                    this.pageInfo = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        }, toselect: function () {
            axios({
                url: 'manager/role/toselect',
            })
                .then(response => {
                    layer.appVersion = response.data;
                    layer.open({
                        type: 2,
                        title: "更新数据",
                        content: "html/role/role-user.html",
                        area: ["80%", "80%"],
                        end: function () {
                        }
                    })
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    },
    created: function () {
        this.selectAll();
    }
});