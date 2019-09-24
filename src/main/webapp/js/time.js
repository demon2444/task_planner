


document.addEventListener('DOMContentLoaded', (event) => {


    function ShowLocalDate() {
        let dNow = new Date();
        let localdate = (dNow.getMonth() + 1) + '/' + dNow.getDate() + '/' + dNow.getFullYear() + ' ' + dNow.getHours() + ':' + dNow.getMinutes();
        $('#currentDate').text(localdate)
    }


});