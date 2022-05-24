function openFunction() {
    document.getElementById('menu').style.width = '250px';
    document.getElementById('layer').style.marginLeft = '250px';
    document.body.style.backgroundColor = "rgba(0,0,0,0.4)";

}
function closeFunction() {
    document.getElementById('menu').style.width = '0';
    document.getElementById('layer').style.marginLeft = '0';
    document.body.style.backgroundColor = "rgba(0,0,0,0)";
}

window.addEventListener('mouseup', function (event) {
    var box = document.getElementById('menu');
    if (event.target != box) {
        closeFunction();
    }
})