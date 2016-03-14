/**
 * Created by donghoon on 2016. 3. 11..
 */

$(document).ready(function () {
    $.getScript('/resources/js/constants.js', function () {
        console.log("constant script loaded!");
    });

    $.getScript('/resources/js/util.js', function () {
        console.log("util script loaded!");
    });

    // 카카오 로그인 버튼 click 이벤트.
    $('#kakao-login-btn').on('click', function () {
        //로그인 버튼 클릭시 마다 인증을 하기 위해 로그아웃을 먼 실행.
        Kakao.Auth.logout(function () {
            Kakao.Auth.login({
                persistAccessToken: true,
                persistRefreshToken: true,
                success: function () {
                    //location.replace("http://ec2-52-79-88-81.ap-northeast-2.compute.amazonaws.com");
                    //location.replace("http://localhost:8080/profile");
                    //kakao 로 부터 유저 정보 획득.
                    Kakao.API.request({
                        url: "/v1/user/me",
                        success: function (response) {
                            // kakao 유저 정보 획득 후 변수 저장.
                            kakao_id = response.id;
                            nick_name = response.properties.nickname;
                            profile_img = response.properties.profile_image;
                            thumbnail_img = response.properties.thumbnail_image;

                            // 메인 프로필 페이지 이동.
                            profileView(host + "/resources/pages/profile", kakao_id, nick_name, profile_img, thumbnail_img);
                        }
                    });
                },
                fail: function (err) {
                    alert(JSON.stringify(err));
                }
            });
        });
    });
    //login-btn end.

});
