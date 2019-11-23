let vm = new Vue({
    el: '#main-container',
    data: {
        layerdata: {
            description: '<h2><img src="http://img.baidu.com/hi/jx2/j_0003.gif"/>Vue + UEditor + v-model双向绑定</h2>'
        },
        // paramm:{
        //     stemFrom:'',
        //     pubDate:'',
        //     type:'',
        //     title:'',
        //     description: '<h2><img src="http://img.baidu.com/hi/jx2/j_0003.gif"/>Vue + UEditor + v-model双向绑定</h2>'
        // },
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
        updata: function () {
            axios({
                url: 'manager/statute/index/updata',
                method: "post",
                data: this.layerdata,
            }).then(response => {
                console.log(response.data);
                parent.layer.msg(response.data);//给父窗口弹窗赋值
                //关闭子窗口
                let index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            }).catch(function (error) {
                console.log(error);
            })
        },

    },
    created: function () {
        this.layerdata = parent.layer.layerdata;
    },
    components: {
        VueUeditorWrap
    },
});


