let vm = new Vue({
    el: '#main-container',
    data: {
        pageInfo: {
            pageNum: 1,
            pageSize: 5,
            check: "",
            type: "",
            begin: "",
            end: "",
        }

    },
    methods: {
        qua: function (pageNum, pageSize) {
            this.pageInfo.pageNum = pageNum;
            this.pageInfo.pageSize = pageSize;
            axios({
                url: "manager/qualification/index/toselect",
                method: "post",
                data: this.pageInfo
            }).then(resp => {
                this.pageInfo = resp.data;
            })
        },
        toupdata: function (id) {
            axios({
                url: "manager/qualification/index/toupdata",
                params: {id: id}
            }).then((resp) => {
                layer.appVersion = resp.data;
                layer.open({
                    type: 2,
                    title: "资质审核",
                    content: "html/qualification/update.html",
                    area: ["80%", "80%"],
                    end: () => {
                        this.qua(this.pageInfo.pageNum, this.pageInfo.pageSize);
                    }
                })
            }).catch(function (error) {
                console.log(error);
            })
        }
    },
    created: function () {
        this.qua();
    }
});