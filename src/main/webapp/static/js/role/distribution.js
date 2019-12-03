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
            condition: {},
            selected: {},

            //-----------------------------------
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
            nodeAll: {},
            name: ""
        }

    },
    methods: {
        selectAll: function () {
            axios({
                url: 'manager/role/roledis',
                params: {srname: this.appVersion.srname}
            }).then(resp => {
                this.selected = resp.data;
            }).catch(function (e) {
                console.log(e)
            })
        },
        toselected: function () {
            axios({
                url: 'manager/role/roledis',
                params: {srname: this.appVersion.srname}
            }).then(resp => {
                this.selected = resp.data;

            }).catch(function (e) {
                console.log(e)
            })
        },


        inittree: function () {
            this.nodeAll = $.fn.zTree.init($("#treeOffice"), this.setting, this.nodes);

        },
        beforeClick: function (treeId, treeNode) {
            this.condition.name = treeNode.name
        },
        key: function () {

        },
        setcss: function (treeId, treeNode) {
            return treeNode.higtLine ? {color: "red"} : {color: ""}
        }
    },
    created: function () {
        this.appVersion = parent.layer.appVersion;
        this.nodes = this.appVersion.aa;
        this.selectAll();
        this.inittree();
    }
});