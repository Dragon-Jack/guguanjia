// let vm = new Vue({
//     el: '#main-container',
//     data: {
//         pageInfo: {
//             pageNum: 1,
//             pageSize: 5,
//         },
//         params:{}
//     },
//     methods: {
//         serviceAll: function (pageNum, pageSize) {
//             this.params.pageNum = pageNum;
//             this.params.pageSize = pageSize;
//             axios({
//                 url: "manager/sysuser/serviceall",
//                 method: "post",
//                 data: this.params
//             }).then(resp => {
//                 this.pageInfo = resp.data;
//                 this.params = resp.data;
//                 console.log(this.params);
//             })
//         }
//     },
//     created: function () {
//         this.serviceAll();
//     }
// });

let vm = new Vue({
    el: '#main-container',
    data: function () {
        return {
            pageInfo: {
                pageNum: 1,
                pageSize: 5
            },

            params:{
                id:"",
                srname:"",
                name:"",
                offname:""
            },
            //.....传回后台在建个对象

            treenodes: {
                higtLine: true
            },

            setting: {
                data: {
                    simpleData: {
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
            nodes: [],
            nodeAll:{},
            name:""
        }

    },
    methods: {
        selectAll: function (pageNum, pageSize) {
            this.params.pageNum = pageNum;
            this.params.pageSize = pageSize;
            axios({
                url: "manager/sysuser/serviceall",
                method: "post",
                data: this.params
            }).then(resp => {
                this.pageInfo = resp.data;
                // this.params = resp.data;
                // console.log(this.params);
            })
        },

        inittree: function () {
            axios({
                url: "manager/sysuser/nodes",

            }).then(resp => {

                this.nodes = resp.data;
                //init($("#pullDownTreeone")        ul的id
                this.nodeAll = $.fn.zTree.init($("#ztree"), this.setting, this.nodes);

                console.log(this.nodeAll)
                console.log(this.nodes)
            })

        },
        beforeClick: function (treeId, treeNode) {
            this.condition.name = treeNode.name
        },
        key: function () {
            //查找匹配的节点                                        输入框的v-model
            let nodes = this.nodeAll.getNodesByParamFuzzy("name", this.name, null);
            //获取所有节点
            let treeNodes = this.nodeAll.transformToArray(this.nodeAll.getNodes());
            //请除高亮
            for (let index in treeNodes) {
                treeNodes[index].higtLine=false;
                this.nodeAll.updateNode(treeNodes[index])
            }

            //设置高亮
            for (let index in treeNodes) {
                for (let nodeindex in nodes) {
                    if (treeNodes[index].id == nodes[nodeindex].id) {
                        treeNodes[index].higtLine=true;

                        this.nodeAll.updateNode(treeNodes[index])
                    }
                }
            }
        },
        setcss: function (treeId, treeNode) {
            return treeNode.higtLine ? {color: "red"} : {color: ""}
        }
    },
    created: function () {
        this.selectAll();
        this.inittree();
    }
});