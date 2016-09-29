/**
 * 框架js
 */
var Frame = function() {
    var frame_foreach = document.getElementsByTagName('frame:foreach');
    for ( var frame in frame_foreach) {
        var list = frame.list;
        for ( var item in list) {
            item.clone(true);
            item.getElementsByTagName()
        }
    }
};