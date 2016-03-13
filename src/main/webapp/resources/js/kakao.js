/**
 * Created by donghoon on 2016. 3. 11..
 */

$(document).ready(function () {
    $.getScript('http://localhost:8080/resources/js/util.js', function () {
        console.log("util script loaded!");
    });

    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('38e588cbe5f0544831d1dc3541cb0e45');

    var host = "http://localhost:8080/";

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
                            var kakao_id = response.id;
                            var nick_name = response.properties.nickname;
                            var profile_img = response.properties.profile_image;
                            var thumbnail_img = response.properties.thumbnail_image;

                            //kakao 테이블에서 kakao_id 조회.  --->  jquery ajax call, 대응 rest controller method.
                            //가입된 회원인지 DB 체크.(param: kakaoId)
                            $.ajax({
                                url: host + "check_kakao_id",
                                type: "post",
                                data: {
                                    kakao_id: kakao_id
                                },
                                success: function (response) {
                                    if (response === "EXISTID") {
                                        profileView("profile");
                                    } else if (response === "NOTEXISTID") {
                                        //획득한 kakao 정보 전송.
                                        $.ajax({
                                            url: host + "insert_kakao_info",
                                            type: "post",
                                            data: {
                                                kakao_id: kakao_id,
                                                profile_img: profile_img,
                                                thumbnail_img: thumbnail_img
                                            },
                                            success: function () {
                                                profileView("/resources/pages/profile");
                                            },
                                            error: function (error) {
                                                alert("Nick: " + nick_name);
                                                alert("Server Error!" + JSON.stringify(error));
                                            }
                                        })
                                    }
                                },
                                error: function (error) {
                                    alert("Server Error!" + JSON.stringify(error));
                                }
                            });
                        }
                    });
                    //있으면 proile 페이지 이동.
                    //없으면 kakao info update 후 profile 페이지 이동.
                },
                fail: function (err) {
                    alert(JSON.stringify(err));
                }
            });
        });
    });
});
