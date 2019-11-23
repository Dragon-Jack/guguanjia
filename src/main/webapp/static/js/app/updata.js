let vm = new Vue({
    el: '#main-container',
    data: {
        appVersion: ""
    },
    methods: {
        updata: function () {
            axios({
                url: 'manager/app/index/updata',
                method: "post",
                data: this.appVersion,
            }).then(response => {

                parent.layer.msg(response.data);//给父窗口弹窗赋值
                //关闭子窗口
                let index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            }).catch(function (error) {
                console.log(error);
            })
        }
    },
    created: function () {
        this.appVersion = parent.layer.appVersion;
    }
});


