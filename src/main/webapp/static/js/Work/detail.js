let vm = new Vue({
    el: '#main-container',
    data: {

        appVersion: {},
        detailData: {},
        transportData:{}
    },
    methods: {
        waste: function () {

            axios({
                url: 'manager/company/work/waste',
                params: {id: this.appVersion.id}
            }).then(response => {
                this.detailData = response.data;
            }).catch(function (error) {
                console.log(error);
            })
        },
        transport: function () {

            axios({
                url: 'manager/company/work/transport',
                params: {id: this.appVersion.id}
            }).then(response => {
                this.transportData = response.data;
            }).catch(function (error) {
                console.log(error);
            })
        }
    },

    created: function () {
        this.appVersion = parent.layer.appVersion;
        this.waste();
        this.transport();
    }
});