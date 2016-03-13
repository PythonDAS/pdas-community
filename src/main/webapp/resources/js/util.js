/**
 * Created by donghoon on 2016. 3. 13..
 */
function makeInput(name, value) {
    var objs = document.createElement('input');
    objs.setAttribute('type', 'hidden');
    objs.setAttribute('name', name);
    objs.setAttribute('value', value);
    return objs;
};

function makeForm(method, url) {
    var form = document.createElement('form');
    form.setAttribute('method', method);
    form.setAttribute('action', url);
    document.body.appendChild(form);
    return form;
};

function profileView(path) {
    var form = makeForm("post", path);
    // var objs = makeInput("userId", userId);
    // form.appendChild(objs);
    form.submit();
};