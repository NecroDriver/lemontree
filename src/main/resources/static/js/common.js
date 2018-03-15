function getUrlValue (name) {
    var reg = new RegExp("(^|&)"+name+"=([^&]*)(&|$)");
    var result = location.search.substring(1).match(reg);
    return result == null ? null : decodeURIComponent(result[2]);
}