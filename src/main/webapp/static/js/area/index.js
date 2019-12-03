let vm = new Vue({
    el: '#main-container',
    data: function () {
        return {
            pageInfo: {
                pageNum: 1,
                pageSize: 5
            },
            condition:{},
            //.....传回后台在建个对象

            treenodes: {
                higtLine: true
            },

            setting: {
                data: {
                    simpleData: {
                        pIdKey: "parentId",  //设置父id
                        enable: true         //设置极简模式
                    }
                },
                callback: {
                    beforeClick: this.beforeClick,
                },
                view: {
                    fontCss: this.setcss
                }

            },
            nodes: [
            ],
            nodeAll: {},
            name: ""
        }

    },
    methods: {
        // selectAll: function (pageNum, pageSize) {
        //     this.condition.pageNum = pageNum;
        //     this.condition.pageSize = pageSize;
        //     axios({
        //         url: "manager/examine/index/examinePageInfo",
        //         method: "post",
        //         data: this.condition
        //     }).then(resp => {
        //
        //         this.pageInfo = resp.data;
        //         this.nodes = resp.data;
        //     })
        // },
        writeExcel:function(){
            axios({
                url: "manager/area/writeExcel",
            }).then(resp => {

               console.log("成功");
            })
        },
        readExcel:function(e){
            let file=e.target.files[0];
            let form = new FormData();//构建表单对象
            form.append("file",file);//绑定file对象到key file上，该key必须与后台的接收参数名一致
            axios({
                url: 'manager/area/readExcel',
                method: 'post',
                header:{"content-type":'multipart/form-data'},
                data: form
            }).then(resp => {
                this.inittree();
                console.log("成功");
            })
        },

        inittree: function () {
            axios({
                url: "manager/area/Region",

            }).then(resp => {
                this.nodes = resp.data;
                //init($("#pullDownTreeone")        ul的id
                this.nodeAll = $.fn.zTree.init($("#treeMenu"), this.setting, this.nodes);
            })

        },
        beforeClick: function (treeId, treeNode) {
            this.condition.name = treeNode.name
        }
    },
    created: function () {
        // this.selectAll();
        this.inittree();
    }
});