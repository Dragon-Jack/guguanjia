let vm = new Vue({
    el: '#main-container',
    data: function () {
        return {
            pageInfo: {
                pageNum: 1,
                pageSize: 5
            },
            condition: {
                name: "",
                type: "",
                inpu:"",
                username: ""
            },
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
        selectall: function (pageNum, pageSize) {
            this.condition.pageNum = pageNum;
            this.condition.pageSize = pageSize;
            axios({
                url: "manager/examine/index/examinePageInfo",
                method: "post",
                data: this.condition
            }).then(resp => {
                // console.log(this.condition)
                this.pageInfo = resp.data;
                this.nodes = resp.data;
            })
        },
        inittree: function () {
            axios({
                url: "manager/examine/index/node",

            }).then(resp => {

                this.nodes = resp.data;
                let nodeA = $.fn.zTree.init($("#pullDownTreeone"), this.setting, this.nodes);

                this.nodeAll = nodeA;
            })

        },
        beforeClick: function (treeId, treeNode) {
            this.condition.name = treeNode.name
            // console.log(treeNode)
        },
        key: function () {
            //查找匹配的节点
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
        this.selectall();
        this.inittree();
    }
});