/**
 * Created by donghoon on 2016. 3. 11..
 */
$(document.body).ready(function () {
    Kakao.init('38e588cbe5f0544831d1dc3541cb0e45');
    $('#logout-btn').on('click', function () {
        Kakao.Auth.logout(function () {
            location.replace("http://localhost:8080/login");
        });
    });
});