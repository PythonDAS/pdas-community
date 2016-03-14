/**
 * Created by donghoon on 2016. 3. 13..
 */
function makeInput(name, value) {
    var objs = document.createElement('input');
    objs.setAttribute('type', 'hidden');
    objs.setAttribute('name', name);
    objs.setAttribute('value', value);
    return objs;
}
function makeForm(method, url) {
    var form = document.createElement('form');
    form.setAttribute('method', method);
    form.setAttribute('action', url);
    document.body.appendChild(form);
    return form;
}
function profileView(path, kakao_id, nick_name, profile_img, profile_img) {
    var form = makeForm("post", path);
    var objs = makeInput("kakao_id", kakao_id);
    var objs2 = makeInput("nick_name", nick_name);
    var objs3 = makeInput("profile_img", profile_img);
    var objs4 = makeInput("thumbnail_img", profile_img);
    form.appendChild(objs);
    form.appendChild(objs2);
    form.appendChild(objs3);
    form.appendChild(objs4);
    form.submit();
}