/**
 * Created by donghoon on 2016. 3. 11..
 */
$(document.body).ready(function () {
    $.getScript('/resources/js/constants.js', function () {
        console.log("constant script loaded!");
    });

    $.getScript('/resources/js/util.js', function () {
        console.log("util script loaded!");
    });

    $('#logout-btn').on('click', function () {
        Kakao.Auth.logout(function () {
            location.replace("http://localhost:8080/login");
        });
    });

    //profile logo page 이동.
    $('.profile-page').on('click', function () {
        Kakao.API.request({
            url: '/v1/user/me',
            success: function (response) {
                kakao_id = response.id;
                profileView("/resources/pages/profile", kakao_id);
            }
        });
    });
});