let vm = new Vue({
    el: '#main-container',
    data: {

        appVersion: {}
    },
    methods: {
        updata: function () {

            console.log(this.appVersion);
        //
        //     // console.log(this.appVersion)
        //     axios({
        //         url: 'manager/company/work/waste',
        //         params: {id: this.appVersion}
        //     }).then(response => {
        //
        //         console.log(1111111111111111111);
        //
        //     }).catch(function (error) {
        //         console.log(error);
        //     })
        }
    },

    created: function () {
        this.appVersion = parent.layer.appVersion;
        this.updata();
    }
});