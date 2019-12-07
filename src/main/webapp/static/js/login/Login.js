let vm = new Vue({
    el: '#main-container',
    data: {

        params: {}
    },
    methods: {
        Login: function () {
            axios({
                url: 'login',
                method: "post",
                data: this.params
                })
                .then(response => {

                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    },
    created: function () {
    }
});