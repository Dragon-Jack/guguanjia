let vm = new Vue({
    el: '#main-container',
    data: function () {
        return {
            pageInfo: {
                pageNum: 1,
                pageSize: 5
            },
            appVersion: {},
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
        selectAll: function () {
            // axios({
            //     url: "",
            //     method: "post",
            //     data: ""
            // }).then(resp => {
            //
            //     this.pageInfo = resp.data;
            //     this.nodes = resp.data;
            // })
        },
        inittree: function () {
            this.nodeAll = $.fn.zTree.init($("#treeOffice"), this.setting, this.nodes);

            console.log(this.nodes);
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
        this.appVersion = parent.layer.appVersion;
        this.nodes =this.appVersion;
        this.selectAll();
        this.inittree();
    }
});