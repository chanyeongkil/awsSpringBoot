console.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>index.js");
var main = {
    init: function () {
        console.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>init. function");
        var _this = this;
        $('#btn-save').on('click', function () {
            console.log("Save Button Clicked!!!!");
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });
    },
    save: function () {
        console.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>save. function");
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };
        console.log(data);
        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};
main.init();