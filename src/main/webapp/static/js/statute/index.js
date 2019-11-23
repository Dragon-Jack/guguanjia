let vm = new Vue({
    el: '#main-container',
    data: {
        pageInfo: {
            pageNum: 1,
            pageSize: 5,
            type:''
        },
        pp:{
            pageNum: 1,
            pageSize: 5,
        },
        layerdata:{

        },
        paramm:{
            stemFrom:'',
            pubDate:'',
            type:'',
            title:'',
            description: '<h2><img src="http://img.baidu.com/hi/jx2/j_0003.gif"/>Vue + UEditor + v-model双向绑定</h2>'
        },
        myConfig: {
            // 如果需要上传功能,找后端小伙伴要服务器接口地址
            // serverUrl: 'http://localhost:8090/ueditor/ueditorConfig',
            // 你的UEditor资源存放的路径  path是全局声明的应用路径
            //'/static/ueditor/'是应用下存放ueditor文件位置注意最后一个"/"不能省略
            UEDITOR_HOME_URL: 'static/ueditor/',
            // 编辑器不自动被内容撑高
            autoHeightEnabled: false,
            // 工具栏是否可以浮动
            autoFloatEnabled: false,
            // 初始容器高度
            initialFrameHeight: 340,
            // 初始容器宽度
            initialFrameWidth: '100%',
            // 关闭自动保存
            enableAutoSave: true,
            // 上传文件接口（
            serverUrl: 'http://localhost:8080/controller'
        }

    },
    methods: {
        selectAll: function (pageNum, pageSize) {
            this.pageInfo.pageNum = pageNum;
            this.pageInfo.pageSize = pageSize;

            axios({
                url: "manager/statute/index/statute",
                method:"post",
                data: this.pageInfo
            }).then(resp => {

                this.pageInfo = resp.data;
            }).catch(function (e) {
                console.log(e);
            })
        },
        select:function(pageNum, pageSize){
            this.pp.pageNum = pageNum;
            this.pp.pageSize = pageSize;

            axios({
                url: "manager/statute/index/statute",
                method:"post",
                data: this.pp
            }).then(resp => {
                this.pageInfo = resp.data;
            }).catch(function (e) {
                console.log(e);
            })
        },
        toadd:function () {

            axios({
                url: "manager/statute/index/staadd",
                method: "post",
                data: this.paramm
            }).then(resp => {
                console.log(resp.data);
                layer.msg(resp.data);
            }).catch(function (e) {
                console.log(e);
            })
        },
        toupdata: function (id) {
            axios({
                url: 'manager/statute/index/toupdata',
                params: {id: id}
            })
                .then(response => {
                    console.log(response.data);
                    layer.layerdata = response.data;
                    layer.open({
                        type: 2,
                        title: "更新数据",
                        content: "html/statute/update.html",
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
        todelete:function (id) {
            axios({
                url: "manager/statute/index/delete",
                params: {id:id}
            }).then(resp => {
                this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
                layer.msg(resp.data);
            }).catch(function (e) {
                console.log(e);
            })
        }

    },
    created: function () {
        this.selectAll();
    },
    components: {
        VueUeditorWrap
    },
});