$(function () {

    let time = new Date();
    let timeForm = time.getHours() + ":" + time.getMinutes() + ":" + time.getSeconds();
    //console.log(time);

    function showTime() {
        setInterval(timeForm, 1000)

    }


    let show = $('#show')
    show.on('click', function () {
      //timeForm
        return showTime()
        //showTime()
    })


    $(document).ready(function() {
        var date = new Date();

        var day = date.getDate();
        var month = date.getMonth() + 1;
        var year = date.getFullYear();

        if (month < 10) month = "0" + month;
        if (day < 10) day = "0" + day;

        var today = year + "-" + month + "-" + day;
        $("#theDate").attr("value", today);
    });


})