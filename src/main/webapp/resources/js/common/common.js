/**
 * 更改验证码
 * @param img
 */
function changeVerifyCode(img){
    img.src="../Kaptcha?" + Math.floor(Math.random() * 100);
}

/**
 * 从url中获取某一参数的参数值
 */
function getQueryString(name) {
    //匹配以&name=开头 或者 name=开头 中间为任意多个除了&以外的字符
    //一旦遇到& 或者 空白就终止取值
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r != null) {
        return decodeURIComponent(r[2]);
    }
    return '';
}