/**
 * Created by donghoon on 2016. 3. 11..
 */

$(document).ready(function () {
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('38e588cbe5f0544831d1dc3541cb0e45');

    // 카카오 로그인 버튼 click 이벤트.
    $('#kakao-login-btn').on('click', function () {
        //로그인 버튼 클릭시 마다 인증을 하기 위해 로그아웃을 먼 실행.
        Kakao.Auth.logout(function () {
            Kakao.Auth.login({
                persistAccessToken: true,
                persistRefreshToken: true,
                success: function () {
                    //location.replace("http://ec2-52-79-88-81.ap-northeast-2.compute.amazonaws.com");
                    location.replace("http://localhost:8080/profile");
                },
                fail: function (err) {
                    alert(JSON.stringify(err));
                }
            });
        });
    });
});
