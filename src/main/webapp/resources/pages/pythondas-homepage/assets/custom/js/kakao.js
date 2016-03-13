$(document).ready(function () {
    $.getScript('/resources/js/constants.js', function () {
        console.log("constant script loaded!");
    });

    // 카카오 로그인 버튼 click 이벤트.
    $('#kakao-login-btn').on('click', function () {
        //로그인 버튼 클릭시 마다 인증을 하기 위해 로그아웃을 먼 실행.
        Kakao.Auth.logout(function () {
            Kakao.Auth.login({
                persistAccessToken: true,
                persistRefreshToken: true,
                success: function () {
                    location.replace("http://ec2-52-79-88-81.ap-northeast-2.compute.amazonaws.com:8080");
                },
                fail: function (err) {
                    alert(JSON.stringify(err));
                }
            });
        });
    });
});
